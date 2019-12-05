package com.aqacourses.pageobject.tests;

import com.aqacourses.pageobject.base.BaseTest;
import com.aqacourses.pageobject.pages.HomePage;
import com.aqacourses.pageobject.pages.PythonPage;
import org.junit.Test;

public class OpenSiteAndClickPythonLinkTest extends BaseTest {

    /** Open site and click on Python link. Verify title */
    @Test
    public void testOpenSiteAndClickPythonLinkTest() {

        // Initialize HomePage
        HomePage homePage = openSite();
        log("Initialized HomePage");

        // Click on Python Link
        PythonPage pythonPage = homePage.clickPythonLink();
        log("Clicked on Python link");

        // Verify title
        pythonPage.verifyTitle();
        log("Verified title");
    }
}
