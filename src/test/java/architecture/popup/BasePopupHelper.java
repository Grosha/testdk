package architecture.popup;

import architecture.BaseHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePopupHelper extends BaseHelper {
    private By locatorCloseButton = By.id("btn_close");
    private By locatorConfirmButton = By.id("btn_confirm");
    private By locatorSubtitlePopup = By.id("subtitle");
    private By locatorTitlePopup = By.id("title");
    private By locatorPopupImage = By.id("top_image_view");

    public BasePopupHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findPopupCloseButton() {
        return $(locatorCloseButton);
    }

    public WebElement findPopupConfirmButton() {
        return $(locatorConfirmButton);
    }

    public WebElement findSubtitlePopup() {
        return $(locatorSubtitlePopup);
    }

    public WebElement findTitlePopup() {
        return $(locatorTitlePopup);
    }

    public WebElement findPopupImage() {
        return $(locatorPopupImage);
    }
}
