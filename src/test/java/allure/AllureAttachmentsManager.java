package allure;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static tests.BaseTest.getDriver;

public class AllureAttachmentsManager {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot() {
        Allure.getLifecycle().getCurrentTestCaseOrStep();
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

