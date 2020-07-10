package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){
     //create an object from ExcelUtil
        //it accepts two argument
        //1.location of the file 2.sheet that we want to open
        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        //how many rows are there?
        System.out.println(qa3short.rowCount());
        //how mant columns are in the sheet?
        System.out.println(qa3short.columnCount());
        System.out.println(qa3short.getColumnsNames());
        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        System.out.println(dataList.get(2).get("firstname"));
        for (Map<String, String> stringMap : dataList) {
            System.out.println(stringMap);
        }
         //get all data in 2d Array
        String[][] dataArray = qa3short.getDataArray();
        //print 2d Array
        System.out.println(Arrays.deepToString(dataArray));
        System.out.println(qa3short.getCellData(2, 2));

    }

}
