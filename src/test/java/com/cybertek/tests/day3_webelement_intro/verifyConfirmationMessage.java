package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedEmail = "test@gmail.com";
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(expectedEmail);
        String actualEmail = email.getAttribute("value");
        if (actualEmail.equals(expectedEmail)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println(expectedEmail);
            System.out.println(actualEmail);
        }
        driver.findElement(By.id("form_submit")).click();
        WebElement confirmation_message = driver.findElement(By.name("confirmation_message"));
        String expectedMessage="Your e-mail's been sent!";
        String actualMessage=confirmation_message.getText();
        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
            System.out.println(actualMessage);
        }else{
            System.out.println("FAIL");
            System.out.println(actualMessage);
            System.out.println(expectedMessage);
        }
       driver.quit();
    }

}
