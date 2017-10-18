package architecture.category.SpeedBoosterCategory;

import architecture.category.CategoryHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;

import static org.testng.Assert.assertEquals;

public class SpeedBoosterTest extends SetUpAppium {
    private MainPageHelper mainPageHelper;
    private SpeedBoosterHelper speedBoosterHelper;

    public void initDriver() {
        mainPageHelper = new MainPageHelper(driver);
        speedBoosterHelper = new SpeedBoosterHelper(driver);
    }

    @Test
    public void testBoostingFromCategory() {
        mainPageHelper.waitScrollDownImage();
        speedBoosterHelper.findCategory(CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER).click();
        speedBoosterHelper.findCategoryActionButton().click();
        speedBoosterHelper.waitCategoryResultTitle();
        assertEquals(speedBoosterHelper.findCategoryResultTitle().getText().toString(), SpeedBoosterHelper.SPEED_BOOSTER_RESULT_TITLE_FAST, "Incorrect architecture.category result title for architecture.category " + CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER);
        assertEquals(speedBoosterHelper.findCategoryResultTitle().getText().toString(), SpeedBoosterHelper.SPEED_BOOSTER_RESULT_SUBTITLE_FAST, "Incorrect architecture.category result subtitle for architecture.category " + CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER);
        assertEquals(speedBoosterHelper.findCategoryActionButton().isDisplayed(), false, "Button is presented after boosting process in architecture.category " + CategoryHelper.CATEGORY_NAME_SPEED_BOOSTER);
    }
}
