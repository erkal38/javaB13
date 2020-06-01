package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){
        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        System.out.println(qa3short.rowCount());
        System.out.println(qa3short.columnCount());
        System.out.println(qa3short.getColumnsNames());
        List<Map<String, String>> dataList = qa3short.getDataList();
        System.out.println("Password:" +dataList.get(2).get("password"));
        System.out.println("Username:"+dataList.get(2).get("username"));
        //iki yontemle cikti alalım.
        /*for (Map<String, String> stringStringMap : dataList) {
            System.out.println(stringStringMap);
        }
        String[][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));
        */
        System.out.println(dataList.get(8).get("firstname"));
    }

}
