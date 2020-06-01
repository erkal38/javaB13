package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
       //Thread.sleep(3000);
       // driver.quit();
    }
    @Test
    public void switchWindowsTest(){
       driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("title before new windows "+driver.getTitle());
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        System.out.println("title After new window "+driver.getTitle());
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());
        for (String handle : windowHandles) {
            if(!handle.equals(windowHandle)){
                driver.switchTo().window(handle);
            }
        }
        System.out.println("title after switching "+driver.getTitle());


    }
    @Test
    public void morethan2handle(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("title before switching "+driver.getTitle());
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("New Window")){
                break;
            }
        }
        System.out.println("title after switching "+driver.getTitle());

        driver.findElement(By.tagName("h3"));
        System.out.println(driver.getTitle());

    }
}
