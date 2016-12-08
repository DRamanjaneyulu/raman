package com.appdirect.webdriver.utils;

import com.appdirect.webdriver.logger.Logger;

/**
 * @author PrabhuSelvakumar
 */
public class TestNGLogUtil {

    /**
     * Get the instance of {@link Logger}.
     */
    private static final Logger logger = Logger.getLogger();

    /**
     * Log the given error message.
     * @param message the error message.
     * @param object {@link Object}
     */
    public static final void logError(final String message, final Object... object) {
        logger.error(message, object);
    }

    /**
     * Log the given info message.
     * @param message the error message.
     */
    public static final void logInfo(final String message) {
        logger.info("%s", message);
    }

    /**
     * Log the setup step.
     * @param str step description.
     */
    public static final void logSetUpStep(final String str) {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("Setup ## ");
        strBuffer.append(str);
        logger.info(strBuffer.toString());
    }

    /**
     * Log the tear down step.
     * @param str step description.
     */
    public static final void logTearDownStep(final String str) {
        logTestStep("TearDown: " + str);
    }

    /**
     * Log the test step.
     * @param str step description.
     */
    public static final void logTestStep(final String str) {
        logger.info(str);
    }

    /**
     * Log the test verification step.
     * @param str the description of the verification.
     */
    public static final void logTestVerificationStep(final String str) {
        logger.info("Verification Step: %s", str);
    }

    /**
     * Log the given message as a warning.
     * @param message the error message.
     */
    public static final void logWarning(final String message) {
        logger.warn(message);
    }
}
