package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScript {

        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void afterMethod() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
        @Test
        public void testScroll() throws InterruptedException {
           driver.get("http://practice.cybertekschool.com/infinite_scroll");
           JavascriptExecutor jse= (JavascriptExecutor) driver;
           Thread.sleep(3000);
           jse.executeScript("scroll(0,250);");

            for (int i=0;i<10;i++) {
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,250)");

            }
            for (int i=0;i<10;i++) {
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,-250)");

            }
        }
         @Test
         public void clickwithJs(){
            driver.get("http://practice.cybertekschool.com/dropdown");
             WebElement dropdownlink = driver.findElement(By.linkText("Dropdown"));
             JavascriptExecutor jse = (JavascriptExecutor) driver;
             jse.executeScript("argument[0].click;",dropdownlink);
         }
         @Test
    public void type(){
            driver.get("http://practice.cybertekschool.com/dynamic_controls");
             WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));
             String str = "Hello this iBox";
             JavascriptExecutor jse = (JavascriptExecutor) this.driver;
             jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputbox);
         }
}
