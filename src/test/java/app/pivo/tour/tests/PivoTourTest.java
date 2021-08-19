package app.pivo.tour.tests;

import app.pivo.tour.views.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import android.content.pm.ApplicationInfo;

import static org.junit.Assert.*;

//import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import app.pivo.tour.views.CaptureView;
import app.pivo.tour.views.ConnectPodView;
import app.pivo.tour.views.EditFloorsView;
import app.pivo.tour.views.EditTourView;
import app.pivo.tour.views.ListingDetailsView;
import app.pivo.tour.views.MyToursView;
import app.pivo.tour.views.ReviewCapturesView;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PivoTourTest extends BaseTest {
    private IOSDriver<WebElement> driver;
    static Random rnd = new Random();
    static final HashMap<String, String> scrollUp = new HashMap<String, String>();
    static String currTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    ///Configs needs to be done manually/////
    static DeviceConfig.Device device = DeviceConfig.Device.iPhone12Pro;
    static String appVersion = "1.3.3(2)";
    public static String podName = "QA-V2-S1";
    /////////////////////////////////////////
    static String iOSVersion = device.getInfo().getIOSVersion();
    static String deviceName = device.getInfo().getDeviceName();
    static String udid = device.getInfo().getUdid();
    static boolean hasLiDAR = device.getInfo().getHasLiDAR();
    static String tourType = "2D";

    @BeforeTest
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Real device
        capabilities.setCapability("xcodeOrgId", "4JQH63J424");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", iOSVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("bundleId", "app.pivo.ios.tour");
        capabilities.setCapability("udid", udid);

        try {
            driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

     //@Test
    public void verifyLogin() {
        try {
            // Click on Google icon
            IOSElement btnGoogleLogin = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ic button login google")));
            btnGoogleLogin.click();
            // Alert to continue google.com page
            IOSElement alertSNSLogin = (IOSElement) new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Continue")));
            alertSNSLogin.click();
            // Verify if google.com page loaded (check text: "accounts.google.com")
            IOSElement urlGoogle = (IOSElement) new WebDriverWait(driver, 30).until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeOther[@name='URL']")));
            assertTrue("SNS login with Google", urlGoogle.getText().contains("accounts.google.com"));
            IOSElement testAccount = (IOSElement) new WebDriverWait(driver, 10).until(ExpectedConditions
            .visibilityOfElementLocated(MobileBy.AccessibilityId("Test 3i test@3i.ai")));
            testAccount.click();
       
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
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

    @Test
    public void verifyCreateTour() {

        scrollUp.put("direction", "up");
        /////////////////////////////////
        // Check elements of My Tours page
        /////////////////////////////////
        // Check page title ("My Tours")
        MyToursView mytour = new MyToursView();

        IOSElement txtPageTitle = mytour.getViewTitle(driver);
        assertTrue("Page Title not found", txtPageTitle != null);

        // Check each tabs exist
        // Public
        IOSElement txtTabPublic = mytour.getTabElement(driver, 1);
        assertTrue("Public tab not found", txtTabPublic != null);
        // Private
        IOSElement txtTabPrivate = mytour.getTabElement(driver, 2);
        assertTrue("Private tab not found", txtTabPrivate != null);
        // Draft
        IOSElement btnTabDraft = mytour.getTabElement(driver, 3);
        assertTrue("Draft tab not found", btnTabDraft != null);

        // Go to Create Tour
        IOSElement btnCreateTour = mytour.getBottomMenuElement(driver, 2);
        btnCreateTour.click();

        /////////////////////////////////
        // Connect to Pod View
        /////////////////////////////////
        ConnectPodView conPod = new ConnectPodView();
        IOSElement btnConnectPod = conPod.getViewElement(driver, "CONNECT");
        btnConnectPod.click();

        // Choose Pod ONLY IF there are more than one Pod found

        IOSElement txtAvailablePod = null;

        try {
            if (conPod.getViewElement(driver, "Pivo").isDisplayed()) {
                txtAvailablePod = conPod.getViewElement(driver, "Pivo");
                txtAvailablePod.click();
            }
        } catch (Exception e) {
            System.out.println("Only One Pod Exception :: " + e.getMessage ()); 
            //if there are only one pod, just proceed
        } finally {
            /////////////////////////////////
            // Capturing View
            /////////////////////////////////
            // Click on  Start button
            CaptureView vCapture = new CaptureView();
            // Check if the device is iPhone 12 Pro or above
            if (hasLiDAR) {
                IOSElement btn3D = vCapture.getViewElement(driver, "3D");
                btn3D.click();
                IOSElement btnStart = vCapture.getViewElement(driver, "START");
                btnStart.click();
                IOSElement btnTilt = vCapture.getViewElement(driver, "TILT");
                btnTilt.click();
            }

            else {
                IOSElement btnStart = vCapture.getViewElement(driver, "START");
                btnStart.click();
            }
            // Verify the view elements
            IOSElement btnFloor = vCapture.getViewElement(driver, "FLOOR");
            assertTrue("Floor button not found", btnFloor != null);

            IOSElement btnFinish = vCapture.getViewElement(driver, "FINISH");
            assertTrue("Finish button not found", btnFinish != null);

            // Recording
            IOSElement btnRecord = vCapture.getViewElement(driver, "RECORD");
            btnRecord.click();

            // Check the RECORD button after Recording to confirm if capturing was done
            // successfully
            IOSElement btnRecordAfterRecord = vCapture.getViewElement(driver, "RECORD");
            assertTrue("After Record", btnRecordAfterRecord != null);

            // Start new floor
            btnFloor.click();

            IOSElement btnStartNewFloor = vCapture.getViewElement(driver, "START NEW F");
            // assertTrue("Floor button not found in 2nd floor", btnFloor != null);
            // assertTrue("Finish button not found in 2nd floor", btnFinish != null);
            btnStartNewFloor.click();

            if (hasLiDAR) {
                IOSElement btn2D = vCapture.getViewElement(driver, "2D");
                btn2D.click();
            }
            // record new floor
            IOSElement btnFinish2 = vCapture.getViewElement(driver, "FINISH");
            IOSElement btnRecordNewFloor = vCapture.getViewElement(driver, "RECORD");
            btnRecordNewFloor.click();
            IOSElement btnRecordAfterRecord2 = vCapture.getViewElement(driver, "RECORD");
            assertTrue("Recording", btnRecordAfterRecord2 != null);

            // Click on Finish button
            btnFinish2.click();
            // Click on Finish on Alert popup window
            IOSElement btnAlertFinish = vCapture.getViewAlertElement(driver, "FINISH");
            btnAlertFinish.click();

            //////////////////////
            // REVIEW CAPTURES view
            //////////////////////
            ReviewCapturesView vReviewCaptures = new ReviewCapturesView();
            IOSElement txtReviewCapturesTitle = vReviewCaptures.getViewTitle(driver);
            assertTrue("REVIEW CAPTURES View", txtReviewCapturesTitle != null);

            // Next
            IOSElement btnNext = vReviewCaptures.getViewElement(driver, "NEXT");
            btnNext.click();

            ////////////////
            // EDIT TOUR View
            ////////////////
            EditTourView vEditTour = new EditTourView();
            IOSElement txtEditTourTitle = vEditTour.getViewTitle(driver);
            assertTrue("EDIT TOUR View", txtEditTourTitle != null);

            // Edit Thumbnail
            IOSElement btnEditThumbnail = vEditTour.getViewElement(driver, "EDIT THUMBNAIL");
            btnEditThumbnail.click();

            // Choose from Scenes
            IOSElement btnChooseScene = vEditTour.getViewElement(driver, "CHOOSE FROM SCENES");
            btnChooseScene.click();
            IOSElement btnFirstScene = vEditTour.getViewElement(driver, "POINT 1");
            btnFirstScene.click();
            IOSElement btnTourEditor = vEditTour.getViewElement(driver, "TOUR EDITOR");
            btnTourEditor.click();

            //////////////////
            // Edit Floors
            //////////////////
            EditFloorsView vEditFloors = new EditFloorsView();
            // Add Floorplan
            IOSElement btnAddFloorplan = vEditFloors.getViewElement(driver, "ADD FLOORPLAN");
            btnAddFloorplan.click();

            // Choose from library
            IOSElement btnChooseLibrary = vEditFloors.getViewElement(driver, "CHOOSE FROM LIBRARY");
            btnChooseLibrary.click();

            // add search so that it can always find the picture
            IOSElement searchBar = vEditFloors.getViewElement(driver, "SEARCHBAR");
            searchBar.click();
            searchBar.sendKeys("August");
            // Choose a floorplan
            IOSElement btnChooseFloorplan = vEditFloors.getViewElement(driver, "PHOTO");
            btnChooseFloorplan.click();
            // Confirm
            IOSElement btnConfirmFloorplan = vEditFloors.getViewElement(driver, "CHECK SQUARE OUTLINE");
            btnConfirmFloorplan.click();

            // CONFIRM FLOORPLAN View
            IOSElement txtConfirmFloorplanTitle = vEditFloors.getViewElement(driver, "CONFIRM FLOORPLAN");
            assertTrue("CONFIRM FLOORPLAN page", txtConfirmFloorplanTitle != null);

            // Next
            IOSElement btnNextConfirmFloorplan = vEditFloors.getViewElement(driver, "NEXT");
            btnNextConfirmFloorplan.click();

            // ROTATE & SCALE
            /////////////////////
            // Guide
            IOSElement GuideLayer = vEditFloors.getViewElement(driver, "GUIDE TAB");
            GuideLayer.click();

            // ROCATE & SCALE view
            IOSElement txtRocateScaleTitle = vEditFloors.getViewElement(driver, "ROTATE & SCALE");
            assertTrue("ROTATE & SCALE View", txtRocateScaleTitle != null);

            // Confirm Rocate & Scale
            ////////////////////////
            IOSElement btnConfirmRocateScale = vEditFloors.getViewElement(driver, "CONFIRM ROTATE & SCALE");
            btnConfirmRocateScale.click();

            // RESULT view
            IOSElement txtResultTitle = vEditFloors.getViewElement(driver, "RESULT");
            assertTrue("RESULT View", txtResultTitle != null);
            // Confirm result
            IOSElement btnConfirmResult = vEditFloors.getViewElement(driver, "CONFIRM RESULT");
            btnConfirmResult.click();

            // EDIT FLOORS View again
            ////////////////////////
            IOSElement txtEditFloorsTitle = vEditFloors.getViewElement(driver, "EDIT FLOORS");
            assertTrue("EDIT FLOORS View", txtEditFloorsTitle != null);
            /////////////////////
            // capture a floorplan for 2nd floor
            /////////////////////
            try {
                driver.executeScript("mobile:swipe", scrollUp);
                Thread.sleep(200); // always allow swipe action to complete
            } catch (Exception e) {
                return;
            }
            btnAddFloorplan.click();
            IOSElement btnTakePhoto = vEditFloors.getViewElement(driver, "TAKE PHOTO");
            btnTakePhoto.click();
            IOSElement btnCaptureFloorplan = vEditFloors.getViewElement(driver, "PHOTO CAPTURE");// set floor plan
            btnCaptureFloorplan.click();
            try {
                IOSElement btnUsePhoto = vEditFloors.getViewElement(driver, "USE PHOTO");
                btnUsePhoto.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // wait time for pictures to be processed
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            IOSElement btnConfirmMoreFloorplan = vEditFloors.getViewElement(driver, "CHECK SQUARE OUTLINE");
            btnConfirmMoreFloorplan.click();
            assertTrue("CONFIRM FLOORPLAN page", txtConfirmFloorplanTitle != null);
            IOSElement btnNextConfirmMoreFloorplan = vEditFloors.getViewElement(driver, "NEXT");
            btnNextConfirmMoreFloorplan.click();

            IOSElement GuideLayer2 = vEditFloors.getViewElement(driver, "GUIDE TAB");
            GuideLayer2.click();
            IOSElement btnConfirmRocateScale2 = vEditFloors.getViewElement(driver, "CONFIRM ROTATE & SCALE");
            btnConfirmRocateScale2.click();

            assertTrue("RESULT page", txtResultTitle != null);

            IOSElement btnConfirmResult2 = vEditFloors.getViewElement(driver, "CONFIRM RESULT");
            btnConfirmResult2.click();

            assertTrue("EDIT FLOORS page", txtEditFloorsTitle != null);

            // Go back to EDIT TOUR view ( <- )
            IOSElement btnBack = vEditFloors.getViewElement(driver, "EDIT TOUR");
            btnBack.click();

            ///////////////////
            // EDIT TOUR View
            //////////////////
            EditTourView vEditTourUpdate = new EditTourView();
            // Input Tour Title
            IOSElement txtTourTitle = vEditTourUpdate.getViewElement(driver, "TOUR TITLE FIELD");
            txtTourTitle.clear();
            txtTourTitle.sendKeys("iOS " + currTime);
            IOSElement btnKeyboardReturn = vEditTourUpdate.getViewElement(driver, "KEYBOARD RETURN");
            btnKeyboardReturn.click();

            IOSElement txtTourDescriptions = vEditTourUpdate.getViewElement(driver, "TOUR DESCRIPTION");

            if (hasLiDAR) {
                tourType = "3D";
            }
            txtTourDescriptions.sendKeys(
                    "Automation " + tourType + " test" 
                    + "\n" + currTime 
                    + "\n IOS Version: " + iOSVersion 
                    + "\n Device Name: " + deviceName
                    + "\n App version: " + appVersion);
            try {
                driver.executeScript("mobile:swipe", scrollUp);
                Thread.sleep(200); // always allow swipe action to complete
            } catch (Exception e) {
                return;
            }

            IOSElement listingDetails = vEditTourUpdate.getViewElement(driver, "LISTING DETAILS");
            listingDetails.click();

            ListingDetailsView vListingDetails = new ListingDetailsView();

            IOSElement price = vListingDetails.getViewElement(driver, "PRICE");
            price.sendKeys(Integer.toString((rnd.nextInt((100) * 100) + 1)));

            IOSElement propertySize = vListingDetails.getViewElement(driver, "PROPERTY SIZE");
            propertySize.sendKeys(Integer.toString((rnd.nextInt(100) + 1)));

            IOSElement lotSize = vListingDetails.getViewElement(driver, "LOT SIZE");
            lotSize.sendKeys(Integer.toString((rnd.nextInt(100) + 1)));

            IOSElement bedrooms = vListingDetails.getViewElement(driver, "BEDROOMS");
            bedrooms.sendKeys(Integer.toString((rnd.nextInt(10) + 1)));

            driver.executeScript("mobile:swipe", scrollUp);

            IOSElement bathrooms = vListingDetails.getViewElement(driver, "BATHROOMS");
            bathrooms.sendKeys(Integer.toString((rnd.nextInt(10) + 1)));

            IOSElement addMore = vListingDetails.getViewElement(driver, "ADD MORE");
            addMore.sendKeys("testRoom");

            IOSElement add = vListingDetails.getViewElement(driver, "ADD");
            add.click();

            btnBack.click();

            // Input Address
            IOSElement btnSearch = vEditTourUpdate.getViewElement(driver, "SEARCH BUTTON");
            btnSearch.click();
            IOSElement txtAddress = vEditTourUpdate.getViewElement(driver, "ADDRESS");
            txtAddress.sendKeys("272 Gonghang-ro, Jung-gu, Incheon");
            IOSElement selectAddress = vEditTourUpdate.getViewElement(driver, "SELECT ADDRESS");
            selectAddress.click();

            // Save
            IOSElement btnSave = vEditTourUpdate.getViewElement(driver, "SAVE");
            btnSave.click();

            ////////////////////
            // Main View My Tours
            ////////////////////
            MyToursView vMyTourForUpload = new MyToursView();
            // Go to Draft tab
            IOSElement btnTabDraftNew = vMyTourForUpload.getTabElement(driver, 3);
            btnTabDraftNew.click();
            // Tab the created tour
            IOSElement uploadedTour = vMyTourForUpload.getViewElement(driver, "Title", currTime);
            uploadedTour.click();

            //////////////////
            // Single Tour View
            //////////////////
            EditTourView vTourUpload = new EditTourView();
            // Swipe Up

            try {
                driver.executeScript("mobile:swipe", scrollUp);
                Thread.sleep(200); // always allow swipe action to complete
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Upload button
            IOSElement btnUpload = vTourUpload.getViewElement(driver, "UPLOAD");
            btnUpload.click();
            // Alert OK
            IOSElement btnUploadOK = vTourUpload.getViewElement(driver, "ALERT OK");
            btnUploadOK.click();

            // Landing Page (MY TOURS)
            MyToursView vTourAfterUpload = new MyToursView();
            // Check if the tour is displayed on Private tab
            IOSElement txtUploadedTour = vTourAfterUpload.getViewElement(driver, "Title", currTime);
            assertTrue("Uploaded Tour", txtUploadedTour != null);

            // } catch (Exception e) {
            /*
             * e.printStackTrace(); fail("Test is incomplete!"); }
             */
        }
    }

    // @Test
    public void testGuide() {

        try {
            // Find element
            List<WebElement> GuideElement = driver.findElementsByAccessibilityId("Guide");
            Assert.assertEquals(GuideElement.size(), 1);
            // Click
            GuideElement.get(0).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
