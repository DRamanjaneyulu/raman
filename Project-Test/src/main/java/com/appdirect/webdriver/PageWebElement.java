package com.appdirect.webdriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author PrabhuSelvakumar
 */
public class PageWebElement {

    /**
     * {@link Properties} object to store all the values from Locator.properties file.
     */
    private static Properties properties = null;

    /**
     * Get Locator value based on the key passed.
     * @param pageLocatorKey Key in Locator.properties file.
     * @return the locator value.
     */
    public static String getLocator(final String pageLocatorKey) {
        if (properties == null) {
            new PageWebElement().loadProperties();
        }
        return properties.getProperty(pageLocatorKey);
    }

    /**
     * Method to load properties from Locator.properites file.
     */
    private void loadProperties() {
        InputStream inputStream = null;
        try {
            String propFileName = "Locator.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties = new Properties();
                properties.load(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
