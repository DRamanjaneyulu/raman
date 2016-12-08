package com.appdirect.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.appdirect.webdriver.enums.BrowserType;
import com.appdirect.webdriver.utils.TestNGLogUtil;

/**
 * @author PrabhuSelvakumar
 */
public class AppDirectWebDriver implements IAppDirectWebDriver {

    /**
     * {@link WebDriver} object.
     */
    private WebDriver driver;

    /**
     * Method to get {@link WebDriver} object based on {@link BrowserType}.
     * @see IAppDirectWebDriver#getDriver(BrowserType)
     * @param browserType {@link BrowserType} to execute test cases.
     * @return {@link WebDriver}
     */
    public WebDriver getDriver(final BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                driver = new FirefoxDriver();
                return driver;

            default:
                TestNGLogUtil.logError("Not implemented for other browsers except Firefox.");
                return null;
        }
    }
}
