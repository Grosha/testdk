package pageclass;

import org.openqa.selenium.By;

public interface Locators {
    //open drawer
    By locatorOpenDrawer = By.xpath("//android.widget.ImageButton");
    By locatorToolbarStatus = By.id("toolbar_title");
    By locatorToolbarStatusMain = By.id("toolbar_title_centered");
    By locatorTitleIssues = By.id("sub_title_issues");
    By locatorScrollDownLines = By.id("img_scroll_down_lines");
    By locatorGreenButton = By.xpath("//android.widget.LinearLayout");
    By locatorFeatureNote = By.id("note");

    //main page
    By locatorCSpeedBoosterTitle = By.xpath("//android.widget.TextView[contains(@text,'Speed Booster')]");
    By locatorCSystemCleanerTitle = By.xpath("//android.widget.TextView[contains(@text,'System Cleaner')]");
    By locatorCBatterySaverTitle = By.xpath("//android.widget.TextView[contains(@text,'Security Enhancer')]");
    By locatorCSequrityEnhancerTitle = By.xpath("//android.widget.TextView[contains(@text,'Battery Saver')]");
    By locatorCoolerMenu = By.id("cooler_menu");
    By locatorSBButton = By.id("sb_item_button");
    By locatorQFButton = By.id("quick-fix");
    By locatorCQFButton = By.id("camcel_quick-fix");
    By locatorQFBoostText = By.id("quick-fix");
    By locatorQFJunkText = By.id("quick-fix");
    By locatorScrollDownButton = By.id("scroll_down");

    //reminder
    By locatorDismissReminder = By.id("quick-fix");


    //after fix state
    By locatorAfterFixFedback = By.id("quick-fix");

}
