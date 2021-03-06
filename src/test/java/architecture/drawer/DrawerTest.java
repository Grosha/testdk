package architecture.drawer;

import architecture.feature.BaseFeatureHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import architecture.SetUpAppium;

import static org.testng.Assert.assertEquals;
import org.testng.asserts.SoftAssert;

public class DrawerTest extends SetUpAppium {
    private DrawerHelper drawerHelper;
    private MainPageHelper mainPageHelper;
    private BaseFeatureHelper baseFeatureHelper;
    private SoftAssert softAssert = new SoftAssert();

    public void initDriver() {
        drawerHelper = new DrawerHelper(driver);
        mainPageHelper = new MainPageHelper(driver);
        baseFeatureHelper = new BaseFeatureHelper(driver);
    }


    @DataProvider(name = "drawerFeature")
    public static Object[][] featureData() {
        return new Object[][]{
                {BaseFeatureHelper.CACHE_FILES, BaseFeatureHelper.CACHE_FILE_NOTE},
                {BaseFeatureHelper.MEMORY_CLEANUP, BaseFeatureHelper.MEMORY_CLEAN_UP_NOTE},
                {BaseFeatureHelper.ADVANCED_JUNK, BaseFeatureHelper.ADVANCED_JUNK_NOTE},
                {BaseFeatureHelper.GAME_BOOSTER, BaseFeatureHelper.GAME_BOOSTER_NOTE},
                {BaseFeatureHelper.AUTOLAUNCH_APPS, BaseFeatureHelper.AUTOLAUNCHAPP_NOTE},
                {BaseFeatureHelper.UNINSTALL_OF_APPS, BaseFeatureHelper.UNINSTALLER_NOTE},
                {BaseFeatureHelper.PHONE_COOLER, BaseFeatureHelper.PHONE_COOLER_NOTE},
                {BaseFeatureHelper.APPLOCKER, BaseFeatureHelper.APPLOCKER_NOTE},
                {BaseFeatureHelper.ENERGY_MODE, BaseFeatureHelper.ENERGY_MODE_NOTE},
                {BaseFeatureHelper.MAGIC_STOPPER, BaseFeatureHelper.MAGIC_STOPPER_NOTE},
                {BaseFeatureHelper.BATTERY_CONSUMPTION, BaseFeatureHelper.BATTERY_CONSUMTION_NOTE},
        };
    }

    @Test(dataProvider = "drawerFeature")
    public void testOpenFeatureThroughDrawer(String featureName, String featureNote) {

        mainPageHelper.waitScrollDownImage();

        drawerHelper.openDrawer();
        drawerHelper.scrollTo(featureName);
        drawerHelper.openFeatureFromDrawer(featureName);
        softAssert.assertEquals(mainPageHelper.findToolbarTitle().getText().toUpperCase(), featureName.toUpperCase());

        baseFeatureHelper.waitFeatureNote();
        softAssert.assertEquals(baseFeatureHelper.findFeatureNote().getText().toString(), featureNote);
        softAssert.assertAll();
    }

    @Test
    public void testCloseDrawer(){
        drawerHelper.openDrawer();
        driver.navigate().back();
        assertEquals(mainPageHelper.findMainToolbarStatus().getText().toString(), MainPageHelper.SYSTEM_STATUS, "Wrong system status om main page");
    }
}
