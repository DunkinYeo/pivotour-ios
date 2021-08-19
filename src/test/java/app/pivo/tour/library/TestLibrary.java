package app.pivo.tour.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;

public class TestLibrary {
    
    public IOSElement findElementByXpathWithWait(WebDriver driver, int second, String xpath) {
        IOSElement element = (IOSElement) new WebDriverWait(driver, second)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(xpath)));
        return element;
    }

    public IOSElement findElementByAccessibilityIDWithWait(WebDriver driver, int second, String accessbilityId) {
        IOSElement element = (IOSElement) new WebDriverWait(driver, second)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(accessbilityId)));
        return element;
    }
    
}
