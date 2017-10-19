package architecture.category.SystemCleanerCategory;

import architecture.category.CategoryHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;
import org.testng.asserts.SoftAssert;

public class SystemCleanerTest extends SetUpAppium {
    private SystemCleanerHelper systemCleanerHelper;
    private MainPageHelper mainPageHelper;
    private SoftAssert softAssert;

    public void initDriver() {
        mainPageHelper = new MainPageHelper(driver);
        systemCleanerHelper = new SystemCleanerHelper(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void testCleaningFromCategory() {
        mainPageHelper.waitScrollDownImage();
        systemCleanerHelper.findCategory(CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER).click();
        systemCleanerHelper.findCategoryActionButton().click();
        systemCleanerHelper.waitCategoryResultTitle();
        softAssert.assertEquals(systemCleanerHelper.findCategoryResultTitle().getText().toString(), SystemCleanerHelper.SYSTEM_CLEANER_RESULT_TITLE_CLEAR, "Incorrect architecture.category result title for architecture.category " + CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER);
        softAssert.assertEquals(systemCleanerHelper.findCategoryResultTitle().getText().toString(), SystemCleanerHelper.SYSTEM_CLEANER_RESULT_SUBTITLE_CLEAR, "Incorrect architecture.category result subtitle for architecture.category " + CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER);
        softAssert.assertEquals(systemCleanerHelper.findCategoryActionButton().isDisplayed(), false, "Button is presented after cleaning process in architecture.category " + CategoryHelper.CATEGORY_NAME_SYSTEM_CLEANER);
        softAssert.assertAll();
    }
}
