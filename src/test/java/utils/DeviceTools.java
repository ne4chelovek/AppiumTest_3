package utils;

import allure.AllureLogger;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.slf4j.LoggerFactory;
import static tests.BaseTest.getDriver;

public class DeviceTools {

    private static final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DeviceTools.class));

    public static void setWiFiToOff(){
        getDriver().setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        LOG.info("turning off wi-fi");
    }

    public static void setWiFiToOn(){
        getDriver().setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
        LOG.info("turning on wi-fi");
    }
}
