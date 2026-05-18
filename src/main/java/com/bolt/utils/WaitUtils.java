package com.bolt.utils;

import com.bolt.driver.DriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class WaitUtils {

    private static final int TIMEOUT = 10;

    private static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    public static WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitForTitleContains(String title) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.titleContains(title));
    }

    public static void waitForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
           log.info(e.getMessage());
        }
    }
}
