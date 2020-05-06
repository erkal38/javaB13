package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Q6Q8 {

        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void afterMethod() throws InterruptedException {
            //Thread.sleep(3000);
            //driver.quit();
        }
        @Test
           public void test6() throws InterruptedException, AWTException {
            driver.get("https://www.tempmailaddress.com/");
            driver.findElement(By.xpath("//a[@class='wpcc-btn']")).click();
            String text = driver.findElement(By.xpath("//span[contains(text(),'@iillii.org')]")).getText();
            System.out.println(text);
            driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-download-alt'])[2]")).click();
            Thread.sleep(5000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
            Thread.sleep(5000);
            driver.switchTo().window(windowHandles.get(1));
            driver.get("https://practice-cybertekschool.herokuapp.com");
            Thread.sleep(5000);
            driver.findElement(By.linkText("Sign Up For Mailing List")).click();
            driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("caner");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys(text);
            WebElement element = driver.findElement(By.name("wooden_spoon"));
            element.click();
            Thread.sleep(5000);
            WebElement signup_message = driver.findElement(By.name("signup_message"));
            String expected="Thank you for signing up. Click the button below to return to the home page";
            String actual=signup_message.getText();
            System.out.println(expected);
            System.out.println(actual);
            driver.switchTo().window(windowHandles.get(0));
            Thread.sleep(5000);
            driver.findElement(By.xpath("//td[contains(.,'cybertekschool.com')]")).click();
            WebElement element1 = driver.findElement(By.id("//span[@id='odesilatel']"));
            Thread.sleep(5000);
            element1.getText();
            String expected1="do-not-reply@practice.cybertekschool.com";
            String actual1=element1.getText();
            System.out.println(element1.getText());
            Assert.assertTrue(Boolean.parseBoolean(actual1),expected1);


        }
        @Test
        public void test7() throws InterruptedException {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.xpath("//a[.='File Upload']")).click();
            WebElement element = driver.findElement(By.name("file"));
            Thread.sleep(5000);
            String projectPath=System.getProperty("user.dir");
            String relativepath="src/test/resources/testfile.txt";
            String filepath=projectPath+"/"+relativepath;
            element.sendKeys(filepath);
            driver.findElement(By.id("file-submit")).click();
            String text = driver.findElement(By.id("uploaded-files")).getText();
            Assert.assertEquals(text,"testfile.txt");
            System.out.println(text);
            System.out.println("testfile.txt");


        }
         @Test
         public void test8() throws InterruptedException {
           driver.get("https://practice-cybertekschool.herokuapp.com");
           driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
           driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("United States of America");
           Thread.sleep(5000);
             WebElement element = driver.findElement(By.xpath("//input[@value='Submit']"));
             element.click();
             WebElement driverElement = driver.findElement(By.xpath("//p[@id='result']"));
             String expected="You selected: United States of America";
             String actual=driverElement.getText();
             System.out.println(driverElement.getText());

         }
}
