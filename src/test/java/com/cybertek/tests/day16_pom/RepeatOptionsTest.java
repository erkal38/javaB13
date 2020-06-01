package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
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
        new LoginPage().loginAsDriver();
        navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(5);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
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
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Select repeatOptionsList = createCalendarEventsPage.repeatOptionsList();
        List<String> expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = repeatOptionsList.getOptions();
        List<String> actualList=new ArrayList<>();
        for (WebElement actualOption : actualOptions) {
            actualList.add(actualOption.getText());
        }
        List<String> elementsText = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList,expectedList,"verify is OK");

    }
}
