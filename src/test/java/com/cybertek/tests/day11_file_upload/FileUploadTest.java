package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }
    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@name='file']"));
        chooseFile.sendKeys("C:\\Users\\Ergün\\Desktop\\Text.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        String expectedText = "Text.txt";
        Assert.assertEquals(actualText, expectedText);
    }
        @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@name='file']"));
            String projectPath = System.getProperty("user.dir");
            String relativePath="src/test/resources/testfile.txt";
            String filePath = projectPath + "/" + relativePath;
        chooseFile.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        String expectedText="testfile.txt";
        Assert.assertEquals(actualText,expectedText);


    }

}
