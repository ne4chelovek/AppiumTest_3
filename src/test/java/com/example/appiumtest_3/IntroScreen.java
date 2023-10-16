package com.example.appiumtest_3;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroScreen {
    @AndroidFindBy (id = "input_view")
    private WebElement searchField;

    public boolean checkSearchField(){
        return searchField.isEnabled();
    }

    public IntroScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
