package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownelement = driver.findElement(By.id("dropdownMenuLink"));
        dropdownelement.click();
        List<WebElement> dropdownelements = driver.findElements(By.className("dropdown-item"));
        for (WebElement element : dropdownelements) {
            System.out.println(element.getText());
        }
        dropdownelements.get(2).click();


    }

}
