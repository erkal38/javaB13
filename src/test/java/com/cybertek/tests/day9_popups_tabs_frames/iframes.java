package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
       // driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike NAber");
        //goes back to first frame
        driver.switchTo().defaultContent();
        //3.using webelement
        //locating iframe with any locator
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().parentFrame();//HTML e gitmek için defaultcontent,
                                        //frame-top için parentFrame, siblingsler arası geçiş parent veya top a giderek olur.
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

}
