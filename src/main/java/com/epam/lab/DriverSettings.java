package com.epam.lab;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSettings {
    private static AppiumDriver driver;

    private static void setWait(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    private static WebDriverWait getWait() {
        return (new WebDriverWait(driver, 45));
    }

    static WebElement waitToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Custom Phone - 5.0.0 - API 21 - 768x1280");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "browser");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        setWait(driver);
    }
     static void close() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

     static WebDriver getDriver( ) {
        if (driver == null) {
            try {
                setUp();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

}
