package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class product_SauceLabsBikeLight extends BasePage {
    
    public product_SauceLabsBikeLight(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
     }

    @FindBy(id = "add-to-cart")
    private WebElement addToCart;

    @FindBy(id = "back-to-products")
    private WebElement backToProducts;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(xpath = "//button[@id='remove']")
    private WebElement removeButton;

    public void clickAddToCart() {
        addToCart.click();
    }

    public void clickBackToProducts() {
        backToProducts.click();
    }   

    public void clickRemoveButton() {
        removeButton.click();
    }   

    public void clickCartLink() {
        cartLink.click();       
    }
    
}
