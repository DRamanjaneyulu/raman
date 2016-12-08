package com.appdirect.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.appdirect.webdriver.PageWebElement;
import com.appdirect.webdriver.utils.WebDriverUtil;

/**
 * @author PrabhuSelvakumar
 */
public class PartnerRegisterPage {

    /**
     * {@link WebDriver} object.
     */
    private final WebDriver driver;
    /**
     * Locator for sign up button in the page.
     */
    By signUpButton = By.name(PageWebElement.getLocator("partnerRegisterPage.signUpButton"));

    /**
     * Constructor.
     * @param driver {@link WebDriver} object.
     */
    public PartnerRegisterPage(final WebDriver driver) {
        this.driver = driver;
        Assert.assertTrue(WebDriverUtil.waitForURL(driver, "/developers/register?"),
                "Partner register page url is not matching.");
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Checks if the sign up button present or not.
     * @return True if the sign up button present otherwise False.
     */
    public boolean isSignUpButtonPresent() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, signUpButton);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
