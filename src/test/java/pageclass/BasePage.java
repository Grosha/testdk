package pageclass;

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
        $(Locators.locatorOpenDrawer).click();
    }

    private WebElement $(By by) {
        waitElement(by);
        return driver.findElement(by);
    }

    private void waitElement(By element) {
        //wait comment
        WebDriverWait wait = new WebDriverWait(driver, 60L);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException exception) {
            System.out.println(element + " does not apear");
        } catch (NoSuchElementException e) {
            System.out.println(element + " not found");
        }
    }

    public void openFeatureFromDrawer(String featureName) {
        String locatorFeature = "//android.widget.CheckedTextView[@text='" + featureName + "']";
        $(By.xpath(locatorFeature)).click();
        waitElement(locatorOpenDrawer);
    }

    public String getMainToolbarTitle(){
        return $(locatorToolbarStatusMain).getText().toString();
    }

    public String getToolbarTitle(){
        return $(locatorToolbarStatus).getText().toString();
    }

    public String getFeatureNote() {
        return $(locatorFeatureNote).getText().toString();
    }

    public void waitTitleIssues(){
        waitElement(locatorScrollDownLines);
    }

    public void waitGreenButton(){
        waitElement(locatorGreenButton);
    }
    public void waitFeatureNote(){
        waitElement(locatorFeatureNote);
    }
}
