package com.aqacourses.pageobject.pages;

import com.aqacourses.pageobject.base.BaseTest;
import org.junit.Assert;

public class PythonPage extends AbstractPage {

    // Title constant
    private final String TITLE = "Selenium Framework | Python Course";

    /**
     * Constructor
     *
     * @param testClass
     */
    public PythonPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(pageDiv);
    }

    /** Verify that titles are the same */
    public void verifyTitle() {
        Assert.assertEquals("Titles are not the same", TITLE, testClass.getDriver().getTitle());
    }
}
