package com.aqacourses.pageobject.tests;

import com.aqacourses.pageobject.base.BaseTest;
import com.aqacourses.pageobject.pages.HomePage;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class OpenSiteAndClickPythonLinkTest2 extends BaseTest {

    // Web Elements
    @FindBy(xpath = "//ul[@id='main-nav']//a/span[.='PYTHON']/..")
    private WebElement pythonLink;

    @FindBy(xpath = "//ul[@id='main-nav']//a/span[.='PYTHON']/..")
    private List<WebElement> pythonListLink;

    @FindBy(xpath = "//div[@class='wpb_wrapper']//a[contains(., 'Continuous Test Automation')]")
    private WebElement continuousLink;

    /*
     * You can add to @FindBys as many @FindBy as you want. But if one of them find nothing list will be empty
     * Work as AND. This one AND this one AND this one
     */
    @FindBys({
        @FindBy(xpath = "//div[@class='wpb_wrapper']//a[contains(., 'Solution')]"),
        @FindBy(xpath = "//div[@class='wpb_wrapper']//a[contains(., 'Decision1')]")
    })
    private List<WebElement> findBysList;

    /*
     * You can add to @FindAll as many @FindBy as you want. If one of them find nothing it will not affect others.
     * Work as OR. This one OR this one OR this one
     */
    @FindAll({
        @FindBy(xpath = "//div[@class='wpb_wrapper']//a[contains(., 'Solution')]"),
        @FindBy(xpath = "//div[@class='wpb_wrapper']//a[contains(., 'Decision1')]")
    })
    private List<WebElement> findAllList;

    /** setUp() method to initialize WebElements */
    @Before
    public void setUp() {
        PageFactory.initElements(getDriver(), this);
    }

    /** Test with different tricks */
    @Test
    public void testOpenSiteAndClickTheLinkTest2() {
        HomePage homePage = openSite();

        // ===================== - Avoid NoSuchElementException with try-catch -
        // ===========================
        try {
            pythonLink.click();
        } catch (Exception e) {
        }

        // ===================== - Avoid NoSuchElementException with list -
        // ===========================
        if (pythonListLink.size() == 0) {
            System.out.println("Nothing");
        } else {
            System.out.println("Something");
            pythonListLink.get(0).click();
        }

        // ===================== - Execute JavaScript code - ===========================
        // String that contains JS code
        String js =
                "var list = document.getElementsByTagName(\"h3\");\n"
                        + "for (var i = 0; i < list.length; i++) { \n"
                        + "   if (list[i].id.match(\"ui-id\")) {\n"
                        + "     list[i].click();\n"
                        + "   }  \n"
                        + "}";
        // Initialize Javascript executor and execute code
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript(js);

        // ===================== - Work with Alert - ===========================

        // Create Alert using JS
        javascriptExecutor.executeScript("alert('This is alert')");

        // Switch to the Alert
        Alert alert = getDriver().switchTo().alert();

        // Accept it
        alert.accept();

        // ===================== - Open link in new tab and switch to it -
        // ===========================

        // Open link in new tab
        String actualWindow = getDriver().getWindowHandle();
        pythonLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

        Set<String> windows = getDriver().getWindowHandles();
        String newWindow = null;
        for (String window : windows) {
            if (!window.equals(actualWindow)) {
                newWindow = window;
            }
        }
        getDriver().switchTo().window(newWindow);
        getDriver().close();
        getDriver().switchTo().window(actualWindow);
        System.out.println(getDriver().getTitle());

        // ===================== - Actions - ===========================

        Actions actions = new Actions(getDriver());

        // Move to element
        actions.moveToElement(continuousLink).perform();

        // ===================== - Cookies - ===========================

        // Getting sets of cookies. Set can contain only unique cells that's why it used for cookies
        Set<Cookie> cookies = getDriver().manage().getCookies();

        // You can create new one
        Cookie newCookie = new Cookie("New name", "New Value", "New Path", new Date());

        // You can add it to the set
        cookies.add(newCookie);

        // You can remove it from Set
        cookies.remove(newCookie);

        // Also you have a bunch of methods to work with cookie
        newCookie.getDomain();
        newCookie.getExpiry();
        newCookie.getName();
        newCookie.getPath();
        newCookie.getValue();
        newCookie.isHttpOnly();
        newCookie.isSecure();
    }
}
