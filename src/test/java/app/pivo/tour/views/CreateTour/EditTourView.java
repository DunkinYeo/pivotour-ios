package app.pivo.tour.views.CreateTour;

import app.pivo.tour.library.TestLibrary;

//import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.ios.IOSElement;

public class EditTourView extends TestLibrary {

    private final int SECOND10 = 10;

    private final String EDIT_THUMBNAIL = "EDIT THUMBNAIL";
    private final String CHOOSE_FROM_SCENES = "CHOOSE FROM SCENES";
    private final String POINT_1 = "POINT 1";
    private final String TOUR_EDITOR = "TOUR EDITOR";
    private final String TOUR_TITLE_FIELD = "TOUR TITLE FIELD";
    private final String KEYBOARD_RETURN = "KEYBOARD RETURN";
    private final String SAVE_BTN = "SAVE";
    private final String UPLOAD_BTN = "UPLOAD";
    private final String ALERT_OK = "ALERT OK";
    private final String TOUR_DESCRIPTION = "TOUR DESCRIPTION";
    private final String LISTING_DETAILS = "LISTING DETAILS";
    private final String SEARCH_BUTTON = "SEARCH BUTTON";
    private final String ADDRESS = "ADDRESS";
    private final String SELECT_ADDRESS = "SELECT ADDRESS";

    private final String LOC_EDIT_THUMBNAIL = "//XCUIElementTypeButton[@name='Edit Thumbnail']";
    private final String LOC_CHOOSE_FROM_SCENES = "Choose from Scenes";
    private final String LOC_POINT_1 = "Point 1";
    private final String LOC_TOUR_EDITOR = "Tour Editor";
    private final String LOC_TOUR_TITLE_FIELD = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"
            + "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView"
            + "/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeTextField";
    private final String LOC_KEYBOARD_RETURN = "Return";
    private final String LOC_SAVE_BTN = "//XCUIElementTypeButton[@name='Save']";
    private final String LOC_UPLOAD_BTN = "//XCUIElementTypeButton[@name='Upload']";
    private final String LOC_ALERT_OK = "//XCUIElementTypeButton[@name='Ok']";
    private final String LOC_TOUR_DESCRIPTION = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"
            + "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/"
            + "XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextView";
    private final String LOC_LISTING_DETAILS = "(//XCUIElementTypeButton[@name='ic right arrow'])[1]";
    private final String LOC_SEARCH_BUTTON = "ic button search";
    private final String LOC_ADDRESS = "//XCUIElementTypeSearchField[@name='Search']";
    private final String LOC_SELECT_ADDRESS = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
            + "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]";

    public IOSElement getViewTitle(WebDriver driver) {
        IOSElement element = findElementByXpathWithWait(driver, SECOND10,
                "//XCUIElementTypeStaticText[@name='EDIT TOUR']");
        return element;
    }

    public IOSElement getViewElement(WebDriver driver, String elementText) {

        IOSElement element = null;
        switch (elementText) {
            case EDIT_THUMBNAIL:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_EDIT_THUMBNAIL);
                break;
            case CHOOSE_FROM_SCENES:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_CHOOSE_FROM_SCENES);
                break;
            case POINT_1:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_POINT_1);
                break;
            case TOUR_EDITOR:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_TOUR_EDITOR);
                break;
            case TOUR_TITLE_FIELD:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_TOUR_TITLE_FIELD);
                break;
            case KEYBOARD_RETURN:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_KEYBOARD_RETURN);
                break;
            case SAVE_BTN:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_SAVE_BTN);
                break;
            case UPLOAD_BTN:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_UPLOAD_BTN);
                break;
            case ALERT_OK:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_ALERT_OK);
                break;
            case TOUR_DESCRIPTION:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_TOUR_DESCRIPTION);
                break;
            case LISTING_DETAILS:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_LISTING_DETAILS);
                break;
            case SEARCH_BUTTON:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_SEARCH_BUTTON);
                break;
            case ADDRESS:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_ADDRESS);
                break;
            case SELECT_ADDRESS:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_SELECT_ADDRESS);
                break;
        }
        return element;
    }

}
