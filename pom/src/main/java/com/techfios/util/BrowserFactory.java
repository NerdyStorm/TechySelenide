package com.techfios.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public String u = "https://www.techfios.com/billing";
    private String browser = "chrome";
    WebDriver driver;
    
    //public String browserUsed;
    public WebDriver init() {
   
        // try {
        //     FileInputStream file = new FileInputStream("drivers/properties.config");
        //     Properties properties = new Properties();
        //     properties.load(file);
        //     browserUsed = properties.getProperty("browser");
        //     //System.out.println(browserUsed);
    
        // } catch (IOException e) {

        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        try {
            FileInputStream file = new FileInputStream("drivers/properties.config");
            Properties properties = new Properties();
            properties.load(file);
            //file.close();

            //u = properties.getProperty("url");

            //System.out.println(browserUsed);
            
        //     if (browser.equalsIgnoreCase("chrome")) {
        //         System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //         driver = new ChromeDriver();
        //     } else if (browser.equalsIgnoreCase("firefox")) {
        //         System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        //         driver = new FirefoxDriver();
        //     }
        //     System.out.println(url);
    
        //     //driver.manage().window().maximize();
        //    driver.manage().deleteAllCookies();
    
    
        // //    driver.get("https://www.techfios.com/billing");
        //    driver.get(returnUrl());
        //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
            
        } catch (IOException e) {
            //url = "w";
            // TODO Auto-generated catch block
            System.out.println("EHRDIUEHNFUIENFIUENF");
            e.printStackTrace();
        }


        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //System.out.println(url);

        //driver.manage().window().maximize();
       driver.manage().deleteAllCookies();


    //    driver.get("https://www.techfios.com/billing");
       driver.get(u);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }

    public void tearDown(){
        driver.quit();
    }

}
