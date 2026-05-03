package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productPage extends BasePage {
    
    public productPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
     }

     @FindBy(xpath = "//div[@class='inventory_item_name' and normalize-space()='Sauce Labs Bike Light']")
     private WebElement product_SauceLabsBikeLight;

     @FindBy(id = "add-to-cart-sauce-labs-bike-light")
        private WebElement addToCart_SauceLabsBikeLight;

    public void clickProduct_SauceLabsBikeLight() {
        product_SauceLabsBikeLight.click();
    }

    public void clickAddToCart_SauceLabsBikeLight() {
        addToCart_SauceLabsBikeLight.click();
    }

}
