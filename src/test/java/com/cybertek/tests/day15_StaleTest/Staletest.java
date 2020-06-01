package com.cybertek.tests.day15_StaleTest;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Staletest extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium"+ Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));
        Thread.sleep(2000);
        Assert.assertTrue(results.isDisplayed(),"verif is passed");
        driver.navigate().back();
        element = driver.findElement(By.name("q"));
        element.sendKeys("Java");
    }
}
