package com.appdirect.webdriver.logger;

import org.testng.Reporter;

/**
 * @author PrabhuSelvakumar
 */
public class Logger {

    /**
     * Get the instance of {@link Logger}
     * @return the {@link Logger}.
     */
    public static Logger getLogger() {
     return new Logger();
    }

    /**
     * Constructor.
     */
    private Logger() {
    }

    /**
     * Output a formatted log line at the error log level.
     * @param format the format string
     * @param objects values to format
     */
    public void error(final String format, final Object... objects) {
        String msg = format(format, objects);
        StringBuilder str = new StringBuilder();
        str.append("<font color=\"red\">");
        str.append(msg);
        str.append("</font>");
        Reporter.log(str.toString());
    }

    /**
     * Output a formatted log line at the info log level.
     * @param format the format string
     * @param objects values to format
     */
    public void info(final String format, final Object... objects) {
        String finalMsg = format(format, objects);
        Reporter.log(finalMsg);
    }

    /**
     * Output a formatted log line at the warn log level.
     * @param format the format string
     * @param objects values to format
     */
    public void warn(final String format, final Object... objects) {
        String msg = format(format, objects);
        StringBuffer str = new StringBuffer();
        str.append("<font color=\"orange\">");
        str.append(msg);
        str.append("</font>");
        Reporter.log(str.toString());
    }

    /**
     * This is a wrapper around the String.format() method.
     * @param format the format string
     * @param objects the arguments
     * @return the formatted message.
     */
    private String format(final String format, final Object... objects) {
        String msg = "";
        try {
            msg = String.format(format, objects);
        } catch (Throwable e) {
            Reporter.log("<pre><font color=\"red\">" + e.getMessage().toString() + "</font></pre>");
            return "";
        }
        return msg;
    }
}
