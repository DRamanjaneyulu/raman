package com.appdirect.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.appdirect.webdriver.PageWebElement;
import com.appdirect.webdriver.utils.TestNGLogUtil;
import com.appdirect.webdriver.utils.WebDriverUtil;

/**
 * @author PrabhuSelvakumar
 */
public class LoginPage {

    /**
     * {@link WebDriver} object.
     */
    private final WebDriver driver;
    /**
     * Locator for sign up link in the page.
     */
    By signUpLink = By.xpath(PageWebElement.getLocator("loginPage.signUpLink"));
    /**
     * Locator for login button in the page.
     */
    By logInButton = By.name(PageWebElement.getLocator("loginPage.logInButton"));

    /**
     * Constructor.
     * @param driver {@link WebDriver} object.
     */
	public LoginPage(final WebDriver driver) {
        this.driver = driver;
        Assert.assertTrue(WebDriverUtil.waitForURL(driver, "/login?"),
                "Login page Url is not matching.");
		PageFactory.initElements(this.driver, this);
	}

    /**
     * Click sign up link.
     * @return the {@link SignUpPage}.
     */
	public SignUpPage clickSignUpLink() {
        TestNGLogUtil.logInfo("Clicks on the Sign Up link.");
		WebElement element = WebDriverUtil.findVisibleElement(driver,
				signUpLink);
		element.click();
		return new SignUpPage(driver);
	}

    /**
     * Checks if the log in button present or not.
     * @return True if the login button present otherwise False.
     */
    public boolean isLogInButtonPresent() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, logInButton);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
