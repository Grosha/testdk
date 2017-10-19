package architecture.category.SecurityEnhancerCategory;

import architecture.afterfixstate.AfterFixHelper;
import architecture.category.CategoryHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class SecurityEnhancerTest extends SetUpAppium {
    private MainPageHelper mainPageHelper;
    private SecurityEnhancerHelper securityEnhancerHelper;
    private AfterFixHelper afterFixHelper;
    private SoftAssert softAssert;

    public void initDriver() {
        softAssert = new SoftAssert();
        mainPageHelper = new MainPageHelper(driver);
        securityEnhancerHelper = new SecurityEnhancerHelper(driver);
        afterFixHelper = new AfterFixHelper(driver);
    }

    @Test
    public void testProtectingFromCategory() {
        mainPageHelper.waitScrollDownImage();
        securityEnhancerHelper.findCategory(CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER).click();
        securityEnhancerHelper.findCategoryActionButton().click();

        afterFixHelper.waitAfterFixState();
        driver.navigate().back();

        mainPageHelper.waitScrollDownImage();
        securityEnhancerHelper.findCategory(CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER).click();

        securityEnhancerHelper.waitCategoryResultTitle();
        softAssert.assertEquals(securityEnhancerHelper.findCategoryResultTitle().getText().toString(), SecurityEnhancerHelper.SECURITY_ENHANCER_RESULT_TITLE_SAFE, "Incorrect architecture.category result title for architecture.category " + CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER);
        softAssert.assertEquals(securityEnhancerHelper.findCategoryResultTitle().getText().toString(), SecurityEnhancerHelper.SECURITY_ENHANCER_RESULT_SUBTITLE_SAFE, "Incorrect architecture.category result subtitle for architecture.category " + CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER);
        softAssert.assertEquals(securityEnhancerHelper.findCategoryActionButton().isDisplayed(), false, "Button is presented after protecting process in architecture.category " + CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER);
        softAssert.assertAll();
    }
}
