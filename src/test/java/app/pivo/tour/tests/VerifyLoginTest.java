package app.pivo.tour.tests;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;
import app.pivo.tour.views.VerifyLogin.VerifyLoginView;

//precondition: User should be logged out
public class VerifyLoginTest extends BaseTest {
    @Test (groups = {"VerifyLoginTest"})
    public void verifyLogin() {
        boolean isLiveServer = false;
        VerifyLoginView login = new VerifyLoginView();
        // Click on Google icon
        IOSElement googleIcon = login.getViewElement(driver, "GOOGLE LOGIN");
        googleIcon.click();
        //Confirm sns login
        IOSElement snsLogin = login.getViewElement(driver, "SNS LOGIN");
        snsLogin.click();
        //you can change account from here
        IOSElement selectAccount = login.getViewElement(driver, "TEST ACCOUNT");
        selectAccount.click();
        //Select settings tab to check the server
        IOSElement settings = login.getViewElement(driver, "SETTINGS");
        settings.click();

        //Try to find live id first
        try{
            if (login.getViewElement(driver, "LIVE ID").isDisplayed()) {
                System.out.println("This server is live");
                isLiveServer = true;
            }
        
        }
        //Live account is not found
        catch (Exception e) {
            System.err.println("Test Live Account not found" + e.getMessage());
        }
        finally{
            //if it is not live server, check if it is a dev server
            if (isLiveServer == false){
                try{
                    if (login.getViewElement(driver, "DEV ID").isDisplayed()) {
                        System.err.println("This server is dev");                   
                    }
                }
                //it is not either live or dev server, or the name is changed
                catch(Exception e){
                    System.err.println("Account is both not live or dev account, please check the account name" + e.getMessage());
                }
            }
        }
    }
}
