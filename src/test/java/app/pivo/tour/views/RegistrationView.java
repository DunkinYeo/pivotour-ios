package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.ios.IOSElement;

public class RegistrationView extends TestLibrary {

    private final int SECOND5 = 5;
    
    private final String GOOGLE_LOGIN = "GOOGLE LOGIN";
    private final String SNS_LOGIN = "SNS LOGIN";
    private final String URL_GOOGLE = "URL GOOGLE";
    private final String TEST_ACCOUNT = "TEST ACCOUNT";

    private final String LOC_GOOGLE_LOGIN = "ic button login google";
    private final String LOC_SNS_LOGIN = "Continue";
    private final String LOC_URL_GOOGLE = "//XCUIElementTypeOther[@name='URL']";
    private final String LOC_TEST_ACCOUNT = "Test 3i test@3i.ai";

    public IOSElement getViewElement(WebDriver driver, String elementText) {

        IOSElement element = null;
        switch (elementText) {
            case GOOGLE_LOGIN:
                element = findElementByAccessibilityIDWithWait(driver, SECOND5, LOC_GOOGLE_LOGIN);
                break;
            case SNS_LOGIN:
                element = findElementByAccessibilityIDWithWait(driver, SECOND5, LOC_SNS_LOGIN);
                break;
            case URL_GOOGLE:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_URL_GOOGLE);
                break;
            case TEST_ACCOUNT:
                element = findElementByAccessibilityIDWithWait(driver, SECOND5, LOC_TEST_ACCOUNT);
                break;
        }
        return element;
    }

}
