package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.utils.DriverFactory;
import com.pages.loginPage;
import com.utils.ConfigReader;

@Listeners(com.listeners.TestListeners.class)
public class BaseTest  {
    
    protected WebDriver driver;

    @DataProvider(name = "loginCredentials")
        public Object[][] getLoginCredentials() {
        return new Object[][] {
            {"standard_user" , "secret_sauce"}
            //{"locked_out_user" , "secret_sauce"}
        };
    }

    @BeforeSuite
    public void setup() {
       // lanuch browser and navigate to URL  
        DriverFactory.initDriver();  // Initialize WebDriver before any tests run 
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getUrl());
        System.out.println("Browser launched and navigated to URL: " + ConfigReader.getUrl());
        System.out.println("Browser: " + ConfigReader.getBrowser() + ", Headless: " + ConfigReader.isHeadless());
    }

    @BeforeMethod
    public void loginToApp() {
        loginPage LoginPage = new loginPage(driver);
        LoginPage.enterUsername("standard_user");
        LoginPage.enterPassword("secret_sauce");
        LoginPage.clickLoginButton();
    }

    @AfterSuite
    public void tearDown() {
        DriverFactory.quitDriver();  // Quit WebDriver after all tests have run
        System.out.println("Browser closed.");
    }
}