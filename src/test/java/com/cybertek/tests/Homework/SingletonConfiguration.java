package com.cybertek.tests.Homework;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.security.auth.kerberos.KeyTab;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SingletonConfiguration {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException, AWTException {
        //https://qa3.vytrack.com run this page.
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.get("salesmanager_username"));
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.get("salesmanager_password"));
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        String actual = driver.getTitle();
        String expected = "Dashboard";
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        //switch to new tab
        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(2000);
        String str = "https://qa3.vytrack.com/entity/Extend_Entity_VehicleCosts";
        driver.get(str);
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("(//a[@href='#'])[23]"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//div[@class='pull-left grid-toolbar-mass-actions']//li[1]//a[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).perform();
        element1.click();

        Thread.sleep(5000);
        String windowHandle = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if (handle.equals(windowHandle)) {
                driver.switchTo().window(handle);
            }

        }

        Assert.assertEquals(actual, expected);


    }

    @Test
    public void test2() throws InterruptedException, AWTException {
        //https://qa3.vytrack.com run this page.
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.get("salesmanager_username"));
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.get("salesmanager_password"));
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        String actual = driver.getTitle();
        String expected = "Dashboard";
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        //switch to new tab
        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(2000);
        String str = "https://qa3.vytrack.com/entity/Extend_Entity_VehicleCosts";
        driver.get(str);
        List<WebElement> tableTh = driver.findElements(By.xpath("//th"));
        System.out.println(tableTh.size());
        int actual1=tableTh.size();
        int expected1=5;
        List<WebElement> tableRow = driver.findElements(By.xpath("//tbody[@class='grid-body']//tr"));
        System.out.println(tableRow.size());
        int actual2=tableRow.size();
        int expected2=7;
        for(int i=2;i<tableTh.size();i++){
            for(int j=1;j<=tableRow.size();j++){
                WebElement element = driver.findElement(By.xpath("//th[" + i + "]"));
                WebElement element1 = driver.findElement(By.xpath("//tbody[@class='grid-body']//tr[" + j + "]/td[" + i + "]"));
                String text = element.getText();
                String text1 = element1.getText();
                System.out.printf("%-1S :%s\n",text,text1);
            }
        }
              Assert.assertEquals(actual1,expected1,"count is Ok");
              Assert.assertEquals(actual2,expected2,"number is Ok");
    }
}