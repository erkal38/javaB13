package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {

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
        public void hovertest1() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/hovers");
            WebElement img1 = driver.findElement(By.tagName("img"));
            Actions actions=new Actions(driver);
            Thread.sleep(5000);
            actions.moveToElement(img1).perform();
            WebElement link = driver.findElement(By.linkText("View profile"));
            Assert.assertTrue(link.isDisplayed(),"verify view profile link is displayed");

        }
        @Test
         public void testDrag() throws InterruptedException {
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
            driver.manage().window().maximize();
            Actions actions=new Actions(driver);
            WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@title='Accept Cookies']")).click();
            Thread.sleep(2000);
            actions.dragAndDrop(source,target).perform();
}
        @Test
         public void DragAndDropTest() throws InterruptedException {
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
            driver.manage().window().maximize();
            Actions actions=new Actions(driver);
            WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@title='Accept Cookies']")).click();
            //if we are chaining actions we have to use build() and perform()
            Thread.sleep(2000);
            actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
        }

}
