package ru.aplana.autotest.utils;

import org.openqa.selenium.WebDriver;

public class Init {
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Init.driver = driver;
    }

    private static WebDriver driver;
}
