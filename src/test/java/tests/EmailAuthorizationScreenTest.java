package tests;

import extensions.MyExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.EmailAuthorizationScreen;
import utils.DeviceTools;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static wait.MyWait.myWait;

@ExtendWith(MyExtension.class)
public class EmailAuthorizationScreenTest extends BaseTest {

    private EmailAuthorizationScreen EmailAuthorizationScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
        EmailAuthorizationScreen = new EmailAuthorizationScreen(getDriver());
    }

    @Test
    @DisplayName("Проверка ввода деактивированного email")
    public void inputDeactiveEmail() {
        final String email = "User@user.ru";
        EmailAuthorizationScreen.touchOutside();
        EmailAuthorizationScreen.openValidation();
        EmailAuthorizationScreen.inputTextEmail(email);
        EmailAuthorizationScreen.submitClick();
        assertTrue(EmailAuthorizationScreen.warningMessage(), "Предупреждение не появилось");
    }
    @Test
    @DisplayName("Проверка ввода пустого значения")
    public void inputEmptyValue() {
        EmailAuthorizationScreen.touchOutside();
        EmailAuthorizationScreen.openValidation();
        EmailAuthorizationScreen.submitClick();
        assertTrue(EmailAuthorizationScreen.errorMessage(), "Ошибка не появилась");
    }
    @Test
    @DisplayName("Проверка перехода без подключения к сети")
    public void inputEmptyValueWitchDisableWifi() {
        EmailAuthorizationScreen.touchOutside();
        EmailAuthorizationScreen.openValidation();
        DeviceTools.setWiFiToOff();
        EmailAuthorizationScreen.backMainScreenClick();
        assertTrue(EmailAuthorizationScreen.checkScreenStateView(), "Экран с предупреждением об отключенном WiFi не появился");
        DeviceTools.setWiFiToOn();
        myWait(10).pause();
        EmailAuthorizationScreen.refreshButtonClick();
        assertTrue(EmailAuthorizationScreen.checkScreenAfterRefresh(),"Экран авторизации не появился");
    }
}