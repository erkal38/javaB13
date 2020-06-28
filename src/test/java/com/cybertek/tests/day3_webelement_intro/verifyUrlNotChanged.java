package com.cybertek.tests.day3_webelement_intro;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class verifyUrlNotChanged {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedUrl = driver.getCurrentUrl();
        driver.manage().window().maximize();
        driver.findElement(By.id("form_submit")).click();
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }
}
