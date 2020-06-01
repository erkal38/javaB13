package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageVehicleCosts extends BasePage {

    public PageVehicleCosts(){
        PageFactory.initElements(Driver.get(),this);

    }
    @FindBy(xpath = "//a[contains(@class,'btn main-group btn-primary pull-right')]")
    public WebElement createVehicleCost;
    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement vehicleCostName;
    @FindBy(xpath = "//select[@name='custom_entity_type[Type]']")
    public WebElement chooseValue;
    @FindBy(xpath = "//input[@name='custom_entity_type[TotalPrice]']")
    public WebElement sendMoney;
    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement chooseDate;
    @FindBy(xpath = "//select[@data-handler='selectMonth']")
    public WebElement selectMonth;
    @FindBy(xpath = "//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']")
    public WebElement dateAndYear;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement saveAndClose;
    @FindBy(xpath = "//span[@class='validation-failed']")
    public WebElement spanText;


}
