package pageclass;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;


public class BasePage implements Locators {
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openDrawer() {
        $(locatorOpenDrawer).click();
    }

    protected WebElement $(By by) {
        waitElement(by);
        return driver.findElement(by);
    }

    protected void waitElement(By element) {
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

    public String getMainToolbarTitle() {
        return $(locatorToolbarStatusMain).getText().toString();
    }

    public String getToolbarTitle() {
        return $(locatorToolbarStatus).getText().toString();
    }

    public String getFeatureNote() {
        return $(locatorFeatureNote).getText().toString();
    }

    public void waitTitleIssues() {
        waitElement(locatorScrollDownLines);
    }

    public void waitGreenButton() {
        waitElement(locatorGreenButton);
    }

    public void waitFeatureNote() {
        waitElement(locatorFeatureNote);
    }

    public void scrollTo(String elementName) {
        driver.scrollTo(elementName);
    }

    public void createScreenShots(String featureName) throws IOException {
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        //create dir with given folder name
        DateFormat df =new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        String folderName = df.toString();
        new File(folderName).mkdir();
        //Setting file name
        String fileName = featureName + ".png";
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(screenshot, new File(folderName + "/" + fileName));
    }

}
