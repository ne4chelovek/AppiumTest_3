package com.example.appiumtest_3;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;



import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroScreenTest {

    private AndroidDriver driver;
    // private PORT = 4723;
    // private HOST = "127.0.0.1";
    private IntroScreen introScreen;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Lolma\\Downloads\\Авито_ квартиры, авто, работа_162.5_Apkpure.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Redmi");
        desiredCapabilities.setCapability("appium:automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        // private URL getUrl(String host, String port) {
        //     try {
        //         return new URL(host+":"+port);
        //     } catch (MalformedURLException e) {
        //         e.printStackTrace();
        //     }
        //     return null;
        // }
//
        // driver = new AndroidDriver(this.remoteUrl(HOST, PORT), desiredCapabilities);

        URL remoteUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        introScreen = new IntroScreen(driver);
    }

    @Test
    public void sampleTest() {
        assertTrue(introScreen.checkSearchField(),"Поисковое полн не активно");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}