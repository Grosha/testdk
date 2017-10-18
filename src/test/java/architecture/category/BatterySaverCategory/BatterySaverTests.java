package architecture.category.BatterySaverCategory;

import architecture.category.CategoryHelper;
import architecture.feature.BaseFeatureHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;

import static org.testng.Assert.assertEquals;

public class BatterySaverTests extends SetUpAppium {
    private MainPageHelper mainPageHelper;
    private BatterySaverHelper  batterySaverHelper;
    private BaseFeatureHelper featureHelper;

    public void initDriver() {
        mainPageHelper = new MainPageHelper(driver);
        batterySaverHelper = new BatterySaverHelper(driver);
        featureHelper = new BaseFeatureHelper(driver);
    }

    @Test
    public void testProlongBatteryFromCategory(){
        mainPageHelper.waitScrollDownImage();
        batterySaverHelper.findCategory(CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER).click();
        batterySaverHelper.findCategoryActionButton().click();

        //opened magic stopper architecture.feature
        assertEquals(featureHelper.findToolbarTitle().getText().toString(), BaseFeatureHelper.MAGIC_STOPPER, "Incorrect architecture.feature name in toolbar");
    }
}
