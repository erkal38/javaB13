package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver=WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        //driver.quit();
    }
    @Test
    public void test(){
        driver.manage().window().maximize();
        driver.get("http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//button[.='No']")).click();

    }
     @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();
         Alert alert=driver.switchTo().alert();
         Thread.sleep(2000);
         alert.accept();
         driver.findElement(By.xpath("//button[2]")).click();
         Thread.sleep(2000);
         alert.dismiss();
         driver.findElement(By.xpath("//button[3]")).click();
         alert.sendKeys("ergun");
         alert.accept();


    }


}
