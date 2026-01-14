package com.kritika.testingFramework.execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestExecutor {
    public boolean run(String url) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(url);
            return driver.getTitle() != null;
        } catch (Exception e) {
            return false;
        } finally {
            driver.quit();
        }
    }
}
