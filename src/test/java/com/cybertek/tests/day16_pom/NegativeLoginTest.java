package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
   @Test
    public void wrongPasswordTest(){
       LoginPage element=new LoginPage();
       element.usernameInput.sendKeys("user1");
       element.passwordInput.sendKeys("somepassword");
       element.loginBtn.click();
       Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

   }
   @Test
    public void wrongUserTest(){
       LoginPage element=new LoginPage();
       element.usernameInput.sendKeys("someusername");
       element.passwordInput.sendKeys("UserUser123");
       element.loginBtn.click();
       Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
   }
}
