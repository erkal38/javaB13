package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wikipediaTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://wikipedia.org");
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();

        System.out.println("URL:"+driver.getCurrentUrl());
    }
}
