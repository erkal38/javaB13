package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactsInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    @Test
    public void contactDetailsTest(){
        extentLogger=report.createTest("Contact Info Verify");
        extentLogger.info("username: "+ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password: "+ConfigurationReader.get("salesmanager_password"));
        new LoginPage().loginAsDriver();
        extentLogger.info("Navigate to Customers--Contacts");
        navigateToModule("Customers","Contacts");
        BrowserUtils.waitFor(5);
        extentLogger.info("Click on mbrackstone9@example.com");
        new ContactsPage().getContactEmail("mbrackstone9@example.com").click();

        String actualFullName = new ContactsInfoPage().fullName.getText();
        String expectedFullName="Mariam Brackstone";
        extentLogger.info("Verify FullName: "+actualFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify is completed");

        extentLogger.info("Verify email: "+"mbrackstone9@example.com");
        Assert.assertEquals(new ContactsInfoPage().email.getText(),"mbrackstone9@example.com","verify is completed");

        extentLogger.info("Verify phone number is: "+"+18982323434");
        Assert.assertEquals(new ContactsInfoPage().phone.getText(),"+18982323434","verify is completed");

        extentLogger.pass("PASS: Contact Info Test is accomplished");
    }

}
