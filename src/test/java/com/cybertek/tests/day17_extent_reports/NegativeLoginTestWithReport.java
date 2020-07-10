package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void test1() {
        extentLogger=report.createTest("Url test step");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter Valid Credentials");
        loginPage.loginAsDriver();
        Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.get(url));
        extentLogger.pass("verify is OK");

    }
    @Test
    public void wrongUsernameTest(){
        extentLogger=report.createTest("wrong password test");
        LoginPage loginPage=new LoginPage();
        extentLogger.info("Enter username:User1");
        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter Password:somepassword");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("click login button");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get(url));
        extentLogger.pass("Wrong password Test is passed");

    }
}