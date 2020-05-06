package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownelement = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(dropdownelement);
        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("Options size: " + options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());


        }
    }

    @Test
    public void test2() throws InterruptedException {
        String expectedOption;
        String actualOption;
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownelement = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(dropdownelement);
        expectedOption = "Select a State";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify first selection");
        Thread.sleep(2000);

        stateDropdown.selectByVisibleText("Virginia");
        expectedOption="Virginia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);

        Thread.sleep(2000);

        stateDropdown.selectByIndex(51);
        expectedOption="Wyoming";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);
        Thread.sleep(2000);

        stateDropdown.selectByValue("DC");
        expectedOption="District of Columbia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);
        Thread.sleep(2000);
        driver.quit();

    }
}