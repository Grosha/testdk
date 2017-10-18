package architecture.feature.MagicStopper;

import io.appium.java_client.android.AndroidDriver;
import architecture.feature.BaseFeatureHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MagicStopperHelper extends BaseFeatureHelper {
    public static String MAGIC_STOPPER_NOTE = "Choose apps to stop from running on background. Increase your battery life for up to 50%.";
    public static  String GeneralActionButtonName = "FREE UP MEMORY";
    public static  String SubtitleHeader = "Can be cleaned";

    private By locatorCheckBoxItem = By.id("cbx_app");
    private By locatorApplicationImageItem = By.id("img_app_icon");
    private By locatorApplicationNameItem = By.id("txt_app_name");
    private By locatorApplicationSubtitleItem = By.id("txt_app_subtitle");

    public MagicStopperHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findCheckBoxItem() {
        return $(locatorCheckBoxItem);
    }

    public WebElement findApplicationImageItem() {
        return $(locatorApplicationImageItem);
    }

    public WebElement findApplicationNameItem() {
        return $(locatorApplicationNameItem);
    }

    public WebElement findApplicationSubtitleItem() {
        return $(locatorApplicationSubtitleItem);
    }
}
