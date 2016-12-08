package com.appdirect.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.appdirect.webdriver.PageWebElement;
import com.appdirect.webdriver.properties.AppDirectAppProperties;
import com.appdirect.webdriver.utils.TestNGLogUtil;
import com.appdirect.webdriver.utils.WebDriverUtil;

/**
 * @author PrabhuSelvakumar
 */
public class LandingPage {

    /**
     * {@link WebDriver} object.
     */
    private final WebDriver driver;
    /**
     * Locator for Login link.
     */
    By loginLink = By.xpath(PageWebElement.getLocator("landingPage.loginLink"));

    /**
     * Constructor.
     * @param driver {@link WebDriver} object.
     */
    public LandingPage(final WebDriver driver) {
        this.driver = driver;
        this.driver.get(AppDirectAppProperties.getAppUrl());
        Assert.assertTrue(WebDriverUtil.waitForURL(driver, "www.appdirect.com"),
                "Landing page Url is not matching.");
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Click login link appears in the page.
     * @return the {@link LoginPage}
     */
    public LoginPage clickLogin() {
        TestNGLogUtil.logInfo("Clicks on the Login link.");
        WebElement element = WebDriverUtil.findVisibleElement(driver, loginLink);
        element.click();
        return new LoginPage(driver);
    }

}
