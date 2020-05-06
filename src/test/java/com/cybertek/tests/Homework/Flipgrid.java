package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Flipgrid {

        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void afterMethod() throws InterruptedException {
            Thread.sleep(3000);
            //driver.quit();
        }
        @Test
        public void test1() throws InterruptedException {
            driver.get("https://my.flipgrid.com");
            driver.manage().window().maximize();
            WebElement element = driver.findElement(By.xpath("//button[@data-testid='googleSSOButton__button__login']"));
            element.click();
            Thread.sleep(5000);
            Set<String> windowHandles = driver.getWindowHandles();
            String newWindow=driver.getWindowHandle();
            for (String windowHandle : windowHandles) {
                if(!newWindow.equals(windowHandle))
                    driver.switchTo().window(windowHandle);
            }
            driver.findElement(By.id("identifierId")).sendKeys("nalruvceysem1984@gmail.com", Keys.ENTER);
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//span[@class='RveJvd snByac'])[1]")).click();
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("86787@erg", Keys.ENTER);
            Thread.sleep(30000);
            driver.switchTo().window(newWindow);
            WebElement counter = driver.findElement(By.xpath("(//td[@class='table__cell  text-center hide-for-medium-down'])[9]"));
            String firstCount = counter.getText();
            System.out.println(counter.getText());



        }
}
