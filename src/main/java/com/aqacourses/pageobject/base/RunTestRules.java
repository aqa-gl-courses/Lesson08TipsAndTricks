package com.aqacourses.pageobject.base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class extends from TestWatcher class from JUnit framework With this combination you can
 * override methods from TestWatcher and add realization for them and create rule for test running
 */
public class RunTestRules extends TestWatcher {

    // Instance of BaseTest
    private BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public RunTestRules(BaseTest testClass) {
        this.testClass = testClass;
    }

    /**
     * When test is finished, just quit from driver This method is override from TestWatcher
     *
     * @param description
     */
    @Override
    protected void finished(Description description) {
        testClass.getDriver().quit();
    }

    /**
     * When test is failed, create screenshot, write down error message to log and quit from browser
     * This method is override from TestWatcher
     *
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {
        // Path to directory for screenshots
        File baseDir = new File("src/main/resources/screenshots");

        // If directory doesn't exist - create it
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }

        // Get test class name and method name
        String className = description.getTestClass().getSimpleName();
        String methodName = description.getMethodName();

        // Create name of screenshot
        String screenshotName =
                baseDir.getAbsolutePath()
                        + "/"
                        + className
                        + "-"
                        + methodName
                        + "-"
                        + testClass.getDateTime()
                        + ".png";

        File targetFile = new File(screenshotName);

        // Create screenshot and copy it to the directory
        try {
            FileUtils.copyFile(
                    ((TakesScreenshot) testClass.getDriver()).getScreenshotAs(OutputType.FILE),
                    targetFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Write down to log file error message
        testClass.error(e.getMessage());

        // Driver quits on fail
        testClass.getDriver().quit();
    }
}
