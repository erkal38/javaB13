package com.cybertek.tests.Homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Q1Q5 {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
         driver.quit();
    }

    @Test
    public void Test1(){
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        System.out.println(driver.findElement(By.xpath("//small[@data-bv-validator='date']")).getText());

    }
    @Test
    public void Test2(){
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        System.out.println(driver.findElement(By.cssSelector("#registrationForm > div:nth-child(11) > div")).getText());
    }
    @Test
    public void Test3(){
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("h");
        System.out.println(driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]")).getText());
    }
    @Test
    public void Test4(){
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("h");
        System.out.println(driver.findElement(By.xpath("//small[@data-bv-for='lastname'][2]")).getText());
    }
    @Test
    public void Test5() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("caner");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kanka");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("erkalcan");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("erkal@erkal.com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("546-456-1234");
        WebElement element = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        element.click();
        driver.findElement(By.cssSelector("input[name*='birthday']")).sendKeys("01/01/2000");
        Select select = new Select(driver.findElement(By.name("department")));
        select.selectByValue("MO");
        String expected = "Mayor's Office";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);
        Select select1 = new Select(driver.findElement(By.name("job_title")));
        select1.selectByVisibleText("SDET");
        String expected1="SDET";
        String actual1=select1.getFirstSelectedOption().getText();
        Assert.assertEquals(actual1,expected1);
        driver.findElement(By.cssSelector("input[id='inlineCheckbox1']")).click();
        driver.findElement(By.xpath("//button")).click();
        System.out.println(driver.findElement(By.cssSelector("#content > div > div > p")).getText());


    }




}
