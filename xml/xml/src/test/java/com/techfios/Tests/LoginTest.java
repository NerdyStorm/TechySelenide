
package com.techfios.Tests;

import com.techfios.page.AddCustomerPage;
import com.techfios.page.DashboardPage;
import com.techfios.page.LoginPage;
import com.techfios.util.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory{
    private WebDriver driver;

    @Test(description =  "Running Login!")
    @Parameters({"username1", "password1"})
    public void  test(String username, String password){
        driver = init();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}