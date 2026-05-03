package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends BasePage {

    public cartPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
     }

     @FindBy(xpath = "//span[text() ='Your Cart']")
     private WebElement cartTitle;

     @FindBy(id = "checkout")
     private WebElement checkoutButton;

     public String getCartTitle() {
         return cartTitle.getText();
     }

     public void clickCheckoutButton() {
         checkoutButton.click();
     }
    
}
