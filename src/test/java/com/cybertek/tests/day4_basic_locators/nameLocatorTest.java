package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullnameUnputBox = driver.findElement(By.name("full_name"));
        fullnameUnputBox.sendKeys("Mike Smith");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement actualMessageElement = driver.findElement(By.name("signup_message"));
        String message = driver.findElement(By.name("signup_message")).getText();
        if (message.equals(expectedMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");

        }
    }
}