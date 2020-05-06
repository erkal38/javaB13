package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(new CharSequence[]{"selenium"});
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'results for')"));
        System.out.println("result:"+element.getText());
        System.out.println("Title: "+driver.getTitle());


    }
}
