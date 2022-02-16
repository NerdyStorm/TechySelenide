package com.techfios.Tests;

import com.techfios.page.AddCustomerPage;
import com.techfios.page.DashboardPage;
import com.techfios.page.LoginPage;
import com.techfios.util.BrowserFactory;
import com.techfios.util.TakeScreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddCustomerTest extends BrowserFactory{
    private WebDriver driver;
    private String username = "demo@techfios.com";
    private String password = "abc123";

    @Test
    @Parameters({"username", "password"})
    public void  test(String username, String password){
        driver = init();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboard();
        dashboardPage.clickOnCustomers();
        dashboardPage.clickOnAddCustomers();

        AddCustomerPage addCustomerPage =  new AddCustomerPage(driver);
        addCustomerPage.verifyAddCustomersPage();
        addCustomerPage.fillRandomData();
        TakeScreenshot t = new TakeScreenshot(driver);
        t.capture();
        addCustomerPage.submit();



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    

}
