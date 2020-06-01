package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest() {
        extentLogger=report.createTest("Wrong Password Test");
        LoginPage element = new LoginPage();

        element.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: user1");

        element.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");

        element.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");

        extentLogger.pass("Wrong Password is passed");

    }

    @Test
    public void wrongUserTest() {
        extentLogger=report.createTest("Wrong Username Test");
        LoginPage element = new LoginPage();

        element.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username: someusername");

        element.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password: UserUser123");

        element.loginBtn.click();
        extentLogger.info("login click button");

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");

        extentLogger.pass("Pass: Wrong password Test");
    }
}