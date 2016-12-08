package com.appdirect.webdriver.properties;

import com.appdirect.webdriver.enums.BrowserType;

/**
 * @author PrabhuSelvakumar
 */
public class AppDirectAppProperties {

    /**
     * Application URl.
     */
    private static String APP_URL = "http://www.appdirect.com/";
    /**
     * Set the default browser type as firefox.
     */
    private static BrowserType BROWSER_TYPE = BrowserType.FIREFOX;

    /**
     * Get the application URL.
     * @return the application URL.
     */
    public static String getAppUrl() {
        return APP_URL;
    }

    /**
     * Get the default browser type.
     * @return the {@link BrowserType}
     */
    public static BrowserType getBrowserType() {
        return BROWSER_TYPE;
    }
}
