package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class eBayTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("search");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'results for')]/span[1]"));
        System.out.println("Text: "+element.getText());
        System.out.println("Title: "+driver.getTitle());


    }
}
