package tests;

import extensions.MyExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import screens.NumberAuthorizationScreen;
import utils.DeviceTools;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static wait.MyWait.myWait;

@ExtendWith(MyExtension.class)
public class NumberAuthorizationScreenTest extends BaseTest{

    private  NumberAuthorizationScreen NumberAuthorizationScreen;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        NumberAuthorizationScreen = new NumberAuthorizationScreen(getDriver());
    }
    @Test
    @DisplayName("Проверка ввода невалидного номера")
    public void inputInvalidNumber() {
        final String number = "0000000000";
        NumberAuthorizationScreen.touchOutside();
        NumberAuthorizationScreen.openValidation();
        myWait(3).pause();
        NumberAuthorizationScreen.inputNumber(number);
        NumberAuthorizationScreen.submitButtonClick();
        assertTrue(NumberAuthorizationScreen.warningMessageChek(), "Предупреждение не появилось");
    }
    @Test
    @DisplayName("Проверка ввода пустого значения")
    public void inputEmptyNumber() {
        NumberAuthorizationScreen.touchOutside();
        NumberAuthorizationScreen.openValidation();
        NumberAuthorizationScreen.submitButtonClick();
        assertTrue(NumberAuthorizationScreen.warningMessageChek(), "Предупреждение не появилось");
    }
    @Test
    @DisplayName("Проверка перехода без подключения к сети")
    public void inputEmptyNumberWithDisableWiFi() {
        NumberAuthorizationScreen.touchOutside();
        NumberAuthorizationScreen.openValidation();
        DeviceTools.setWiFiToOff();
        myWait(5).pause();
        NumberAuthorizationScreen.inputWithEmail();
        assertTrue(NumberAuthorizationScreen.checkScreenStateView(), "Экран с предупреждением об отключенном WiFi не появился");
        DeviceTools.setWiFiToOn();
        myWait(10).pause();
        NumberAuthorizationScreen.refreshButtonClick();
        assertTrue(NumberAuthorizationScreen.checkScreenAfterRefresh(),"Экран авторизации не появился");
    }
}
