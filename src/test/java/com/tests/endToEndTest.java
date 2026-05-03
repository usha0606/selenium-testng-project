package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pages.loginPage;
import org.testng.Assert;
import com.utils.Constants;

@Listeners(com.listeners.TestListeners.class)
public class loginPageTest extends BaseTest {

    @Test( priority = 1)
    public void verifyLoggedInSuccessfully() {
        String title = driver.getTitle();
        System.out.println("Page Title after login: " + title);
        Assert.assertEquals(title, Constants.EXPECTED_TITLE);
    }
}
