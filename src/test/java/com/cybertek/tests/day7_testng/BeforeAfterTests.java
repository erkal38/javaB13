package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {


    @Test
    public void test1(){
        //Webdriver part
        System.out.println("This is my test 1");
       //close browser,quit

    }
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }
    @Test
    public void test3(){
        System.out.println("this is my test 3");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method here");
        System.out.println("Webdriver part");

    }
     @AfterMethod
    public void tearDown(){
         System.out.println("After method here");

     }

     @BeforeClass
     public void setUpClass(){
         System.out.println("--Before Class");
     }
     @AfterClass
    public void afterClass(){
         System.out.println("--After Class--");
         System.out.println("---Generate Report---");
     }
}
