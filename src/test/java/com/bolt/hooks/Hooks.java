package com.bolt.hooks;

import com.bolt.driver.DriverFactory;
import com.bolt.driver.DriverManager;
import com.bolt.utils.AllureUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.MDC;

import java.io.ByteArrayInputStream;

@Slf4j
public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        WebDriver driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);

        String testName = scenario.getName().replaceAll(" ", "_");
        String threadId = String.valueOf(Thread.currentThread().getId());

        MDC.put("testName", testName);
        MDC.put("threadId", threadId);

        log.info("Test Started: {} | Thread: {}", testName, threadId);
    }

    @After
    public void tearDown(Scenario scenario) {

        try {
            log.info("Test Finished: {}", scenario.getName());

            // 🔥 Capture screenshot only on failure
            if (scenario.isFailed()) {
                log.error("Test Failed: {}", scenario.getName());

                WebDriver driver = DriverManager.getDriver();

                if (driver != null) {
                    log.info("Capturing screenshot...");

                    byte[] screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

                    Allure.addAttachment(
                            "Failure Screenshot",
                            "image/png",
                            new ByteArrayInputStream(screenshot),
                            ".png"
                    );
                } else {
                    log.warn("Driver is null, cannot capture screenshot");
                }
            }

            Thread.sleep(500);

            // 🔥 Attach log file to Allure
            String testName = MDC.get("testName");
            String logFile = "target/logs/" + (testName != null ? testName : "default") + ".log";
            AllureUtil.attachLog(logFile);

        } catch (Exception e) {
            log.error("Error occurred in tearDown", e);
        } finally {
            DriverManager.quit();

            log.info("Browser Closed | Thread: {}", Thread.currentThread().getId());

            // ✅ Always clear MDC at end
            MDC.clear();
        }
    }
}