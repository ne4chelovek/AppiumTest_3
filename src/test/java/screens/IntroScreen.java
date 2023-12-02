package screens;

import allure.AllureLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static wait.MyWait.myWait;

public class IntroScreen {

    private static final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));

    @AndroidFindBy(id = "searchTv")
    private WebElement searchField;
    @AndroidFindBy(id = "touch_outside")
    private WebElement closeBanner;
    @AndroidFindBy(id = "advBannerPlainView")
    private WebElement advBanner;
    @AndroidFindBy(id = "menu_cart")
    private WebElement basketMenu;
    @AndroidFindBy(id = "emptyStateActionTv")
    private WebElement enterOzonReg;
    @AndroidFindBy(id = "inputTextGroup")
    private WebElement fieldInput;
    @AndroidFindBy(id = "screenStateView")
    private WebElement noWifiConnection;
    @AndroidFindBy(id = "textBlockWidgetWrapper")
    private WebElement adbBanner;
    @AndroidFindBy(uiAutomator = "new UiSelector(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector()" +
            ".text(\"Специальные предложения!\").instance(0))")
    private WebElement scrollToSpecialOffers;


    public void touchOutside(){
        myWait(10).visible(adbBanner);
        closeBanner.click();
    }

    public boolean checkSearchField() {
        LOG.infoWithScreenshot("Проверка поля ввода");
        myWait(5).visible(searchField);
        return searchField.isEnabled();
    }

    public boolean checkAdbBanner() {
        LOG.info("Проверка отображения рекламного баннера");
        return advBanner.isDisplayed();
    }

    public void clickBasketMenu() {
        LOG.info("Клик по корзине в меню");
        basketMenu.click();
    }

    public boolean checkScreenStateView() {
        LOG.infoWithScreenshot("Проверка состояния экрана без подключения к WiFi");
        return noWifiConnection.isDisplayed();
    }
    public boolean checkAfterScroll(){
        LOG.infoWithScreenshot("Проверка отображения блока 'Специальные предложения!'");
        scrollToSpecialOffers.click();
        return scrollToSpecialOffers.isDisplayed();
    }
    public class SADasd{
        public void asdagf(){
            adbBanner.click();
        }
    }


    public IntroScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
