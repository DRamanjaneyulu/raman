package com.appdirect.webdriver.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

/**
 * @author PrabhuSelvakumar
 */
public class WebDriverUtil {

    /**
     * Default timeout for web elements.
     */
    private static int DEFAULT_TIMEOUT = 30;

    /**
     * Method to wait and find the visible element in the page.
     * @param driver {@link WebDriver} object.
     * @param by {@link By} locator.
     * @return the {@link WebElement}.
     */
    public static WebElement findVisibleElement(final WebDriver driver, final By by) {
        Wait<WebDriver> wait =
                new FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(final WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return webElement;
    }

    /**
     * Method to wait for URL appear in the browser.
     * @param driver {@link WebDriver} object.
     * @param url The expected URL.
     * @return True if the URL present otherwise False.
     */
    public static boolean waitForURL(final WebDriver driver, final String url) {
        long timeOut = System.currentTimeMillis() + DEFAULT_TIMEOUT;
        while (System.currentTimeMillis() < timeOut) {
            Wait<WebDriver> wait =
                    new FluentWait<WebDriver>(driver)
                            .withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).pollingEvery(5,
                                    TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

            boolean isUrlPresent = wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    return d.getCurrentUrl().contains(url);
                }
            });

            if (isUrlPresent) {
                return isUrlPresent;
            }
        }
        return false;
    }
}
