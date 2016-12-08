package com.appdirect.webdriver.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appdirect.webdriver.utils.TestNGLogUtil;

/**
 * @author PrabhuSelvakumar
 */
public class TestListener implements ITestListener {

    /**
     * Invoked after all the tests have run and all their Configuration methods have been called.
     * @param context {@link ITestContext}
     */
    public void onFinish(final ITestContext context) {
        TestNGLogUtil.logInfo("Completed execution of the test suite.");
    }

    /**
     * Invoked after the test class is instantiated and before any configuration method is called.
     * @param context {@link ITestContext}
     */
    public void onStart(final ITestContext context) {
        TestNGLogUtil.logInfo("Executing the test suite.");
    }

    /**
     * Invoked each time a method fails but has been annotated with successPercentage and this
     * failure still keeps it within the success percentage requested.
     * @param result ITestResult containing information about the run test
     */
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
        // TODO Auto-generated method stub

    }

    /**
     * Invoked each time a test fails.
     * @param result ITestResult containing information about the run test
     */
    public void onTestFailure(final ITestResult result) {
        TestNGLogUtil.logError("Test Failure: " + result.getMethod().getMethodName());
    }

    /**
     * Invoked each time a test is skipped.
     * @param result ITestResult containing information about the run test
     */
    public void onTestSkipped(final ITestResult result) {
        TestNGLogUtil.logWarning("Test Skipped: " + result.getMethod().getMethodName());

    }

    /**
     * Invoked each time before a test will be invoked. The ITestResult is only partially filled
     * with the references to class, method, start millis and status.
     * @param result the partially filled ITestResult
     */
    public void onTestStart(final ITestResult result) {
        TestNGLogUtil.logTestStep(result.getMethod().getMethodName());
        TestNGLogUtil.logTestStep(result.getMethod().getDescription());
    }

    /**
     * Invoked each time a test succeeds.
     * @param result ITestResult containing information about the run test
     */
    public void onTestSuccess(final ITestResult result) {
        TestNGLogUtil.logTestStep("Successfully completed the test: "
                + result.getMethod().getMethodName());
    }

}
