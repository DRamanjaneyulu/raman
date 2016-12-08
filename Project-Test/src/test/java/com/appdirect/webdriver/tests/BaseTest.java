package com.appdirect.webdriver.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appdirect.webdriver.AppDirectWebDriver;
import com.appdirect.webdriver.IAppDirectWebDriver;
import com.appdirect.webdriver.properties.AppDirectAppProperties;
import com.appdirect.webdriver.utils.OSUtil;
import com.appdirect.webdriver.utils.TestNGLogUtil;

/**
 * @author PrabhuSelvakumar
 */
public class BaseTest {

    /**
     * {@link WebDriver} object.
     */
    private WebDriver driver;

    /**
     * Get the {@link WebDriver}.
     * @return {@link WebDriver} object.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Set up method.
     */
    @BeforeClass
    public void setup() {
        TestNGLogUtil.logSetUpStep("Initializing the setup.");
        // This setup require if we use Selenium 3.0.0-beta1 version.
        // setGeckoDriver();
        IAppDirectWebDriver appDirectWebDriver = new AppDirectWebDriver();
        driver = appDirectWebDriver.getDriver(AppDirectAppProperties.getBrowserType());
        TestNGLogUtil.logTestStep("## Finished setup.");
    }

    /**
     * Tear down method.
     */
    @AfterClass
    public void teardown() {
        TestNGLogUtil.logTearDownStep("Initiate tear down steps.");
        getDriver().quit();
        TestNGLogUtil.logTestStep("## Tear down steps completed.");
    }

    /**
     * Set gecko driver in system property.
     */
    private void setGeckoDriver() {
        String geckoLocation =
                System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator;
        if (OSUtil.isWindows()) {
            geckoLocation += "windows" + File.separator + "geckodriver.exe";
        } else if (OSUtil.isMac()) {
            geckoLocation += "mac" + File.separator + "geckodriver";
        } else if (OSUtil.isLinux()) {
            geckoLocation += "linux" + File.separator + "geckodriver";
        }

        System.setProperty("webdriver.gecko.driver", geckoLocation);
    }
}
