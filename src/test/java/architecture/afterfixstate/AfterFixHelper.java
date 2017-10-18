package architecture.afterfixstate;

import io.appium.java_client.android.AndroidDriver;
import architecture.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AfterFixHelper extends BaseHelper {
    private By locatorAfterFixSubtitle = By.id("tv.afterfix.subtitle");
    private By locatorAfterFixTitle = By.id("tv.afterfix.title");

    public static String quickFixToolbarTitle = "Quick Fix";
    public static String afterFixSubtitleAuickFix = "Your device runs faster now!";

    public AfterFixHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findAfterFixTitlte() {
        return $(locatorAfterFixTitle);
    }

    public WebElement findAfterFixSubTitlte() {
        return $(locatorAfterFixSubtitle);
    }

    public void waitAfterFixState() {
        waitElement(locatorAfterFixTitle, 60);
    }
}
