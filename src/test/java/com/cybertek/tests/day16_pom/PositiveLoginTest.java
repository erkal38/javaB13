package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    @Test
    public void loginAsDriver(){
        LoginPage element=new LoginPage();
        element.loginAsDriver();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/","verify is OK");
    }
    @Test
     public void loginAsSalesManager(){
        LoginPage element=new LoginPage();
        String username= ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");
        element.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/","verif is OK");

     }
}
