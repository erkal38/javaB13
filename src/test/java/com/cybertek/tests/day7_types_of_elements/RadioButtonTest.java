package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioBtnTest1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueradioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redradioBtn = driver.findElement(By.cssSelector("#red"));
        System.out.println("BlueradioButtonisselected:"+blueradioBtn.isSelected());
        System.out.println("redradioBtnisselected:"+redradioBtn.isSelected());
        Assert.assertTrue(blueradioBtn.isSelected(),"Verify Blue is selected");
        Assert.assertFalse(redradioBtn.isSelected(),"Verify red is  selected");
        redradioBtn.isSelected();



    }
}
