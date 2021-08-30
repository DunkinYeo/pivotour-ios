package app.pivo.tour.tests;

import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;

import app.pivo.tour.views.Registration.RegistrationView;

public class RegistrationTest extends BaseTest {
    @Test (groups = {"RegistrationTest"})
    public void verifyRegistration() {

        RegistrationView vRegView = new RegistrationView();
        //this string will be added after email address and used to generate an unique id
        String userInputForEmail = "1";
        //this is the email address to create a pivo account. Default is rpivo164@gmail.com
        String emailAdr = "rpivo164+" + userInputForEmail + "@gmail.com";
        //this is a password that will be used to generate a pivo account
        String password = "qwe123";

        
        IOSElement createAccount = vRegView.getViewElement(driver, "CREATE ACCOUNT");
        createAccount.click();
        //create account
        
        IOSElement firstName = vRegView.getViewElement(driver, "FIRST NAME");
        firstName.sendKeys("RegistrationTest");
        
        IOSElement lastName = vRegView.getViewElement(driver, "LAST NAME");
        lastName.sendKeys("Automation");
        
        IOSElement email = vRegView.getViewElement(driver, "EMAIL");
        email.sendKeys(emailAdr);

        IOSElement pswd = vRegView.getViewElement(driver, "PASSWORD");
        pswd.sendKeys(password);
        
        IOSElement confirmPswd = vRegView.getViewElement(driver, "CONFIRM PASSWORD");
        confirmPswd.sendKeys(password);

        IOSElement checkBox = vRegView.getViewElement(driver, "CHECK BOX");
        checkBox.click();

        IOSElement btnKeyboardReturn = vRegView.getViewElement(driver, "RETURN BUTTON");
        btnKeyboardReturn.click();

        IOSElement register = vRegView.getViewElement(driver, "REGISTER");
        register.click();
        //make it wait after register button is clicked
        IOSElement confirmCreated = vRegView.getViewElement(driver, "CONFIRM CREATED");
        confirmCreated.click();
      
    }
}
