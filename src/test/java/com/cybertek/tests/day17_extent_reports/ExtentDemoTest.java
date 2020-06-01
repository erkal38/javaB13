package com.cybertek.tests.day17_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        report=new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path=projectPath+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Vytrack Smoke Test");
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser","Chrome");
        report.setSystemInfo("Tester","Cybertek Testers");



    }
   @Test
    public void test1(){
        extentLogger=report.createTest("TC123 login as Driver Test");

        extentLogger.info("Open Chrome");
        extentLogger.info("go to url");
        extentLogger.info("enter driver username and password");
        extentLogger.info("click submit");
        extentLogger.info("verify logged in");
        extentLogger.pass("TC123 is passed");
   }
     @AfterMethod
    public void tearDown(){
        report.flush();
     }
}
