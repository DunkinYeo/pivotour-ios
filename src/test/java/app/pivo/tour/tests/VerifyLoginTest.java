package app.pivo.tour.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import app.pivo.tour.views.VerifyLoginView;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//import app.pivo.tour.views.MyToursView;

import static org.junit.Assert.*;

//precondition: User should be logged out
public class VerifyLoginTest extends BaseTest {
        @Test (groups = {"VerifyLoginTest"})
        public void verifyLogin() {
            VerifyLoginView login = new VerifyLoginView();
            // Click on Google icon
            IOSElement googleIcon = login.getViewElement(driver, "GOOGLE LOGIN");
            googleIcon.click();
            IOSElement snsLogin = login.getViewElement(driver, "SNS LOGIN");
            snsLogin.click();
    
            IOSElement selectAccount = login.getViewElement(driver, "TEST ACCOUNT");
            selectAccount.click();

            IOSElement settings = login.getViewElement(driver, "SETTINGS");
            settings.click();
            //check if the account is valid

            
            IOSElement accId = (IOSElement) new WebDriverWait(driver, 30).until(ExpectedConditions
            .visibilityOfElementLocated(MobileBy.AccessibilityId("TesterLive 3i")));
            assertTrue("It is live server",accId != null);

        }
}   