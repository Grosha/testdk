package architecture.category;

import architecture.category.SystemCleanerCategory.SystemCleanerHelper;
import architecture.feature.BaseFeatureHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageclass.category.CategoryPage;
import architecture.SetUpAppium;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CategoryTest extends SetUpAppium {
    private CategoryPage categoryPage;
    private CategoryHelper categoryHelper;
    private MainPageHelper mainPageHelper;
    private BaseFeatureHelper baseFeatureHelper;

    public void initDriver() {
        mainPageHelper = new MainPageHelper(driver);
        categoryPage = new CategoryPage(driver);
        categoryHelper = new CategoryHelper(driver);
        baseFeatureHelper = new BaseFeatureHelper(driver);
    }

    @DataProvider(name = "categoryData")
    public static Object[][] categoryData() {
        return new Object[][]{
                {CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER,
                        CategoryHelper.SPEED_BOOSTER_RESULT_TITLE_LOW,
                        CategoryHelper.SPEED_BOOSTER_RESULT_SUBTITLE_LOW,
                        CategoryHelper.CATEGORY_SPEED_BOOSTER_INFO_TITLE,
                        CategoryHelper.CATEGORY_SPEED_BOOSTER_INFO_TEXT,
                        CategoryHelper.CATEGORY_SPEED_BOOSTER_BUTTON_BOOST,
                        CategoryHelper.listFeatureInCategory(BaseFeatureHelper.MEMORY_CLEANUP, BaseFeatureHelper.GAME_BOOSTER, BaseFeatureHelper.AUTOLAUNCH_APPS)},
                {CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER,
                        CategoryHelper.SYSTEM_CLEANER_RESULT_TITLE_TRASH,
                        CategoryHelper.SYSTEM_CLEANER_RESULT_SUBTITLE_TRASH,
                        CategoryHelper.CATEGORY_SYSTEM_CLEANER_INFO_TITLE,
                        CategoryHelper.CATEGORY_SYSTEM_CLEANER_INFO_TEXT,
                        CategoryHelper.CATEGORY_SYSTEM_CLEANER_BUTTON_CLEAN,
                        CategoryHelper.listFeatureInCategory(BaseFeatureHelper.CACHE_FILES, SystemCleanerHelper.UNINSTALLER, SystemCleanerHelper.LARGE_FILES)},
                {CategoryHelper.CATEGORY_NAME_BATTERY_SAVER,
                        CategoryHelper.BATTERY_SAVER_RESULT_TITLE_BAD,
                        CategoryHelper.BATTERY_SAVER_RESULT_SUBTITLE_BAD,
                        CategoryHelper.CATEGORY_BATTERY_INFO_TITLE,
                        CategoryHelper.CATEGORY_BATTERY_INFO_TEXT,
                        CategoryHelper.CATEGORY_BATTERY_BUTTON_PROLONG,
                        CategoryHelper.listFeatureInCategory(BaseFeatureHelper.MAGIC_STOPPER, BaseFeatureHelper.ENERGY_MODE)},
                {CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER,
                        CategoryHelper.SECURITY_ENHANCER_RESULT_TITLE_NOT_SAFE,
                        CategoryHelper.SECURITY_ENHANCER_RESULT_SUBTITLE_BAD,
                        CategoryHelper.CATEGORY_SECURITY_INFO_TITLE,
                        CategoryHelper.CATEGORY_SECURITY_INFO_TEXT,
                        CategoryHelper.CATEGORY_SECURITY_BUTTON_PROTECT,
                        CategoryHelper.listFeatureInCategory(BaseFeatureHelper.ANTIVIRUS, BaseFeatureHelper.APPLOCKER, BaseFeatureHelper.PHOTO_HIDER)}
        };
    }

    @Test(dataProvider = "categoryData")
    public void testCategories(String categoryName, String resultTitle, String resulSubtitle, String infoTitle, String infoText, String buttonName, ArrayList<String> featureName) throws IOException {
        mainPageHelper.waitScrollDownImage();
        categoryHelper.findCategory(categoryName).click();
        assertEquals(categoryHelper.findToolbarTitle().getText().toString().toUpperCase(), categoryName.toUpperCase(), "Opened wrong architecture.category");
        assertEquals(categoryHelper.findCategoryInfoTitle().getText().toString(), infoTitle, "Incorrect title for architecture.category");
        assertEquals(categoryHelper.findCategoryInfoText().getText().toString(), infoText, "Incorrect info text for architecture.category");
        assertEquals(categoryHelper.findCategoryActionButton().getText().toString(), buttonName, "Incorrect action button name for architecture.category");
        assertEquals(categoryHelper.findCategoryResultTitle().getText().toString(), resultTitle, "Incorrect result title for architecture.category");
        assertEquals(categoryHelper.findCategoryResultSubTitle().getText().toString(), resulSubtitle, "Incorrect result subtitle for architecture.category");

        for (String feature:featureName) {
            assertTrue(categoryHelper.findFeatureName(feature).isDisplayed(), "Feature " + feature + " was not shown in architecture.category " + categoryName);
        }
        assertTrue(categoryHelper.findToolbarToolbarMenu().isDisplayed(), "Toolbox menu icon wasn't shown in the toolbar");
        assertTrue(categoryHelper.findCategoryImage().isDisplayed(), "Category icon wasn't shown");
        assertTrue(categoryHelper.findCategoryImage().isDisplayed(), "Category icon wasn't shown");
    }

    @DataProvider(name = "categoryFeature")
    public static Object[][] categoryFeature() {
        return new Object[][]{
                {CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER, BaseFeatureHelper.MEMORY_CLEANUP, BaseFeatureHelper.MEMORY_CLEAN_UP_NOTE},
                {CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER, BaseFeatureHelper.GAME_BOOSTER, BaseFeatureHelper.GAME_BOOSTER_NOTE},
                {CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER, BaseFeatureHelper.AUTOLAUNCH_APPS, BaseFeatureHelper.AUTOLAUNCHAPP_NOTE},
                {CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER, BaseFeatureHelper.CACHE_FILES, BaseFeatureHelper.CACHE_FILE_NOTE},
                {CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER, SystemCleanerHelper.UNINSTALLER, BaseFeatureHelper.UNINSTALLER_NOTE},
                {CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER, SystemCleanerHelper.LARGE_FILES, null},
                {CategoryHelper.CATEGORY_NAME_BATTERY_SAVER, BaseFeatureHelper.ENERGY_MODE, BaseFeatureHelper.ENERGY_MODE_NOTE},
                {CategoryHelper.CATEGORY_NAME_BATTERY_SAVER, BaseFeatureHelper.MAGIC_STOPPER, BaseFeatureHelper.MAGIC_STOPPER_NOTE},
                {CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER, BaseFeatureHelper.APPLOCKER, BaseFeatureHelper.MAGIC_STOPPER_NOTE},
        };
    }

    @Test(dataProvider = "categoryFeature")
    public void testOpenFeatureFromCategory(String categoryName, String featureName, String featureNote){
        mainPageHelper.waitScrollDownImage();
        categoryHelper.findCategory(categoryName).click();
        categoryHelper.findFeatureName(featureName).isEnabled();
//        if (featureNote != null) {
//            baseFeatureHelper.waitFeatureNote();
//            assertEquals(baseFeatureHelper.findFeatureNote().getText().toString(), featureNote, "Feature note is incorrect for architecture.feature " + featureName);
//        }
    }

    @DataProvider(name = "categoryName")
    public static Object[][] categoryName() {
        return new Object[][]{
                {CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER},
                {CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER},
                {CategoryHelper.CATEGORY_NAME_BATTERY_SAVER},
                {CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER},
        };
    }

    @Test(dataProvider = "categoryName")
    public void testReturnToTheMainPage(String categoryName) {
        mainPageHelper.waitScrollDownImage();
        categoryHelper.findCategory(categoryName).click();
        driver.navigate().back();
        assertEquals(mainPageHelper.findMainToolbarStatus().getText().toString(), SYSTEM_STATUS, "Wrong system status");
    }

    @Test()
    public void testProtectFromCategory() throws IOException {
        assertEquals(categoryPage.getMainToolbarTitle(), SYSTEM_STATUS, "Main screen wasn't opened");
        categoryPage.waitTitleIssues();
        categoryPage.openCategory(SECURITY_ENHANCER);
        assertEquals(categoryPage.getToolbarTitle(), SECURITY_ENHANCER, "Opened wrong architecture.category");
        categoryPage.clickActionCategoryButton(CATEGORY_SECURITY_BUTTON_PROTECT);
        categoryPage.createScreenShots(SECURITY_ENHANCER);
        categoryPage.waitAfterFixState();
        assertEquals(categoryPage.getAfterFixTitle(), TITLE_AFTERFIX_ANTIVIRUS, "Wrong title in after fix state after scanning");
        assertEquals(categoryPage.getAfterFixSubtitle(), SUBTITLE_AFTERFIX_ANTIVIRUS, "Wrong subtitle in after fix state after scanning");
        categoryPage.back();
        categoryPage.openCategory(SECURITY_ENHANCER);
        assertEquals(categoryPage.getCategoryResultTitle(), SECURITY_ENHANCER_TITLE_SAFE, "Wrong title in architecture.category after scanning");
        assertEquals(categoryPage.categoryButtonIsEnable(), false, "Button is presented in architecture.category");
    }

    @Test()
    public void testProlongFromCategory() throws IOException {
        assertEquals(categoryPage.getMainToolbarTitle(), SYSTEM_STATUS, "Main screen wasn't opened");
        categoryPage.waitTitleIssues();
        categoryPage.openCategory(BATTERY_SAVER);
        assertEquals(categoryPage.getToolbarTitle(), BATTERY_SAVER, "Opened wrong architecture.category");
        categoryPage.clickActionCategoryButton(CATEGORY_BATTERY_BUTTON_PROLONG);
        categoryPage.createScreenShots(BATTERY_SAVER);
        categoryPage.waitToolbarTitle();
        assertEquals(categoryPage.getToolbarTitle().toUpperCase(), MAGIC_STOPPER.toUpperCase(), "Opened wrong architecture.category");
    }
}
