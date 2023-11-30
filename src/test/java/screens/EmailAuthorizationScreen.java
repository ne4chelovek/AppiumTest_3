package screens;

import allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static wait.MyWait.myWait;


public class EmailAuthorizationScreen {

    private static final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(EmailAuthorizationScreen.class));
    @AndroidFindBy(id ="topRightContainer")
    private WebElement enterOzon;
    @AndroidFindBy(id = "hintButtonsLinearLayout")
    private WebElement enterByEmail;
    @AndroidFindBy(id = "inputEditText")
    private WebElement inputEmail;
    @AndroidFindBy(id = "touch_outside")
    private WebElement closeBanner;
    @AndroidFindBy(id="submitButton")
    private WebElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"credentialsTextField.label\"]")
    private WebElement fieldAfterInput;
    @AndroidFindBy(id = "textBlockWidgetWrapper")
    private WebElement adbBanner;
    @AndroidFindBy(id="titleTextAtomV2")
    private WebElement warningAfterInput;
    @AndroidFindBy(id = "errorView")
    private WebElement noWifiConnection;
    @AndroidFindBy(id = "hintButtonsLinearLayout")
    private WebElement backMainScreen;
    @AndroidFindBy(id = "screenStateActionBtn") ////android.widget.FrameLayout[@resource-id="ru.ozon.app.android:id/screenStateActionBtn"]
    private WebElement refreshButton;
    @AndroidFindBy(id = "logoImageView")
    private WebElement logoOzonID;


    public void touchOutside(){
        myWait(10).visible(adbBanner);
        closeBanner.click();
    }
    public void openValidation(){
        LOG.info("Нажатие на кнопку 'Войти' на основном экране ");
        enterOzon.click();
        LOG.info("Нажатие на кнопку 'Войти через почту'");
        enterByEmail.click();
    }
    public void inputTextEmail(String email){
        LOG.info("Ввод email");
        inputEmail.click();
        myWait(5).visible(inputEmail);
        inputEmail.sendKeys(email);
    }
    public void submitClick(){
        LOG.info("Клик по кнопке 'Войти'");
        submitButton.click();
    }
    public boolean warningMessage(){
        LOG.info("Проверка сообщения деактивированного аккаунта");
        return warningAfterInput.isDisplayed();
    }
    public boolean errorMessage(){
        LOG.info("Проверка появления ошибки");
        return fieldAfterInput.isDisplayed();
    }
    public boolean checkScreenStateView(){
        LOG.infoWithScreenshot("Проверка состояния экрана без подключения к WiFi");
        return noWifiConnection.isDisplayed();
    }
    public void backMainScreenClick(){
        LOG.info("Клик по кнопке 'Вернуться на главную страницу'");
        backMainScreen.click();
    }
    public void refreshButtonClick(){
        LOG.info("Клик по кнопке 'Обновить'");
        refreshButton.click();
    }
    public boolean checkScreenAfterRefresh(){
        LOG.infoWithScreenshot("Проверка экрана после включения WiFi ");
        return logoOzonID.isDisplayed();
    }

    public EmailAuthorizationScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}



