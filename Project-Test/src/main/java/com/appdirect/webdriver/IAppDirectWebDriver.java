package com.appdirect.webdriver;

import org.openqa.selenium.WebDriver;

import com.appdirect.webdriver.enums.BrowserType;

public interface IAppDirectWebDriver {

    /**
     * Method to get {@link WebDriver} object based on {@link BrowserType}.
     * @see IAppDirectWebDriver#getDriver(BrowserType)
     * @param browserType {@link BrowserType} to execute test cases.
     * @return {@link WebDriver}
     */
    WebDriver getDriver(BrowserType bType);
}
