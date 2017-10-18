package architecture.mainpage;

import architecture.BaseHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPageHelper extends BaseHelper {

    private By locatorScrollDownImage = By.id("img_scroll_down_lines");
    private By locatorGreenButton = By.xpath("//android.widget.LinearLayout");
    private By locatorCategorySpeedBoosterTitle = By.xpath("//android.widget.TextView[contains(@text,'Speed Booster')]");
    private By locatorCategorySystemCleanerTitle = By.xpath("//android.widget.TextView[contains(@text,'System Cleaner')]");
    private By locatorCategoryBatterySaverTitle = By.xpath("//android.widget.TextView[contains(@text,'Security Enhancer')]");
    private By locatorCategorySecurityEnhancerTitle = By.xpath("//android.widget.TextView[contains(@text,'Battery Saver')]");
    private By locatorToolbarCoolerIcon = By.id("cooler_menu");
    private By locatorSBButton = By.id("sb_item_button");
    private By locatorQuickFixButton = By.id("btn_fix");
    private By locatorCancelQuickFixButton = By.id("//android.widget.TextView[contains(@id,'btn_fix')]&//android.widget.TextView[contains(@text,'CANCEL')]");
    private By locatorQuickFixBoostText = By.xpath("//android.widget.TextView[contains(@id,'progress_bar_perf_container')]//android.widget.TextView[contains(@text,'Boosting performance')]");
    private By locatorQuickFixJunkText = By.xpath("//android.widget.TextView[contains(@id,'progress_bar_clean_container')]//android.widget.TextView[contains(@text,'Cleaning junk')]");
    private By locatorScrollDownButton = By.id("btn_scroll_down");
    
    public static String SYSTEM_STATUS = "System status";

    public MainPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findScrollDownImage() {
        return $(locatorScrollDownImage);
    }

    public WebElement findQuickFixBoostText() {
        return $(locatorQuickFixBoostText);
    }

    public WebElement findQuickFixJunkText() {
        return $(locatorQuickFixJunkText);
    }

    public WebElement findToolbarCoolerIcon() {
        return $(locatorToolbarCoolerIcon);
    }

    public WebElement findQuickFixButton() {
        return $(locatorQuickFixButton);
    }

    public WebElement findCancelQuickFixButton() {
        return $(locatorCancelQuickFixButton);
    }

    public WebElement findScrollDownButton() {
        return $(locatorScrollDownButton);
    }

    public WebElement findCategorySpeedBoosterTitle() {
        return $(locatorCategorySpeedBoosterTitle);
    }

    public WebElement findCategorySpeedCleanerTitle() {
        return $(locatorCategorySystemCleanerTitle);
    }

    public WebElement findCategoryBatterySaverTitle() {
        return $(locatorCategoryBatterySaverTitle);
    }

    public WebElement findCategorySpeedEnhancerTitle() {
        return $(locatorCategorySecurityEnhancerTitle);
    }

    public WebElement findGreenButton() {
        return $(locatorGreenButton);
    }

    public void waitScrollDownImage() {
        waitElement(locatorScrollDownImage, 60);
    }

    public void waitGreenButton() {
        waitElement(locatorGreenButton, 60);
    }
}
