package com.jalasoft.sdfc.core.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Chrome extends AbstractDriver{
    @Override
    WebDriver initDriver() {
        // The following is to avoid the notification dialog which comes from chrome
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
