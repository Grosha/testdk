package architecture.OnBoaring;

import architecture.BaseHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnBoardingHelper extends BaseHelper {
    private By locatorGetStartedButton = By.id("btn_get_started");

    public OnBoardingHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findGetStartedButton() {
        return $(locatorGetStartedButton);
    }
}
