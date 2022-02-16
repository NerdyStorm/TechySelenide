package com.techfios.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {
    private String browser = "chrome";
    private String url = "https://www.techfios.com/billing";

    private WebDriver driver;

    
    public WebDriver init(){

        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();


        return driver;

        
    }   

}
