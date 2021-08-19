package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.ios.IOSElement;

public class CaptureView extends TestLibrary {

    private final int SECOND5 = 5;
    private final int SECOND10 = 10;
    private final int SECOND30 = 30;
    private final int SECOND60 = 60;

    private final String Capture3D = "3D";
    private final String Capture2D = "2D";
    private final String TILT = "TILT";
    private final String NOT_TILT = "NOT TILT";
    private final String START = "START";
    private final String FLOOR = "FLOOR";
    private final String FINISH = "FINISH";
    private final String RECORD = "RECORD";
    private final String START_NEW_FLOOR = "START NEW F";

    private final String Loc_3D = "//XCUIElementTypeButton[@name='Yes, I want to capture 3D']";
    private final String Loc_2D = "//XCUIElementTypeButton[@name='No, I will try it later']";
    private final String Loc_TILT = "//XCUIElementTypeButton[@name='Yes']";
    private final String Loc_NOT_TILT = "//XCUIElementTypeButton[@name='No']";
    private final String LOC_START = "//XCUIElementTypeStaticText[@name='START']";
    private final String LOC_FLOOR = "//XCUIElementTypeButton[@name='Floor']";
    private final String LOC_FINISH = "//XCUIElementTypeButton[@name='Finish']";
    private final String LOC_RECORD = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
            + "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[4]";
    private final String LOC_START_NEW_FLOOR = "Start";

    public IOSElement getViewElement(WebDriver driver, String elementText) {

        IOSElement element = null;

        switch (elementText) {
            case Capture2D:
                element = findElementByXpathWithWait(driver, SECOND10, Loc_2D);
                break;
            case Capture3D:
                element = findElementByXpathWithWait(driver, SECOND10, Loc_3D);
                break;
            case TILT:
                element = findElementByXpathWithWait(driver, SECOND10, Loc_TILT);
                break;
            case NOT_TILT:
                element = findElementByXpathWithWait(driver, SECOND10, Loc_NOT_TILT);
                break;
            case START:
                element = findElementByXpathWithWait(driver, SECOND60, LOC_START);
                break;
            case FLOOR:
                element = findElementByXpathWithWait(driver, SECOND60, LOC_FLOOR);
                break;
            case FINISH:
                element = findElementByXpathWithWait(driver, SECOND30, LOC_FINISH);
                break;
            case RECORD:
                element = findElementByXpathWithWait(driver, 120, LOC_RECORD);
                break;
            case START_NEW_FLOOR:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_START_NEW_FLOOR);
                break;
        }
        return element;
    }

    public IOSElement getViewAlertElement(WebDriver driver, String elementText) {

        IOSElement element = null;

        switch (elementText) {
            case "NO":
                element = findElementByXpathWithWait(driver, SECOND5, "//XCUIElementTypeStaticText[@name='No']");
                break;
            case "FINISH":
                element = findElementByXpathWithWait(driver, SECOND5, "//XCUIElementTypeStaticText[@name='Finish']");
                break;
        }
        return element;
    }

}
