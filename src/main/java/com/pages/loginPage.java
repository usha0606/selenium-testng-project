package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

    public loginPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
     }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

   @FindBy(id = "password")
   private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
         passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }   
    
}
