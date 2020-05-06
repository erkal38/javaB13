package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverOverTest {

      WebDriver driver;

      @BeforeMethod
      public void setupMethod() {
          driver = WebDriverFactory.getDriver("chrome");
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      }

      @AfterMethod
      public void afterMethod() throws InterruptedException {
          Thread.sleep(3000);
          //driver.quit();
      }
      @Test
      public void test1() throws InterruptedException {
          String str=null;
          driver.get("http://practice.cybertekschool.com/hovers");
          List<WebElement> img1 = driver.findElements(By.tagName("img"));
          for(int i=0;i<3;i++){
              Actions actions=new Actions(driver);
              Thread.sleep(2000);
              actions.moveToElement(img1.get(i)).perform();
              Assert.assertTrue(driver.findElement(By.xpath("(//h5[contains(text(),'user')])["+(i+1)+"]")).isDisplayed());
              System.out.println(driver.findElement(By.xpath("(//h5[contains(text(),'user')])["+(i+1)+"]")).getText());

          }
      }
}
