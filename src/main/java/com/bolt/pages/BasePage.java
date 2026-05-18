package com.bolt.pages;

import com.bolt.driver.DriverManager;
import com.bolt.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    // Navigate to URL
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    // Find Element with wait (visibility)
    public WebElement find(By locator) {
        return WaitUtils.waitForVisibility(getDriver().findElement(locator));
    }

    // Click action with wait
    public void click(By locator) {
        WaitUtils.waitForClickable(getDriver().findElement(locator)).click();
    }

    // Type action with wait
    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get page title
    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
