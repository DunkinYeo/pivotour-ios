package app.pivo.tour.tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import app.pivo.tour.Configuration.DeviceConfig;

import java.io.IOException;
import java.net.URL;

public abstract class BaseTest {

    //these needs to be manually configured as a pre-condition
    static DeviceConfig.Device device = DeviceConfig.Device.iPhone12Pro;
    static String appVersion = "1.3.3(2)";
    public static String podName = "QA-V2-S1";
    /////////////////////////////////////////
    static String iOSVersion = device.getInfo().getIOSVersion();
    static String deviceName = device.getInfo().getDeviceName();
    static String udid = device.getInfo().getUdid();
    static boolean hasLiDAR = device.getInfo().getHasLiDAR();
    static String tourType = "2D";

    private static AppiumDriverLocalService service;
        public IOSDriver<WebElement> driver;

    @BeforeSuite (groups = {"abstract"})
    public void globalSetup() throws IOException {
        System.out.println("BeforeSuite");

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @BeforeTest (groups = {"abstract"})
    public void setUp() throws Exception {
        System.out.println("BeforeTest...");
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
    
    @AfterTest (groups = { "abstract" })
    public void tearDown() {
        System.out.println("AfterTest...");

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite (groups = { "abstract" })
    public void globalTearDown() {
        System.out.println("AfterSuite");

        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl() {
        return service.getUrl();
    }

}
