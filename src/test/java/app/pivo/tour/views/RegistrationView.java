package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.ios.IOSElement;

public class RegistrationView extends TestLibrary {

        String userInputForEmail = "1";
        String xcodeFields = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[";
        String xcodeFieldsSecondHalf = "]/XCUIElementTypeTextField";
        



    private final int SECOND5 = 5;
    
    private final String CREATE_ACCOUNT = "CREATE ACCOUNT";
    private final String FIRST_NAME = "FIRST NAME";
    private final String LAST_NAME = "LAST NAME";
    private final String EMAIL = "EMAIL";
    private final String PASSWORD = "PASSWORD";
    private final String CONFIRM_PASSWORD = "CONFIRM PASSWORD";
    private final String CHECK_BOX = "CHECK BOX";
    private final String RETURN_BUTTON = "RETURN BUTTON";
    private final String REGISTER = "REGISTER";
    private final String CONFIRM_CREATED = "CONFIRM CREATED";

    private final String LOC_CREATE_ACCOUNT = "//XCUIElementTypeStaticText[@name='Create account']";
    private final String LOC_FIRST_NAME = xcodeFields + 1 + xcodeFieldsSecondHalf;
    private final String LOC_LAST_NAME = xcodeFields + 2 + xcodeFieldsSecondHalf;
    private final String LOC_EMAIL = xcodeFields + 3 + xcodeFieldsSecondHalf;
    private final String LOC_PASSWORD= xcodeFields + "4]/XCUIElementTypeSecureTextField";
    private final String LOC_CONFIRM_PASSWORD = xcodeFields + "5]/XCUIElementTypeSecureTextField";
    private final String LOC_CHECK_BOX = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther";
    private final String LOC_RETURN_BUTTON = "Return";
    private final String LOC_REGISTER = "//XCUIElementTypeButton[@name='Register']";
    private final String LOC_CONFIRM_CREATED = "Ok";

    public IOSElement getViewElement(WebDriver driver, String elementText) {

        IOSElement element = null;
        switch (elementText) {
            case CREATE_ACCOUNT:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_CREATE_ACCOUNT);
                break;
            case FIRST_NAME:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_FIRST_NAME);
                break;
            case LAST_NAME:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_LAST_NAME);
                break;
            case EMAIL:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_EMAIL);
                break;
            case PASSWORD:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_PASSWORD);
                break;
            case CONFIRM_PASSWORD:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_CONFIRM_PASSWORD);
                break;
            case CHECK_BOX:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_CHECK_BOX);
                break;
            case RETURN_BUTTON:
                element = findElementByAccessibilityIDWithWait(driver, SECOND5, LOC_RETURN_BUTTON);
                break;
            case REGISTER:
                element = findElementByXpathWithWait(driver, SECOND5, LOC_REGISTER);
                break;
            case CONFIRM_CREATED:
                element = findElementByAccessibilityIDWithWait(driver, SECOND5, LOC_CONFIRM_CREATED);
                break;
        }
        return element;
    }

}
