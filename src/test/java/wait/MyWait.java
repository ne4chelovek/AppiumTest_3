package wait;

import tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class MyWait {
    private final Logger LOG = LoggerFactory.getLogger(MyWait.class);
    private final WebDriverWait wait;
    private final int secondsToWait;


    public static MyWait myWait(int seconds) {
        return new MyWait(seconds);
    }

    public MyWait(int seconds){
        secondsToWait = seconds;
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public WebElement clickable(WebElement element){
        LOG.info("Ждём " + secondsToWait + " секунд, пока элемент не станет видимым " + element.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void visible(WebElement element){
        LOG.info("Ждём " + secondsToWait + " секунд, пока элемент не станет видимым " + element.toString());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean invisible(WebElement element){
        LOG.info("Ждём " + secondsToWait + " секунд, пока элемент не станет видимым " + element.toString());
        return wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    public void pause() {
        try {
            LOG.info("waiting for "+ secondsToWait + " seconds ");
            Thread.sleep(secondsToWait * 1000L);
        }
        catch (InterruptedException e) {
            LOG.info("thread was interrupted");
        }
    }
}
