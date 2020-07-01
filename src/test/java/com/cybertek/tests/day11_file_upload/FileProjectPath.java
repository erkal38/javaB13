package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FileProjectPath {
    @Test
    public void test1(){
        String projectPath = System.getProperty("user.dir");
        String relativePath="src/test/resources/testfile.txt";
        String filePath = projectPath + "/" + relativePath;
        System.out.println(filePath);

    }
}
