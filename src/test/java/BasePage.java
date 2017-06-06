import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public class BasePage implements Locators {
    private  AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openDrawer() {
        $(locatorOpenDrawer).click();
    }

    public WebElement $(By by) {
        waitElement(by);
        return driver.findElement(by);
    }

    public void waitElement(By element) {
        //wait comment
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException exception) {
            System.out.println(element + " does not apear");
        } catch (NoSuchElementException e) {
            System.out.println(element + " not found");
        }
    }

    public void openFeatureFromDrawer(String featureName) {
        String locatorFeature = "//android.widget.CheckedTextView[@text,'" + featureName + "')]";
        By locatorDrCacheFile = By.xpath(locatorFeature);
        $(locatorDrCacheFile).click();
    }
}
