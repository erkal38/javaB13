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

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class VerifyPointTableDataProvider2 {

    WebDriver driver;

    @DataProvider
    public static Object[] teamNameProvider() {
        return new String[]{"Trabzonspor"};

    }
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(dataProvider = "teamNameProvider")
    public void test(String teamNameFromDP) throws InterruptedException, AWTException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://mackolik.com");
        WebElement futbol = driver.findElement(By.cssSelector("[data-target='soccer']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(futbol).click().perform();
        WebElement puanDurumu = driver.findElement(By.xpath("(//a[@title='Puan Durumu'])[1]"));
        actions.moveToElement(puanDurumu).click().perform();


//        driver.findElement(By.linkText("Futb")).click();
//        driver.findElement(By.linkText("Puan Duru")).click();

        // [data-team-name^="Trabzonspor"]>td:nth-of-type(6)
        String clubnWonCSS = "[data-team-name^=" + teamNameFromDP + "]>td:nth-of-type(6)";
        String clubnDeuceCSS = "[data-team-name^=" + teamNameFromDP + "]>td:nth-of-type(7)";
        String clubnPointsCSS = "[data-team-name^=" + teamNameFromDP + "]>td:nth-of-type(12)";
        WebElement clubWon = driver.findElement(By.cssSelector(clubnWonCSS));
        WebElement clubDeuce = driver.findElement(By.cssSelector(clubnDeuceCSS));
        WebElement clubPoints = driver.findElement(By.cssSelector(clubnPointsCSS));
        int won = Integer.parseInt(clubWon.getText().trim());
        int deuce = Integer.parseInt(clubDeuce.getText().trim());
        int point = Integer.parseInt(clubPoints.getText().trim());
        System.out.printf("%S PuanDurumu :%d\nGalibiyet:%d   Beraberlik:%d", teamNameFromDP, point, won, deuce);
        Assert.assertEquals(point, ((won * 3) + deuce), teamNameFromDP + " point's is wrong ");


    }
}