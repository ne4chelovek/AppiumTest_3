package screens;

import allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static wait.MyWait.myWait;

public class NumberAuthorizationScreen {
    private static final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(NumberAuthorizationScreen.class));
    @AndroidFindBy(id = "touch_outside")
    private WebElement closeBanner;
    @AndroidFindBy(id = "textBlockWidgetWrapper")
    private WebElement adbBanner;
    @AndroidFindBy(id = "inputEditText")
    private WebElement inputNumberField;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"ru.ozon.app.android:id/submitButton\"]")
    private WebElement submitButton;
    @AndroidFindBy(id ="topRightContainer")
    private WebElement enterOzon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"credentialsTextField.label\"]")
    private WebElement warningNumberMessage;
    @AndroidFindBy(id = "hintButtonsLinearLayout")
    private WebElement enterByEmail;
    @AndroidFindBy(id = "errorView")
    private WebElement noWifiConnection;
    @AndroidFindBy(id = "screenStateActionBtn")
    private WebElement refreshButton;
    @AndroidFindBy(id = "logoImageView")
    private WebElement logoOzonID;

    public void touchOutside(){
        myWait(10).visible(adbBanner);
        closeBanner.click();
    }
    public void openValidation() {
        LOG.info("Нажатие на кнопку 'Войти' на основном экране ");
        enterOzon.click();
    }
    public void inputNumber(String number){
        LOG.info("Ввод номера");
        inputNumberField.click();
        myWait(5).visible(inputNumberField);
        inputNumberField.sendKeys(number);
    }
    public void submitButtonClick(){
        submitButton.click();
    }
    public boolean warningMessageChek(){
        LOG.infoWithScreenshot("Проверка поевления ошибки, после ввода невалидного номера");
        return warningNumberMessage.isDisplayed();
    }
    public void inputWithEmail(){
        LOG.info("Нажатие на кнопку 'Войти через почту'");
        enterByEmail.click();
    }
    public boolean checkScreenStateView() {
        LOG.infoWithScreenshot("Проверка состояния экрана без подключения к WiFi");
        return noWifiConnection.isDisplayed();
    }
    public void refreshButtonClick(){
        LOG.info("Клик по кнопке 'Обновить'");
        refreshButton.click();
    }
    public boolean checkScreenAfterRefresh(){
        LOG.infoWithScreenshot("Проверка экрана после включения WiFi ");
        return logoOzonID.isDisplayed();
    }

    public NumberAuthorizationScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
