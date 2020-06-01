package com.cybertek.tests.Homework;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackDriver extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get(ConfigurationReader.get("qa1_url"));
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.get("salesmanager_username"));
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.get("salesmanager_password")+ Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        actions.moveToElement(element).perform();
        WebElement webElement = driver.findElement(By.xpath("//span[contains(text(),'Vehicle Costs')]"));
        webElement.click();
        Thread.sleep(3000);
        String actual=driver.getTitle();
        System.out.println(driver.getTitle());
        String expected="Vehicle Costs - Entities - System - Car - Entities - System";
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody[@class='grid-body']//tr[1]")).click();


    }

}
