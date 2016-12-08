package com.appdirect.webdriver.tests.signup;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appdirect.webdriver.pages.LandingPage;
import com.appdirect.webdriver.pages.LoginPage;
import com.appdirect.webdriver.pages.PartnerRegisterPage;
import com.appdirect.webdriver.pages.SignUpPage;
import com.appdirect.webdriver.tests.BaseTest;
import com.appdirect.webdriver.utils.TestNGLogUtil;

/**
 * @author PrabhuSelvakumar
 */
public class SignUpTest extends BaseTest {

    /**
     * Method to get duplicate email.
     * @return the array of duplicate email.
     */
    @DataProvider
    public Object[][] duplicateEmail() {
        String emailAddress = getUniqueEmail();
        return new Object[][] { {emailAddress}, {emailAddress}};
    }

    /**
     * Method to get the list of email address with invalid format.
     * @return the array of email with invalid format.
     */
    @DataProvider
    public Object[][] invalidEmailFormat() {
        return new Object[][] { {"abcd@a.z"}, {"_fds$@df.a"}, {"147582@125.3"}};
    }

    @Test(description = "Test to verify clicking log in link in sign "
            + "up page redirect to log in page. Test ID is TC001")
    public void testClickingLogInLinkInSignUpPageRedirectToLogInPage() {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        loginPage = signUpPage.clickLogInLink();
        TestNGLogUtil.logTestVerificationStep("Verify the login button present on the Login page.");
        Assert.assertTrue(loginPage.isLogInButtonPresent(),
                "Login button should be present but its not.");
    }

    @Test(description = "Test to verify clicking partner register link in sign up page redirect "
            + "to partner register page. Test ID is TC002.")
    public void testClickingPartnerRegisterLinkInSignUpPageRedirectToPartnerRegisterPage() {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        PartnerRegisterPage partnerRegisterPage = signUpPage.clickPartnerRegisterLink();
        TestNGLogUtil.logTestVerificationStep("Verify the sign up button present on the "
                + "Partner Register page.");
        Assert.assertTrue(partnerRegisterPage.isSignUpButtonPresent(),
                "Sign up button should be present but its not.");
    }

    @Test(description = "Test to verify default state of sign in button and email "
            + "address text box. Test ID is TC003.")
    public void testDefaultStateOfSignUpButtonAndEmailAddressTextBox() {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        TestNGLogUtil.logTestVerificationStep("Verify the Email text box is enabled on the "
                + "Sign up page.");
        Assert.assertTrue(signUpPage.isEmailTextBoxEnabled(),
                "Email address text box should be enabled but its not.");
        TestNGLogUtil.logTestVerificationStep("Verify the Sign up button is enabled on the "
                + "Sign up page.");
        Assert.assertTrue(signUpPage.isSignUpButtonEnabled(),
                "Sign up button should be enabled but its not.");
    }

    @Test(dataProvider = "duplicateEmail",
            description = "Test to verify error message is present for sign up with "
                    + "duplicate email. Test ID is TC004.")
    public void testForDuplicateEmailAddress(final String email) {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        signUpPage.enterEmailAddress(email);
        signUpPage.clickSignUpButton();
        if (signUpPage.isSignUpSuccess()) {
            TestNGLogUtil.logTestVerificationStep("Registered the email " + email
                    + " successfully.");
        } else if (signUpPage.isDuplicateEmailErrorMessagePresent()) {
            TestNGLogUtil.logTestVerificationStep("Successfully got error message for "
                    + "duplicate email " + email);
        } else {
            TestNGLogUtil.logError("Failing the test since the expected behavior was not met.");
            Assert.fail("Failing the test since the expected behavior was not met.");
        }
    }

    @Test(dataProvider = "invalidEmailFormat",
            description = "Test to verify error message for sign up with invalid"
                    + " email format. Test ID is TC005.")
    public void testForInvalidEmailFormat(final String invalidEmailFormat) {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        signUpPage.enterEmailAddress(invalidEmailFormat);
        signUpPage.clickSignUpButton();
        TestNGLogUtil.logTestVerificationStep("Verify the invalid email format error "
                + "message for the email id " + invalidEmailFormat);
        Assert.assertTrue(signUpPage.isInvalidEmailFormatErrorMessagePresent(),
                "Invalid email format error message was not present for email "
                        + invalidEmailFormat);
    }

    @Test(dataProvider = "validEmail",
            description = "Test for successful sign up. Test ID is TC006.")
    public void testForSuccessfulSignUp(final String email) {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        signUpPage.enterEmailAddress(email);
        signUpPage.clickSignUpButton();
        TestNGLogUtil.logTestVerificationStep("Verify the sign up success message.");
        Assert.assertTrue(signUpPage.isSignUpSuccess(),
                "Sign up success message should be displayed but its not for email " + email);
    }

    @Test(description = "Test to verify the maximum char limit in email "
            + "text box. Test ID is TC007.")
    public void testMaxCharLimitInEmailTextBox() {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        String maxCharText = "";
        for (int i = 0; i < 300; i++) {
            maxCharText = maxCharText + "A";
        }
        signUpPage.enterEmailAddress(maxCharText);
        String emailTextBoxValue = signUpPage.getEmailTextBoxValue();
        TestNGLogUtil.logTestVerificationStep("Verify the max character length for email "
                + "text box.");
        Assert.assertEquals(emailTextBoxValue.length(), 255,
                "Max characters in email text box should be 255 but its not.");
    }

    @Test(description = "Test to verify sign up with empty email address. Test ID is TC008.")
    public void testSignUpPageWithEmptyEmailAddress() {
        LandingPage landingPage = new LandingPage(getDriver());
        LoginPage loginPage = landingPage.clickLogin();
        SignUpPage signUpPage = loginPage.clickSignUpLink();
        signUpPage.enterEmailAddress("");
        signUpPage.clickSignUpButton();
        TestNGLogUtil.logTestVerificationStep("Verify the sign up page is shown for "
                + "empty email address.");
        Assert.assertTrue(signUpPage.isSignUpButtonPresent(),
                "Sign up page should be displayed for empty email address but its not. ");
        signUpPage.enterEmailAddress("        ");
        signUpPage.clickSignUpButton();
        TestNGLogUtil.logTestVerificationStep("Verify the sign up page is shown for "
                + "spaces in email address field.");
        Assert.assertTrue(signUpPage.isSignUpButtonPresent(),
                "Sign up page should be displayed for spaces in email address field but its not. ");
    }

    /**
     * Method to get the list of email address with valid format.
     * @return the array of email with valid format.
     */
    @DataProvider
    public Object[][] validEmail() {
        return new Object[][] { {getUniqueEmail()}, {getUniqueEmail().replace("com", "co.in")}};
    }

    /**
     * Get unique email address.
     * @return unique email address.
     */
    private String getUniqueEmail() {
        final SecureRandom random = new SecureRandom();
        String dynamicText = new BigInteger(30, random).toString(32);
        return dynamicText = dynamicText + "@appdirect.com";
    }
}
