package com.cybertek.tests.day14_Properties;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Singleton {
      @Test
      public void test1() throws InterruptedException {
          Driver.get().get("https://www.google.com");
          Thread.sleep(2000);
      }
      @Test
      public void test2(){
        Driver.get().get("https://www.amazon.com");
    }
       @Test
    public void test3(){
           WebDriver driver = Driver.get();
           driver.get(ConfigurationReader.get("url"));
       }
}
