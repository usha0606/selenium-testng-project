package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); 

    // ── Get current thread's driver ────────
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        String browser = ConfigReader.getBrowser();
        boolean headless = ConfigReader.isHeadless();

        WebDriver webDriver;

        switch (browser.toLowerCase()) {
            case "chrome":
                webDriver = createChromeDriver(headless);
                break;
            case "firefox":
                webDriver = createFirefoxDriver(headless);
                break;
            case "edge":
                webDriver = createEdgeDriver(headless);
                break;
            default:
                webDriver = createChromeDriver(headless);
                break;
        }

        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    private static WebDriver createChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new EdgeDriver(options);
    }
    
    public static void quitDriver() {
        if(driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
