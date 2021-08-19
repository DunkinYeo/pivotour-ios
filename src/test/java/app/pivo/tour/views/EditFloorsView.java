package app.pivo.tour.views;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.ios.IOSElement;

public class EditFloorsView extends TestLibrary {

    private final int SECOND10 = 10;
    private final int SECOND30 = 30;

    private final String ADD_FLOORPLAN = "ADD FLOORPLAN";
    private final String CHOOSE_FROM_LIBRARY = "CHOOSE FROM LIBRARY";
    private final String PHOTO = "PHOTO";
    private final String CONFIRM_SQUARE = "CHECK SQUARE OUTLINE";
    private final String CONFIRM_FLOORPLAN_TITLE = "CONFIRM FLOORPLAN";
    private final String CONFIRM_FLOORPLAN_NEXT = "NEXT";
    private final String GUIDE_LAYER_TAB = "GUIDE TAB";
    private final String ROTATE_SCALE_TITLE = "ROTATE & SCALE";
    private final String ROTATE_SCALE_CONFIRM = "CONFIRM ROTATE & SCALE";
    private final String RESULT_VIEW_TITLE = "RESULT";
    private final String RESULT_VIEW_CONFIRM = "CONFIRM RESULT";
    private final String EDIT_FLOORS_TITLE = "EDIT FLOORS";
    private final String EDIT_TOUR_BACK_BTN = "EDIT TOUR";
    private final String CHOOSE_TAKE_PICURE = "TAKE PHOTO";
    private final String PHOTO_CAPTURE = "PHOTO CAPTURE";
    private final String USE_PHOTO = "USE PHOTO";
    private final String SEARCHBAR = "SEARCHBAR";
    private final String LOC_ADD_FLOORPLAN = "//XCUIElementTypeButton[@name='Add Floorplan']";
    private final String LOC_CHOOSE_FROM_LIBRARY = "//XCUIElementTypeButton[@name='Choose from Library']";
    private final String LOC_PHOTO = "Photo, August 12, 1:53 PM";
    private final String LOC_CONFIRM_SQUARE = "check square outline";
    private final String LOC_CONFIRM_FLOORPLAN_TITLE = "//XCUIElementTypeStaticText[@name='CONFIRM FLOORPLAN']";
    private final String LOC_CONFIRM_FLOORPLAN_NEXT = "//XCUIElementTypeButton[@name='Next']";
    private final String LOC_GUIDE_LAYER_TAB = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]";
    private final String LOC_ROTATE_SCALE_TITLE = "ROTATE & SCALE";
    private final String LOC_ROTATE_SCALE_CONFIRM = "//XCUIElementTypeButton[@name='Confirm']";
    private final String LOC_RESULT_VIEW_TITLE = "RESULT";
    private final String LOC_RESULT_VIEW_CONFIRM = "//XCUIElementTypeButton[@name='Confirm']";
    private final String LOC_EDIT_FLOORS_TITLE = "//XCUIElementTypeStaticText[@name='EDIT FLOORS']";
    private final String LOC_EDIT_TOUR_BACK_BTN = "EDIT TOUR";
    private final String LOC_CHOOSE_TAKE_PICURE = "Take Photo";
    private final String LOC_PHOTO_CAPTURE = "PhotoCapture";
    private final String LOC_USE_PHOTO = "//XCUIElementTypeButton[@name='Use Photo']";
    private final String LOC_SEARCHBAR = "//XCUIElementTypeSearchField[@name='Photos, People, Places…']";

    public IOSElement getViewElement(WebDriver driver, String elementText) {

        IOSElement element = null;
        switch (elementText) {
            case ADD_FLOORPLAN:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_ADD_FLOORPLAN);
                break;
            case CHOOSE_FROM_LIBRARY:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_CHOOSE_FROM_LIBRARY);
                break;
            case PHOTO:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_PHOTO);
                break;
            case CONFIRM_SQUARE:
                element = findElementByAccessibilityIDWithWait(driver, SECOND30, LOC_CONFIRM_SQUARE);
                break;
            case CONFIRM_FLOORPLAN_TITLE:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_CONFIRM_FLOORPLAN_TITLE);
                break;
            case CONFIRM_FLOORPLAN_NEXT:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_CONFIRM_FLOORPLAN_NEXT);
                break;
            case GUIDE_LAYER_TAB:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_GUIDE_LAYER_TAB);
                break;
            case ROTATE_SCALE_TITLE:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_ROTATE_SCALE_TITLE);
                break;
            case ROTATE_SCALE_CONFIRM:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_ROTATE_SCALE_CONFIRM);
                break;
            case RESULT_VIEW_TITLE:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_RESULT_VIEW_TITLE);
                break;
            case RESULT_VIEW_CONFIRM:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_RESULT_VIEW_CONFIRM);
                break;
            case EDIT_FLOORS_TITLE:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_EDIT_FLOORS_TITLE);
                break;
            case EDIT_TOUR_BACK_BTN:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_EDIT_TOUR_BACK_BTN);
                break;
            case CHOOSE_TAKE_PICURE:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_CHOOSE_TAKE_PICURE);
                break;
            case PHOTO_CAPTURE:
                element = findElementByAccessibilityIDWithWait(driver, SECOND10, LOC_PHOTO_CAPTURE);
                break;
            case USE_PHOTO:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_USE_PHOTO);
                break;
            case SEARCHBAR:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_SEARCHBAR);
                break;

        }
        return element;
    }
}
