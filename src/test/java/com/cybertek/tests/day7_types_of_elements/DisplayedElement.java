package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedElement {
   @Test
    public void Test1(){
       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.get("http://practice.cybertekschool.com/radio_buttons");
       WebElement green = driver.findElement(By.id("green"));
       boolean enabled = green.isEnabled();
       System.out.println(enabled);
       Assert.assertFalse(enabled);
       green.click();
   }
}
