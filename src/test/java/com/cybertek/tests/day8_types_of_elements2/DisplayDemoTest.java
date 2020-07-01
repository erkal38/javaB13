package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemoTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));
        System.out.println("username.isdisplayed: "+username.isDisplayed());
        Assert.assertFalse(username.isDisplayed(),"not displayed");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(username.isDisplayed(),"is displayed");
    }
}
