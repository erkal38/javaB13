package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactsInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    @Test
    public void contactDetailsTest(){
        extentLogger=report.createTest("Contacts email Report verifying");
       LoginPage loginPage=new LoginPage();
       extentLogger.info("Enter username");
        String username = ConfigurationReader.get("salesmanager_username");
        extentLogger.info("Enter password");
        String password = ConfigurationReader.get("salesmanager_password");
        loginPage.login(username,password);
        new DashboardPage().navigateToModule("Customers","Contacts");
        extentLogger.info("Navigate to Customers module Contacts");
        ContactsPage contactsPage=new ContactsPage();
        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        ContactsInfoPage contactsInfoPage=new ContactsInfoPage();
        BrowserUtils.waitFor(3);
        String fullNameText = contactsInfoPage.fullName.getText();
        String emailText = contactsInfoPage.email.getText();
        String phoneText = contactsInfoPage.phone.getText();
        String expectedFullName="Mariam Brackstone";
        extentLogger.info("Fullname= "+contactsInfoPage.fullName.getText());
        Assert.assertEquals(fullNameText,expectedFullName,"FullName is matching");
        String expectedEmail="mbrackstone9@example.com";
        extentLogger.info("Email Address= "+contactsInfoPage.email.getText());
        Assert.assertEquals(emailText,expectedEmail,"Email is matching");
        extentLogger.info("Phone Number= "+contactsInfoPage.phone.getText());
        String expectedPhone="+18982323434";
        Assert.assertEquals(phoneText,expectedPhone,"Phone number is matching");
        extentLogger.pass("Everything is normal.Test is passed");

    }

}
