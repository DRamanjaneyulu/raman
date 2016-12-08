package com.appdirect.webdriver.utils;

/**
 * @author PrabhuSelvakumar
 */
public class OSUtil {

    /**
     * OS name.
     */
    private static String OS = null;

    /**
     * Get the OS name.
     * @return the OS name.
     */
    public static String getOsName() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS.trim().toLowerCase();
    }

    /**
     * Checks if OS is Linux.
     * @return True if OS is Linux otherwise False.
     */
    public static boolean isLinux() {
        return getOsName().indexOf("nux") >= 0;
    }

    /**
     * Checks if OS is Mac.
     * @return True if OS is Mac otherwise False.
     */
    public static boolean isMac() {
        return getOsName().indexOf("mac") >= 0;
    }

    /**
     * Checks if OS is Windows.
     * @return True if OS is Windows otherwise False.
     */
    public static boolean isWindows()
    {
       return getOsName().indexOf("win") >= 0;
    }
}
