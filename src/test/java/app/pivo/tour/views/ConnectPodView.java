package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;
import app.pivo.tour.tests.CreateTourTest;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ConnectPodView extends TestLibrary {

    // private final int SECOND5 = 5;
    private final int SECOND10 = 10;
    // private final int SECOND60 = 60;

    private final String CONNECT = "CONNECT";
    private final String POD = "Pivo";

    private final String LOC_CONNECT = "//XCUIElementTypeStaticText[@name='Connect']";
    private final String LOC_POD = CreateTourTest.podName;
    
    public IOSElement getViewElement(IOSDriver<WebElement> driver, String elementText) {

        IOSElement element = null;

        switch (elementText) {
            case CONNECT:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_CONNECT);
                break;
            case POD:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_POD);
                break;
        }
        return element;
    }

}
