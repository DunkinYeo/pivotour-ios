package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MyToursView extends TestLibrary {

    private final int SECOND5 = 5;
    private final int SECOND60 = 60;

    private final String DRAFT_TOUR_TITLE = ("Title");
    private final String LOC_DRAFT_TOUR_TITLE = ("iOS ");

    public IOSElement getViewTitle(IOSDriver<WebElement> driver) {
        IOSElement element = findElementByXpathWithWait(driver, SECOND5,
                "//XCUIElementTypeStaticText[@name='MY TOURS']");
        return element;
    }

    public IOSElement getTabElement(IOSDriver<WebElement> driver, int tabOrder) {

        IOSElement tabElement = null;

        switch (tabOrder) {
            case 1:
                tabElement = findElementByXpathWithWait(driver, SECOND5, "//XCUIElementTypeStaticText[@name='Public']");
                break;
            case 2:
                tabElement = findElementByXpathWithWait(driver, SECOND5,
                        "//XCUIElementTypeStaticText[@name='Private']");
                break;
            case 3:
                tabElement = findElementByXpathWithWait(driver, SECOND5, "//XCUIElementTypeButton[@name='Draft']");
                break;
        }
        return tabElement;
    }

    public IOSElement getBottomMenuElement(IOSDriver<WebElement> driver, int menuOrder) {

        IOSElement menuElement = null;

        switch (menuOrder) {
            case 1:
                menuElement = findElementByAccessibilityIDWithWait(driver, SECOND5, "Create Tour");
                break;
            case 2:
                menuElement = findElementByAccessibilityIDWithWait(driver, SECOND5, "Create Tour");
                break;
            case 3:
                menuElement = findElementByAccessibilityIDWithWait(driver, SECOND5, "Create Tour");
                break;
        }
        System.out.println("getBottomMenuElement");

        return menuElement;
    }

    public IOSElement getViewElement(IOSDriver<WebElement> driver, String elementText, String time) {

        IOSElement element = null;
        switch (elementText) {
            case DRAFT_TOUR_TITLE:
                element = findElementByAccessibilityIDWithWait(driver, SECOND60, LOC_DRAFT_TOUR_TITLE + time);
                break;
        }
        return element;
    }

}
