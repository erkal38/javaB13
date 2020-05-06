package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Q9Q12 {

        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void afterMethod() throws InterruptedException {
            //Thread.sleep(3000);
            //driver.quit();
        }
        @DataProvider
        public static Object[] getData(){
            String[][]data =new String[4][1];
            data[0][0]="200";
            data[1][0]="301";
            data[2][0]="404";
            data[3][0]="500";
            return data;

        }
        @Test(dataProvider = "getData")
        public void test9(String status){
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.linkText("Status Codes")).click();
            driver.findElement(By.partialLinkText(status)).click();
            String actual = driver.findElement(By.xpath("//p")).getText();
            System.out.println("status code= "+status);
            System.out.println("actual code= "+actual);

    }

}
