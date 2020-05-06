package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");
        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);
    }

     @Test
    public void test2(){
         System.out.println("Second Test Case");
         Assert.assertEquals("url","url");
     }

     @Test
    public void test(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title start with Cyb");
        Assert.assertTrue(2>1,"I m checking is 2 greater than 1");
     }
     @Test
     public void test4(){
        String email="mike@smith.com";
         Assert.assertTrue(email.contains("@"),"Verify email has @ sign");
    }

}
