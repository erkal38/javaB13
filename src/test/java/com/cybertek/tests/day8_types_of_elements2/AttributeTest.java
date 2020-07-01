package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement radioButton = driver.findElement(By.id("blue"));
        String outerHTML = radioButton.getAttribute("outerHTML");
        String[] str=outerHTML.split(" ");
        System.out.println(Arrays.toString(str));
        System.out.println(str[2]);
        System.out.println();
        System.out.println(radioButton.getAttribute("checked"));

    }
    }

