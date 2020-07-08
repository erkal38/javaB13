package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {
    @Test
    public void test(){
       LoginPage loginPage=new LoginPage();
       loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify is NOT selected");
    }
    @Test
    public void test2(){
        new LoginPage().loginAsDriver();
        navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(5);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        BrowserUtils.waitFor(5);
        createCalendarEventsPage.repeat.click();
        Select repeatOptionsList = createCalendarEventsPage.repeatOptionsList();
        List<String>expectedList=Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> options = repeatOptionsList.getOptions();
        List<String> actualList = BrowserUtils.getElementsText(options);
        System.out.println(actualList);
        System.out.println(expectedList);
        Assert.assertEquals(actualList,expectedList,"verify is Ok");
    }
}
