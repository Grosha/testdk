package testclass;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageclass.BasePage;

import static org.testng.Assert.assertEquals;

public class DrawerTest extends SetUpAppium {
    public BasePage page;

    public void initDriver() {
        page = new BasePage(driver);
    }


    @DataProvider(name = "feature")
    public static Object[][] dataSendAddClick() {
        return new Object[][]{
                {CACHE_FILES, CACHE_FILE_NOTE},
                {MEMORY_CLEANUP, MEMOTY_CLEAN_UP_NOTE},
                {ADVANCED_JUNK, ADVANED_JUNK_NOTE},
                {GAME_BOOSTER, GAME_BOOSTER_NOTE},
                {AUTOLAUNCH_APPS, AUTOLAUNCHAPP_NOTE},
                {UNINSTALL_OF_APPS, UNINSTALLER_NOTE},
        };
    }


    @Test(dataProvider = "feature")
    public void openFeatureThroughDrawer(String featureName, String featureNote) {
        Assert.assertEquals(page.getMainToolbarTitle(), SYSTEM_STATUS);
        page.waitTitleIssues();
        page.openDrawer();
        page.openFeatureFromDrawer(featureName);
        assertEquals(page.getToolbarTitle().toUpperCase(), featureName.toUpperCase());
        page.waitFeatureNote();
        assertEquals(page.getFeatureNote(), featureNote);
    }


}
