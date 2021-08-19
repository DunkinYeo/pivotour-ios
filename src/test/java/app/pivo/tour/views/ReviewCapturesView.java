package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.ios.IOSElement;

public class ReviewCapturesView extends TestLibrary {

    private final int SECOND5 = 5;

    private final String NEXT = "NEXT";

    private final String LOC_NEXT = "//XCUIElementTypeButton[@name='Next']";

    public IOSElement getViewTitle(WebDriver driver) {
        IOSElement element = findElementByXpathWithWait(driver, SECOND5,
                "//XCUIElementTypeStaticText[@name='REVIEW CAPTURES']");
        return element;
    }

    public IOSElement getViewElement(WebDriver driver, String elementText) {

        IOSElement element = null;
        switch (elementText) {
            case NEXT:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_NEXT);
                break;
        }
        return element;
    }

}
