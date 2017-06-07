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
}
