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
public class SignUpPage {

    /**
     * {@link WebDriver} object.
     */
    private final WebDriver driver;
    /**
     * Locator for email address text box in the page.
     */
    By emailIdTextbox = By.name(PageWebElement.getLocator("signUpPage.emailAddress"));
    /**
     * Locator for sign up button in the page.
     */
    By signUpButton = By.name(PageWebElement.getLocator("signUpPage.signUpButton"));
    /**
     * Locator for sign up success in the page.
     */
    By signUpSuccess = By.xpath(PageWebElement.getLocator("signUpPage.success"));
    /**
     * Locator for duplicate email error message in the page.
     */
    By signUpDuplicateEmailErrorMsg = By.xpath(PageWebElement
            .getLocator("signUpPage.duplicateEmailErrorMsg"));
    /**
     * Locator for invalid email format error message in the page.
     */
    By invalidEmailFormat = By.xpath(PageWebElement.getLocator("signUpPage.invalidEmailFormat"));
    /**
     * Locator for login link in the page.
     */
    By loginLink = By.xpath(PageWebElement.getLocator("singUpPage.loginLink"));
    /**
     * Locator for partner register link in the page.
     */
    By partnerRegisterLink = By.xpath(PageWebElement.getLocator("signUpPage.partnerRegisterLink"));

    /**
     * Constructor.
     * @param driver {@link WebDriver} object.
     */
    public SignUpPage(final WebDriver driver) {
        this.driver = driver;
        Assert.assertTrue(WebDriverUtil.waitForURL(driver, "/signup?"),
                "Sign up page url is not matching.");
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Click login link.
     * @return the {@link LoginPage}.
     */
    public LoginPage clickLogInLink() {
        TestNGLogUtil.logInfo("Clicks on the Login link.");
        WebElement element = WebDriverUtil.findVisibleElement(driver, loginLink);
        element.click();
        return new LoginPage(driver);
    }

    /**
     * Click sign up link to go to partner register page.
     * @return the {@link PartnerRegisterPage}.
     */
    public PartnerRegisterPage clickPartnerRegisterLink() {
        TestNGLogUtil.logInfo("Clicks on the Partner Register link.");
        WebElement element = WebDriverUtil.findVisibleElement(driver, partnerRegisterLink);
        element.click();
        return new PartnerRegisterPage(driver);
    }

    /**
     * Click sign up button.
     * @return the {@link SignUpPage}
     */
    public SignUpPage clickSignUpButton() {
        TestNGLogUtil.logInfo("Clicks on the Sign Up button.");
        WebElement element = WebDriverUtil.findVisibleElement(driver, signUpButton);
        element.click();
        return this;
    }

    /**
     * Enter email address in the eamil text box.
     * @param emailAddress Emaill address to sign up with.
     */
    public void enterEmailAddress(final String emailAddress) {
        TestNGLogUtil.logInfo("Enter the email address: " + emailAddress);
        WebElement element = WebDriverUtil.findVisibleElement(driver, emailIdTextbox);
        element.clear();
        element.sendKeys(emailAddress);
    }

    /**
     * Get email text box value.
     * @return the value from email text box.
     */
    public String getEmailTextBoxValue() {
        WebElement element = WebDriverUtil.findVisibleElement(driver, emailIdTextbox);
        return element.getAttribute("value");
    }

    /**
     * Checks if duplicate emaill error message present or not.
     * @return True if the error message present otherwise False.
     */
    public boolean isDuplicateEmailErrorMessagePresent() {
        try {
            WebElement element =
                    WebDriverUtil.findVisibleElement(driver, signUpDuplicateEmailErrorMsg);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if email text box enable or not.
     * @return True if the text box enabled otherwise False.
     */
    public boolean isEmailTextBoxEnabled() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, emailIdTextbox);
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if invalid email format error message present or not.
     * @return True if the error message present otherwise False.
     */
    public boolean isInvalidEmailFormatErrorMessagePresent() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, invalidEmailFormat);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if sign up button enabled or not.
     * @return True if the button enabled otherwise False.
     */
    public boolean isSignUpButtonEnabled() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, signUpButton);
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the sign up button present or not.
     * @return True if the button present otherwise False.
     */
    public boolean isSignUpButtonPresent() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, signUpButton);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the sign up success or not.
     * @return True if the sign up success otherwise False.
     */
    public boolean isSignUpSuccess() {
        try {
            WebElement element = WebDriverUtil.findVisibleElement(driver, signUpSuccess);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
