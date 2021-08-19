
package app.pivo.tour.views;

//import javax.persistence.criteria.CriteriaBuilder.Case;

import app.pivo.tour.library.TestLibrary;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ListingDetailsView extends TestLibrary {

    // private final int SECOND5 = 5;
    private final int SECOND10 = 10;
    // private final int SECOND60 = 60;

    private final String PRICE = "PRICE";
    private final String PPROPERTY_SIZE = "PROPERTY SIZE";
    private final String LOT_SIZE = "LOT SIZE";
    private final String BEDROOMS = "BEDROOMS";
    private final String BATHROOMS = "BATHROOMS";
    private final String ADD_MORE = "ADD MORE";
    private final String ADD = "ADD";

    private final String path1 = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/"
            + "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"
            + "/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[";
    private final String path2 = "]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
    private final String LOC_PRICE = (path1 + "1" + path2);
    private final String LOC_PROPERTY_SIZE = (path1 + "2" + path2);
    private final String LOC_LOT_SIZE = (path1 + "3" + path2);
    private final String LOC_BEDROOMS = (path1 + "4" + path2);
    private final String LOC_BATHROOMS = (path1 + "4" + path2);
    private final String LOC_ADD_MORE = (path1 + "5" + path2);
    private final String LOC_ADD = ("//XCUIElementTypeButton[@name='Add']");

    public IOSElement getViewElement(IOSDriver<WebElement> driver, String elementText) {

        IOSElement element = null;

        switch (elementText) {
            case PRICE:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_PRICE);
                break;
            case PPROPERTY_SIZE:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_PROPERTY_SIZE);
                break;
            case LOT_SIZE:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_LOT_SIZE);
                break;
            case BEDROOMS:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_BEDROOMS);
                break;
            case BATHROOMS:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_BATHROOMS);
                break;
            case ADD_MORE:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_ADD_MORE);
                break;
            case ADD:
                element = findElementByXpathWithWait(driver, SECOND10, LOC_ADD);
                break;
        }
        return element;
    }

}
