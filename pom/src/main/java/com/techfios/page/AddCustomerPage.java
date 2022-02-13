package com.techfios.page;

import java.io.FileInputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage {
    WebDriver driver;
    
    public AddCustomerPage(WebDriver driver){
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    //WebElement Library
    @FindBy (how = How.XPATH, using = "//h5[contains(text(), 'Add Contact')]") WebElement pageTitle;
    @FindBy (how = How.XPATH, using = "//input[@name='account']") WebElement fullName;
    @FindBy (how = How.XPATH, using = "//select[@id='cid']//*") List<WebElement> company;
    @FindBy (how = How.XPATH, using = "//input[@id='email']") WebElement randomEmail;
    @FindBy (how = How.XPATH, using = "//input[@id='phone']") WebElement randomPhone;
    @FindBy (how = How.XPATH, using = "//input[@id='address']") WebElement randomAddress;
    @FindBy (how = How.XPATH, using = "//input[@id='city']") WebElement randomCity;
    @FindBy (how = How.XPATH, using = "//input[@id='state']") WebElement randomState;
    @FindBy (how = How.XPATH, using = "//input[@id='zip']") WebElement randomZipCode;
    @FindBy (how = How.XPATH, using = "//select[@name='country']//*") List<WebElement> country;
    @FindBy (how = How.XPATH, using = "//button[@id='submit']") WebElement submit;
    @FindBy (how = How.XPATH, using = "//a[contains(text(), 'List Customers')]") WebElement listCustomers;

    //@FindBy (how = How.XPATH, using = "") WebElement randomPassword;

    

    public void verifyAddCustomersPage (){
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.urlToBe("https://techfios.com/billing/?ng=contacts/add/"));
       Assert.assertEquals("Add Contact", pageTitle.getText(), "Not on Add Customers Page!");
    }
    public void clickOnListCustomers(){
        listCustomers.click();
    }
    public void verifyListCustomersPage (){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://techfios.com/billing/?ng=contacts/list/"));
        //Assert.assertEquals("Add Contact", pageTitle.getText(), "Not on Add Customers Page!");
     }

    public void fillRandomData(){
        fullName.sendKeys("Md Hossain");
        randomEmail.sendKeys(returnRandomData("email"));
        randomPhone.sendKeys(returnRandomData("phone"));
        randomCity.sendKeys(returnRandomData("city"));
        randomState.sendKeys(returnRandomData("city"));
        randomZipCode.sendKeys(returnRandomData("zip"));
    }

    public String returnRandomData(String o){
        if (o.equalsIgnoreCase("zip")){
            String zip = "";
            int i = 0;
            try {
                Scanner s = new Scanner((new FileInputStream("otherFiles/newZipCodes.txt")));
                while (i!= (new Random()).nextInt(33145)){zip = "" + s.nextLine();i++;}
                
            } catch (Exception e) {
                //TODO: handle exception
            }
            return zip;

        } else if (o.equalsIgnoreCase("email")){

            String begin = "mdhossain";
            int mid = (new Random()).nextInt(1000);
            String end = "";
            int i = 0;
            try {
                Scanner s = new Scanner((new FileInputStream("otherFiles/newEmailDomains.txt")));
                while (i!= (new Random()).nextInt(6105)){end = s.nextLine();i++;}
                
            } catch (Exception e) {
                //TODO: handle exception
            }

            String full = begin + mid + "@"+ end;

            return full;

        } else if (o.equalsIgnoreCase("phone")){
            int min = 100;
            int min2 = 1000;
            int begin = min + (new Random()).nextInt(899);
            int mid = min + (new Random()).nextInt(899);
            int end = min2 + (new Random()).nextInt(8999);

            String full = begin + "-" + mid + "-" + end;

            return full;

        } else if (o.equalsIgnoreCase("city")){
            String city = "";

            int i = 0;
            try {
                Scanner s = new Scanner((new FileInputStream("otherFiles/newCities.txt")));
                while (i!= (new Random()).nextInt(386)){city = s.nextLine();i++;}
                
            } catch (Exception e) {
                //TODO: handle exception
            }
            return city;

        } else {
            return "";
        }
    }
    public void selectCountry(String c){
        for (WebElement e: country){
            if (c.equalsIgnoreCase(e.getText())){
                e.click();
                //System.out.println("selected -> " + e.getText());
                break;
            }
        }
    }
    public void selectCompany(String c){
        for (WebElement e: company){
            if (c.equalsIgnoreCase(e.getText())){
                e.click();
                //System.out.println("selected -> " + e.getText());
                break;
            }
        }
    }
    public void selectfromDropdown(List<WebElement> w, String c){
        for (WebElement e: w){
            if (c.equalsIgnoreCase(e.getText())){
                e.click();
                System.out.println("selected -> " + e.getText());
                break;
            }
        }
    }
    public void submit(){
        submit.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
