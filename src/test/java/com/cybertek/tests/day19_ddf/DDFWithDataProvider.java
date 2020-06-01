package com.cybertek.tests.day19_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    @DataProvider
    public Object[][] testData(){
        String [][] data={
                {"Person of Interest","10"},
                {"Killing Eve","8"},
                {"GoT","9"},
                {"Breaking Bad","10"},
                {"Dark","10"}
        };
        return data;
    }
     @Test(dataProvider = "testData")
     public void test1(String tvShow,String rating){
         System.out.println("Tv show: "+tvShow+"has rating: "+rating);
     }

}
