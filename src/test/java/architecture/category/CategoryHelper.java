package architecture.category;

import io.appium.java_client.android.AndroidDriver;
import architecture.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CategoryHelper extends BaseHelper {

    private By locatorCategoryInfoTitle = By.id("category_info_block_title");
    private By locatorCategoryInfoText = By.id("category_info_block_text");
    private By locatorCategoryActionButton = By.id("category_top_action_btn");
    private By locatorCategoryResultTitle = By.id("category_top_title");
    private By locatorCategoryResultSubTitle = By.id("category_top_subtitle");
    private By locatorToolbarToolboxMenuIcon = By.id("toolbox_menu");

    public static String CATEGORY_NAME_SPEED_BOOSTER = "Speed Booster";
    public static String CATEGORY_NAME_SYSTEM_CLEANER = "System Cleaner";
    public static String CATEGORY_NAME_BATTERY_SAVER = "Battery Saver";
    public static String CATEGORY_NAME_SECURITY_ENHANCER = "Security Enhancer";
    public static String CATEGORY_SPEED_BOOSTER_INFO_TITLE = "Welcome to Speed Booster!";
    public static String CATEGORY_SPEED_BOOSTER_INFO_TEXT = "Tap BOOST button each time you see the performance is low.\n" +
            "\n" +
            "Then just follow tooltips you`ll see on a bottom of the screen to get even more performance!";
    public static String CATEGORY_SYSTEM_CLEANER_INFO_TITLE = "Welcome to System Cleaner!";
    public static String CATEGORY_SYSTEM_CLEANER_INFO_TEXT = "Tap CLEAN to free up your device`s memory.\n" +
            "\n" +
            "This tool removes junk files does not affect your personal data.Then you can follow red and green tutorials to get even more free space!";
    public static String CATEGORY_SECURITY_INFO_TITLE = "Welcome to Security Enhancer!";
    public static String CATEGORY_SECURITY_INFO_TEXT = "Tap PROTECT to check your device for malware and viruses.\n" +
            "\n" +
            "We recommend to perform this scan each day";
    public static String CATEGORY_BATTERY_INFO_TITLE = "Welcome to Battery Saver!";
    public static String CATEGORY_BATTERY_INFO_TEXT = "Tap PROLONG to hibernate power hungry apps running in background and prolong your battery life for up to 50%!\n" +
            "\n" +
            "Please, give permission to Droid Keeper on the next step.";

    public static String SPEED_BOOSTER_RESULT_TITLE_LOW = "Low";
    public static String SPEED_BOOSTER_RESULT_SUBTITLE_LOW = "Need boosting";
    public static String SYSTEM_CLEANER_RESULT_TITLE_TRASH = "GB";
    public static String SYSTEM_CLEANER_RESULT_SUBTITLE_TRASH = "Need cleaning";
    public static String BATTERY_SAVER_RESULT_TITLE_BAD = "BAD";
    public static String BATTERY_SAVER_RESULT_SUBTITLE_BAD = "Stop battery-hungry apps";
    public static String SECURITY_ENHANCER_RESULT_TITLE_NOT_SAFE = "NOT safe";
    public static String SECURITY_ENHANCER_RESULT_SUBTITLE_BAD = "Need protection";

    public static String CATEGORY_SECURITY_BUTTON_PROTECT = "Protect";
    public static String CATEGORY_BATTERY_BUTTON_PROLONG = "prolong";
    public static String CATEGORY_SPEED_BOOSTER_BUTTON_BOOST = "boost";
    public static String CATEGORY_SYSTEM_CLEANER_BUTTON_CLEAN = "clean";

    public CategoryHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findCategoryActionButton() {
        return $(locatorCategoryActionButton);
    }

    public WebElement findCategoryResultTitle() {
        return $(locatorCategoryResultTitle);
    }

    public WebElement findCategoryResultSubTitle() {
        return $(locatorCategoryResultSubTitle);
    }

    public WebElement findCategoryInfoText() {
        return $(locatorCategoryInfoText);
    }

    public WebElement findCategoryInfoTitle() {
        return $(locatorCategoryInfoTitle);
    }

    public WebElement findCategoryImage() {
        return $(locatorCategoryInfoTitle);
    }

    public void waitCategoryActionButton() {
        waitElement(locatorCategoryActionButton, 60);
    }

    public void waitCategoryResultTitle() {
        waitElement(locatorCategoryResultTitle, 60);
    }

    public WebElement findCategory(String categoryName) {
        String locatorCategory = "//android.widget.TextView[@text='" + categoryName + "']";
        return $(By.xpath(locatorCategory));
    }

    public WebElement findFeatureName(String featureName) {
        String locatorFeatureName = "//android.widget.TextView[contains(@id,'title_nav_item')]&//android.widget.TextView[contains(@text,'" + featureName +"')]";
        return $(By.xpath(locatorFeatureName));
    }

    public static ArrayList<String> listFeatureInCategory(String ... featureName){
        ArrayList<String> featuresList = new ArrayList<String>();
        for (String feature : featureName) {
            featuresList.add(feature);
        }

        return featuresList;
    }

    public WebElement findToolbarToolbarMenu() {
        return $(locatorToolbarToolboxMenuIcon);
    }
}
