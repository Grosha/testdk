package architecture.mainpage;

import architecture.popup.BasePopupHelper;
import io.appium.java_client.android.AndroidKeyCode;
import architecture.afterfixstate.AfterFixHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageTest extends SetUpAppium {
    private MainPageHelper mainPageHelper;
    private AfterFixHelper afterFixHelper;
    private BasePopupHelper basePopupHelper;
    private SoftAssert softAssert;

    public void initDriver() {
        softAssert = new SoftAssert();
        mainPageHelper = new MainPageHelper(driver);
        afterFixHelper = new AfterFixHelper(driver);
        basePopupHelper = new BasePopupHelper(driver);
    }

    @Test
    public void testMainPageElements() {
        softAssert.assertEquals(mainPageHelper.findMainToolbarStatus().getText().toString(), MainPageHelper.SYSTEM_STATUS, "Wrong system status");
        softAssert.assertTrue(mainPageHelper.findToolbarCoolerIcon().isDisplayed(), "Cooler icon wasn't shown in the toolbar");
        softAssert.assertTrue(mainPageHelper.findCategorySpeedBoosterTitle().isEnabled(), "Category SpeedBooster wasn't clickable");
        softAssert.assertTrue(mainPageHelper.findCategorySpeedCleanerTitle().isEnabled(), "Category SpeedCleaner wasn't clickable");
        softAssert.assertTrue(mainPageHelper.findCategorySpeedEnhancerTitle().isEnabled(), "Category SpeedEnhancer wasn't clickable");
        softAssert.assertTrue(mainPageHelper.findCategoryBatterySaverTitle().isEnabled(), "Category BatterySaver wasn't clickable");
        softAssert.assertTrue(mainPageHelper.findQuickFixButton().isDisplayed(), "QuickFiX button wasn't shown");
        softAssert.assertTrue(mainPageHelper.findQuickFixButton().isEnabled(), "QuickFix button wasn't clickable");
        mainPageHelper.waitScrollDownImage();
        softAssert.assertTrue(mainPageHelper.findScrollDownImage().isDisplayed(), "ScrollDown image wasn't shown");
        softAssert.assertAll();
    }

    @Test
    public void testRunQuickFix() {
        mainPageHelper.waitScrollDownImage();
        mainPageHelper.findQuickFixButton().click();
        softAssert.assertTrue(mainPageHelper.findQuickFixBoostText().isDisplayed(), "Boosting performance text wasn't shown when ran quick fix");
        softAssert.assertTrue(mainPageHelper.findQuickFixJunkText().isDisplayed(), "Cleaning junk text wasn't shown when ran quick fix");

        afterFixHelper.waitAfterFixState();
        basePopupHelper.findPopupCloseButton().click();
        softAssert.assertEquals(mainPageHelper.findToolbarTitle().getText().toString(), AfterFixHelper.quickFixToolbarTitle, "Incorrect toolbar title after quick fix in afterfix state");
        softAssert.assertEquals(afterFixHelper.findAfterFixSubTitlte().getText().toString(), AfterFixHelper.afterFixSubtitleAuickFix, "Incorrect after fix title after quick fix in afterfix state");
        softAssert.assertAll();
    }

    @Test
    public void testCancelQuickFix() {
        mainPageHelper.waitScrollDownImage();
        mainPageHelper.findQuickFixButton().click();
        softAssert.assertEquals(mainPageHelper.findCancelQuickFixButton().getText().toString().toUpperCase(), "CANCEL", "Incorrect button name for cancel quick fix");

        mainPageHelper.findCancelQuickFixButton().click();
        softAssert.assertEquals(mainPageHelper.findMainToolbarStatus().getText().toString(), MainPageHelper.SYSTEM_STATUS, "Wrong system status after cancel quick fix");
        softAssert.assertTrue(mainPageHelper.findQuickFixButton().isEnabled(), "QuickFix button wasn't clickable");
        softAssert.assertAll();
    }

    @Test
    public void testResumeApplicationWhileIsRunningQuickFix() {
        mainPageHelper.waitScrollDownImage();
        mainPageHelper.findQuickFixButton().click();
        softAssert.assertTrue(mainPageHelper.findQuickFixBoostText().isDisplayed(), "Boosting performance text wasn't shown when ran quick fix");

        driver.sendKeyEvent(AndroidKeyCode.HOME);
        driver.runAppInBackground(5);
        softAssert.assertTrue(mainPageHelper.findQuickFixJunkText().isDisplayed(), "Cleaning junk text wasn't shown when ran quick fix");
        softAssert.assertAll();
    }
}
