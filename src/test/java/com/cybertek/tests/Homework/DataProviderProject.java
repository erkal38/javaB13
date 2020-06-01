package com.cybertek.tests.Homework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.PageVehicleCosts;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DataProviderProject extends TestBase {
    @DataProvider
    public Object[][] testData() {
        ExcelUtil keepData = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA4-short");
        String[][] dataArrayWithoutFirstRow = keepData.getDataArrayWithoutFirstRow();
        BrowserUtils.waitFor(3);
        return dataArrayWithoutFirstRow;

    }

    @Test(dataProvider = "testData")
    public void loginTestWithDataP(String username, String password, String firstname, String lastname) {
        extentLogger = report.createTest("Login With DataProvider");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        BrowserUtils.waitFor(3);
        String actualData = new DashboardPage().getUserName();
        String expectedData = firstname + " " + lastname;
        Assert.assertEquals(actualData, expectedData);
        extentLogger.pass("PASS");

    }

    @Test
    public void testVehicleCost() {
        extentLogger = report.createTest("Open Page Vehicle");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        extentLogger.info("Username: " + getUserName());

        extentLogger.info("Password: " + "******");
        BrowserUtils.waitFor(3);
        navigateToModule("Fleet", "Vehicle Costs");


        String actualName = new DashboardPage().getUserName();
        String expectedName = "Zion Schaefer";
        System.out.printf("%s%n\n", actualName, expectedName);
        Assert.assertEquals(actualName, expectedName, "matches both of names");
        PageVehicleCosts pageVehicleCosts = new PageVehicleCosts();
        BrowserUtils.waitFor(5);
        pageVehicleCosts.waitUntilLoaderScreenDisappear();
        pageVehicleCosts.createVehicleCost.click();

        String actualNameStatus = pageVehicleCosts.vehicleCostName.getText();
        String expectedNameStatus = "Create Vehicle Costs";
        extentLogger.info("H1 user-name:" + new PageVehicleCosts().vehicleCostName.getText());
        Assert.assertEquals(actualNameStatus, expectedNameStatus, "verify is matched");

        Select select = new Select(pageVehicleCosts.chooseValue);
        List<WebElement> options = select.getOptions();
        System.out.println("Options size: " + options.size());
        Assert.assertFalse(pageVehicleCosts.chooseValue.isSelected(),"Vehicle Insurance is selected");
        extentLogger.info("Choose Value:"+pageVehicleCosts.chooseValue.getText());
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
        options.get(7).click();
        pageVehicleCosts.sendMoney.sendKeys("$1.000.000");
        pageVehicleCosts.chooseDate.click();
        pageVehicleCosts.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        Select selectAy=new Select(pageVehicleCosts.selectMonth);
        List<WebElement> selectAyOptions = selectAy.getOptions();
        for (WebElement selectAyOption : selectAyOptions) {
            System.out.println(selectAyOption.getText());
        }
        selectAyOptions.get(5).click();
        pageVehicleCosts.dateAndYear.click();
        pageVehicleCosts.saveAndClose.click();
        String actualText = pageVehicleCosts.spanText.getText();
        String expectedText="This value is not valid.";
        Assert.assertEquals(actualText,expectedText);
        extentLogger.info("Span Text:"+pageVehicleCosts.spanText.getText());
        extentLogger.pass("Pass:" + "Mission is accomplished and is matched");
        if(actualText.equals(expectedText)){
            logOut();
        }
    }
}
