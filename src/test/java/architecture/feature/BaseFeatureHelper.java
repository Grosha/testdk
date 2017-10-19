package architecture.feature;

import io.appium.java_client.android.AndroidDriver;
import architecture.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseFeatureHelper extends BaseHelper {
    private By locatorFeatureNote = By.id("note");
    private By locatorGeneralActionButton = By.id("btn_general_action");
    private By locatorGeneralActionButtonName = By.id("btn_text_base");
    private By locatorFeatureSubtitleHeader = By.id("header_subtitle");

    public static String CACHE_FILES = "Cache files";
    public static String UNINSTALL_OF_APPS = "Uninstall of apps";
    public static String ADVANCED_JUNK = "Advanced junk";
    public static String LARGE_OLD_FILES = "Large & old files";
    public static String MEMORY_CLEANUP = "Memory cleanup";
    public static String GAME_BOOSTER = "Game booster";
    public static String AUTOLAUNCH_APPS = "Autolaunch apps";
    public static String PHONE_COOLER = "Phone Cooler";
    public static String BATTERY_CONSUMPTION = "Battery consumption";
    public static String ENERGY_MODE = "Energy mode";
    public static String MAGIC_STOPPER = "Magic stopper";
    public static String ANTIVIRUS = "Antivirus";
    public static String APPLOCKER = "AppLocker";
    public static String PHOTO_HIDER = "Photo hider";
    public static String QUICK_BOOST = "Quick boost";
    public static String TOOLBOX = "Toolbox";
    public static String SETTINGS = "Settings";
    public static String ABOUT_PAGE = "About Page";

    public static String CACHE_FILE_NOTE = "Safely remove cache files to free up extra space.";
    public static String UNINSTALLER_NOTE = "Choose apps to uninstall";
    public static String AUTOLAUNCHAPP_NOTE = "Select apps autolaunching at startup";
    public static String MEMORY_CLEAN_UP_NOTE = "Stop background apps to increase your performance";
    public static String ADVANCED_JUNK_NOTE = "Get rid of app leftovers consuming memory space.";
    public static String GAME_BOOSTER_NOTE = "Click on the Game to boost";
    public static String PHONE_COOLER_NOTE = "Your device runs well, but we recommend you to stop these apps";
    public static String MAGIC_STOPPER_NOTE = "Your device runs well, but we recommend you to stop these apps";

    public static String BATTERY_CONSUMTION_NOTE = "Stop unneeded apps consuming your device's battery life";
    public static String ENERGY_MODE_NOTE = "Choose energy mode or create your own to easily manage battery consumption";
    public static String APPLOCKER_NOTE = "Choose apps to protect from unauthorised access";

    public BaseFeatureHelper(AndroidDriver driver) {
        super(driver);
    }

    public WebElement findFeatureNote() {
        return $(locatorFeatureNote);
    }

    public void waitFeatureNote() {
        waitElement(locatorFeatureNote, 5);
    }

    public void waitActionButton() {
        waitElement(locatorGeneralActionButton, 10);
    }

    public WebElement findGeneralActionButton() {
        return $(locatorGeneralActionButton);
    }

    public WebElement findGeneralActionButtonName() {
        return $(locatorGeneralActionButtonName);
    }

    public WebElement findFeatureSubtitleHeader() {
        return $(locatorFeatureSubtitleHeader);
    }
}
