package com.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.utils.DriverFactory;

public class TestListeners implements ITestListener{

        @Override
        public void onTestStart(ITestResult test) {
            System.out.println("Test started: " + test.getName());
        }
    
        @Override
        public void onTestSuccess(ITestResult test) {
               try {
            File screenshotFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            File descFileScreenshot = new File("successScreenshots/" + test.getName() + ".png");
            FileUtils.copyFile(screenshotFile, descFileScreenshot);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            System.out.println("Test passed: " + test.getName());
        }
    
        @Override
        public void onTestFailure(ITestResult test) {
            try {
            File screenshotFile1 = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            File descFileScreenshot1 = new File("failedScreenshots/" + test.getName() + ".png");
            FileUtils.copyFile(screenshotFile1, descFileScreenshot1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            System.out.println("Screenshot captured for failed test: " + test.getName());
        }
    
        @Override
        public void onTestSkipped(ITestResult test) {
            System.out.println("Test skipped: " + test.getName());
        }
    
}
