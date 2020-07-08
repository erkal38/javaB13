package com.cybertek.tests.day13_WebTablesExamples;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Example1 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() {
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(element.getText());
        Assert.assertTrue(element.getText().contains("fbach@yahoo.com"));


    }

    @Test
    public void getHeader() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void getSize() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        List<WebElement> allRowswithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowswithHeader.size());
        List<WebElement> allRowswithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowswithoutHeader.size());
    }

    @Test
    public void getRow() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <= elements.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(element.getText());
        }
    }

    @Test
    public void getRowCell() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
        for (WebElement element : elements) {
            System.out.println(element.getText());

        }
    }

    @Test
    public void getASingleCell() {
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[4]"));
        System.out.println(element.getText());
    }

    @Test
    public void getAllCell() {
        int rowNumber = getRowCells();
        int columnNumber = getColumnCells();
        System.out.println("getColumnNumber: " + columnNumber);
        System.out.println("getRowCellsNumber: " + rowNumber);
        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= columnNumber; j++) {
                System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
        }

    }


    private int getColumnCells() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getRowCells() {
        List<WebElement> allRowswithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            return allRowswithoutHeader.size();
    }
    @Test
    public void getRowColumnCell(){
        String element=getrowcell(4,2);
        List<WebElement> rowSize = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println(element.toString());
        System.out.println();
        List<WebElement> columnSize = driver.findElements(By.xpath("//table[@id='table1']//th"));
        for(int i=1;i<=rowSize.size();i++){
            for(int j=1;j<=columnSize.size()-1;j++){
                WebElement element2 = driver.findElement(By.xpath("(//tr)[1]/th["+j+"]"));
                WebElement element1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]"));
                String element1Text = element1.getText();
                String element2Text = element2.getText();
                System.out.printf("%1S :%s\n",element2Text, element1Text);
            }
            System.out.println("----------------------");
        }
    }

    private String getrowcell(int a,int b) {
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+a+"]/td["+b+"]"));
        return element.getText();
    }
     @Test
    public void testSpecific(){
        String str="John";
        String xpath="//table[@id='table1']//td[.='"+str+"']/../td[3]";
         WebElement element = driver.findElement(By.xpath(xpath));
         System.out.println(element.getText());

     }


}
