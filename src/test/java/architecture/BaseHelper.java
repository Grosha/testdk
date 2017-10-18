package architecture;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BaseHelper {
    private By locatorToolbarTitleMain = By.id("toolbar_title_centered");
    private By locatorToolbarTitle = By.id("toolbar_title");
    protected AndroidDriver driver;

    public BaseHelper(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement $(By by) {
        waitElement(by, 10);
        return driver.findElement(by);
    }

    public void scrollTo(String elementName) {
        driver.scrollTo(elementName);
    }

    public void waitElement(By element, long time) {
        //wait comment
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException exception) {
            System.out.println(element + " does not apear");
        } catch (NoSuchElementException e) {
            System.out.println(element + " not found");
        }
    }

    public WebElement findMainToolbarStatus() {
        return $(locatorToolbarTitleMain);
    }

    public WebElement findToolbarTitle() {
        return $(locatorToolbarTitle);
    }

    public void waitToolbarTitle() {
        waitElement(locatorToolbarTitle, 5);
    }
}
