package architecture.popup.remainder;

import architecture.popup.BasePopupHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RemainderPopupHelper extends BasePopupHelper {
    private By locatorExtendedSubtitlePopup = By.id("extended_subtitle");
    private By locatorAdditionalInfoPopupButton = By.id("btn_maximize_minimize");

    public static String popupRemainderConfirmButtonName = "set up now";
    public static String popupRemainderCloseButtonName = "discard";
    public static String popupRemainderTitle = "Set up a reminder";
    public static String popupRemainderSubtitle = "It is recommended to perform the boost and security scan once in 1-2 days." +
            " You can schedule both of these tasks to be performed automatically.";
    public static String popupRemainderExtendedSubtitle = "Each time you are launching the app, it most probably will stay on " +
            "the background, consuming your device`s battery life and resources. Quick Fix allows you to fix this issue and at" +
            " the same time clean junk files, consuming your device`s memory space without any need.";

    public RemainderPopupHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findAditionalInfoPopupButton() {
        return $(locatorAdditionalInfoPopupButton);
    }

    public WebElement findExtendedSubtitlePopup() {
        return $(locatorExtendedSubtitlePopup);
    }
}
