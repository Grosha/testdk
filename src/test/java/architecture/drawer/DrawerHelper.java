package architecture.drawer;

import io.appium.java_client.android.AndroidDriver;
import architecture.BaseHelper;
import org.openqa.selenium.By;

public class DrawerHelper extends BaseHelper {
    private By locatorOpenDrawer = By.xpath("//android.widget.ImageButton");

    public DrawerHelper(AndroidDriver driver) {
        super(driver);
    }

    public void openDrawer() {
        $(locatorOpenDrawer).click();
    }

    public void openFeatureFromDrawer(String featureName) {
        String locatorFeature = "//android.widget.CheckedTextView[@text='" + featureName + "']";
        $(By.xpath(locatorFeature)).click();
        waitElement(locatorOpenDrawer, 10);
    }
}
