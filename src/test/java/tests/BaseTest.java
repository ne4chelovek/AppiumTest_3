package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Lolma\\Downloads\\ozon-16-28-1.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);


        //desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        //desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

}

