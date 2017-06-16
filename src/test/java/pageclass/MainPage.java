package pageclass;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public void openCategory(String categoryName) {
        String locatorCategory = "//android.widget.TextView[@text='" + categoryName + "']";
        $(By.xpath(locatorCategory)).click();
    }

    public void openCooler() {
        $(locatorCoolerMenu).click();
    }

    public void openScrollBlock() {
        $(locatorSBButton).click();
    }

    public void swipe() {
        driver.swipe(500,800,500,200,1);
    }



}
