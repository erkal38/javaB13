package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
    @Test
    public void test1(){
        new LoginPage().loginAsDriver();
        BrowserUtils.waitFor(5);
        DashboardPage dashboardPage=new DashboardPage();
        String expected="Quick Launchpad";
        String actual=dashboardPage.getPageSubTitle();
        Assert.assertEquals(actual,expected,"verify subtitles");
        navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(3);
        Assert.assertEquals(new CalendarEventsPage().getPageSubTitle(),"Calendar Events","verify subtitles");
    }
}
