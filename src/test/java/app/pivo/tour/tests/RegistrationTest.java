package app.pivo.tour.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test (groups = {"RegistrationTest"})
    public void verifyRegistration() {

        String userInputForEmail = "1";

        IOSElement createAccount = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeStaticText[@name='Create account']")));
        createAccount.click();
        //create account

        String xcodeFields = "//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[";
        String xcodeFieldsSecondHalf = "]/XCUIElementTypeTextField";
        
        IOSElement firstName = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath(xcodeFields + 1 + xcodeFieldsSecondHalf)));
        firstName.sendKeys("RegistrationTest");
        
        IOSElement lastName = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath(xcodeFields + 2 + xcodeFieldsSecondHalf)));
        lastName.sendKeys("Automation");
        
        
        IOSElement email = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath(xcodeFields + 3 + xcodeFieldsSecondHalf)));
        email.sendKeys("test+" + userInputForEmail + "@gmail.com");

        IOSElement pswd = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath(xcodeFields + "4]/XCUIElementTypeSecureTextField")));
        pswd.sendKeys("qwe123");

        IOSElement confirmPswd = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath(xcodeFields + "5]/XCUIElementTypeSecureTextField")));
        confirmPswd.sendKeys("qwe123");

        IOSElement checkBox = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeApplication[@name='Pivo Tour']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther")));
        checkBox.click();

        IOSElement btnKeyboardReturn = (IOSElement) new WebDriverWait(driver, 5).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.AccessibilityId("Return")));
            btnKeyboardReturn.click();

        IOSElement register = (IOSElement) new WebDriverWait(driver, 30).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeButton[@name='Register']")));
        register.click();
        //make it wait after register button is clicked
        IOSElement confirmCreated = (IOSElement) new WebDriverWait(driver, 30).until(ExpectedConditions
        .visibilityOfElementLocated(MobileBy.AccessibilityId("Ok")));
        confirmCreated.click();
      
    }
}
