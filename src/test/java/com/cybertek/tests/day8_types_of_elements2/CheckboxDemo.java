package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        System.out.println("checkbox1.isSelected()= "+checkbox1.isSelected());
        System.out.println("checkbox2.isSelected()= "+checkbox2.isSelected());

        checkbox1.click();
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox2 is selected");

    }
}
