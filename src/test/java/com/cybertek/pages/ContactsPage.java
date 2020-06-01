package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage {
     @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com') and @data-column-label='Email']")
     public WebElement email;
     public WebElement getContactEmail(String email){
          String xpath="//td[contains(text(),'"+email+"') and @data-column-label='Email']";
          return Driver.get().findElement(By.xpath(xpath));
     }



}
