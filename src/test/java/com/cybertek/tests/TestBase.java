package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.BasePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {
   protected WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;
    protected String url;

   @BeforeTest
   public void setUpTest(){
       report=new ExtentReports();
       String projectPath = System.getProperty("user.dir");
       String path=projectPath+"/test-output/report.html";
       htmlReporter=new ExtentHtmlReporter(path);
       report.attachReporter(htmlReporter);
       htmlReporter.config().setReportName("Vytrack Smoke Test");
       report.setSystemInfo("Environment","QA");
       report.setSystemInfo("Browser","Chrome");
       report.setSystemInfo("Tester","Cybertek Testers");
       report.setSystemInfo("OS",System.getProperty("os.name"));
   }

    @BeforeMethod
    public void setupMethod() {
        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException, IOException {
       if(result.getStatus()==ITestResult.FAILURE){
           extentLogger.fail(result.getName());
           String screenshot = BrowserUtils.getScreenshot(result.getName());
           extentLogger.addScreenCaptureFromPath(screenshot);
           extentLogger.fail(result.getThrowable());
       }

        Thread.sleep(3000);
        Driver.closeDriver();
    }
    @AfterTest
    public void tearDownTest(){

       report.flush();
    }
}
