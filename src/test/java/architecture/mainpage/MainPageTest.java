package architecture.mainpage;

import architecture.popup.BasePopupHelper;
import io.appium.java_client.android.AndroidKeyCode;
import architecture.afterfixstate.AfterFixHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageTest extends SetUpAppium {
    private MainPageHelper mainPageHelper;
    private AfterFixHelper afterFixHelper;
    private BasePopupHelper basePopupHelper;

    public void initDriver() {
        mainPageHelper = new MainPageHelper(driver);
        afterFixHelper = new AfterFixHelper(driver);
        basePopupHelper = new BasePopupHelper(driver);
    }

    @Test
    public void testMainPageElements() {
        assertEquals(mainPageHelper.findMainToolbarStatus().getText().toString(), MainPageHelper.SYSTEM_STATUS, "Wrong system status");
        assertTrue(mainPageHelper.findToolbarCoolerIcon().isDisplayed(), "Cooler icon wasn't shown in the toolbar");
        assertTrue(mainPageHelper.findCategorySpeedBoosterTitle().isEnabled(), "Category SpeedBooster wasn't clickable");
        assertTrue(mainPageHelper.findCategorySpeedCleanerTitle().isEnabled(), "Category SpeedCleaner wasn't clickable");
        assertTrue(mainPageHelper.findCategorySpeedEnhancerTitle().isEnabled(), "Category SpeedEnhancer wasn't clickable");
        assertTrue(mainPageHelper.findCategoryBatterySaverTitle().isEnabled(), "Category BatterySaver wasn't clickable");
        assertTrue(mainPageHelper.findQuickFixButton().isDisplayed(), "QuickFiX button wasn't shown");
        assertTrue(mainPageHelper.findQuickFixButton().isEnabled(), "QuickFix button wasn't clickable");
        mainPageHelper.waitScrollDownImage();
        assertTrue(mainPageHelper.findScrollDownImage().isDisplayed(), "ScrollDown image wasn't shown");
    }

    @Test
    public void testRunQuickFix() {
        mainPageHelper.waitScrollDownImage();
        mainPageHelper.findQuickFixButton().click();
        assertTrue(mainPageHelper.findQuickFixBoostText().isDisplayed(), "Boosting performance text wasn't shown when ran quick fix");
        assertTrue(mainPageHelper.findQuickFixJunkText().isDisplayed(), "Cleaning junk text wasn't shown when ran quick fix");

        afterFixHelper.waitAfterFixState();
        basePopupHelper.findPopupCloseButton().click();
        assertEquals(mainPageHelper.findToolbarTitle().getText().toString(), AfterFixHelper.quickFixToolbarTitle, "Incorrect toolbar title after quick fix in afterfix state");
        assertEquals(afterFixHelper.findAfterFixSubTitlte().getText().toString(), AfterFixHelper.afterFixSubtitleAuickFix, "Incorrect after fix title after quick fix in afterfix state");
    }

    @Test
    public void testCancelQuickFix() {
        mainPageHelper.waitScrollDownImage();
        mainPageHelper.findQuickFixButton().click();
        assertEquals(mainPageHelper.findCancelQuickFixButton().getText().toString().toUpperCase(), "CANCEL", "Incorrect button name for cancel quick fix");

        mainPageHelper.findCancelQuickFixButton().click();
        assertEquals(mainPageHelper.findMainToolbarStatus().getText().toString(), MainPageHelper.SYSTEM_STATUS, "Wrong system status after cancel quick fix");
        assertTrue(mainPageHelper.findQuickFixButton().isEnabled(), "QuickFix button wasn't clickable");
    }

    @Test
    public void testResumeApplicationWhileIsRunningQuickFix() {
        mainPageHelper.waitScrollDownImage();
        mainPageHelper.findQuickFixButton().click();
        assertTrue(mainPageHelper.findQuickFixBoostText().isDisplayed(), "Boosting performance text wasn't shown when ran quick fix");

        driver.sendKeyEvent(AndroidKeyCode.HOME);
        driver.runAppInBackground(5);
        assertTrue(mainPageHelper.findQuickFixJunkText().isDisplayed(), "Cleaning junk text wasn't shown when ran quick fix");
    }
}
