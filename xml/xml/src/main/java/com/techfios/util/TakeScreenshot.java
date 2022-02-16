package com.techfios.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
    static int scNum=0;
    WebDriver driver;

    public TakeScreenshot(WebDriver driver){
        this.driver = driver;
    }



    public void capture(){
    
        System.out.println(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).getClass());
        
        File z = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(z, new File("src/screenshots/screenshot" + scNum + ".png"));
            scNum ++;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
