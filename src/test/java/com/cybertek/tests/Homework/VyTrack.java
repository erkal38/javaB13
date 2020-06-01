package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrack {

        WebDriver driver;
        @DataProvider
        public static Object[][] credentials(){
            return new Object[][]{
                    {"storemanager61", "UserUser123"},
                    {"salesmanager117", "UserUser123"} };

        }
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
        @Test(dataProvider = "credentials")
        public void test1(String username,String password) throws InterruptedException {
            driver.get("http://qa1.vytrack.com/user/login");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(password);
            driver.findElement(By.id("_submit")).click();
            Thread.sleep(3000);
            List<WebElement> elements = driver.findElements(By.xpath("//li[@class='dropdown dropdown-level-1']"));
            for(int i=0;i<=5;i++){
                Actions actions=new Actions(driver);
                Thread.sleep(2000);
                actions.moveToElement(elements.get(i)).perform();
                Thread.sleep(5000);
                System.out.println(elements.get(i).getText());

            }

        }
         @Test
        public void test2() throws InterruptedException {
             driver.get("http://qa1.vytrack.com/user/login");
             driver.manage().window().maximize();
             driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("storemanager61");
             driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys("UserUser123");
             driver.findElement(By.id("_submit")).click();
             String str="//li[@class='dropdown dropdown-level-1']";
             WebElement element = driver.findElement(By.xpath(str));
             Actions actions=new Actions(driver);
             actions.moveToElement(element).pause(2000).perform();
             driver.findElement(By.xpath("(//li[@class='dropdown-menu-single-item'])[2]")).click();
             Assert.assertTrue(element.isDisplayed(), "verif is OK");
             System.out.println(element.getText());
             List<WebElement> elements = driver.findElements(By.xpath("//th"));
             System.out.println(elements.size());
             List<WebElement> elements1 = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
             System.out.println(elements1.size());
             for(int i=1;i<=elements.size();i++){
                 for(int j=1;j<=elements1.size();j++){
                     WebElement element1 = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[" + j + "]/td[" + i + "]"));
                     WebElement element2 = driver.findElement(By.xpath("//th[" + i + "]"));
                     String text = element1.getText();
                     String text1 = element2.getText();
                     System.out.printf("%-1S :%s\n",text1,text);

                 }

             }

         }

        @Test
        public void test3() throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("storemanager61");
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(50000);
}
    @Test
    public void test4() throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("storemanager61");
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(50000);
    }
}
