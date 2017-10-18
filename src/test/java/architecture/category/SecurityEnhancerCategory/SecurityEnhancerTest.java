package architecture.category.SecurityEnhancerCategory;

import architecture.afterfixstate.AfterFixHelper;
import architecture.category.CategoryHelper;
import architecture.mainpage.MainPageHelper;
import org.testng.annotations.Test;
import architecture.SetUpAppium;

import static org.testng.Assert.assertEquals;

public class SecurityEnhancerTest extends SetUpAppium {
    private MainPageHelper mainPageHelper;
    private SecurityEnhancerHelper securityEnhancerHelper;
    private AfterFixHelper afterFixHelper;

    public void initDriver() {
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
        assertEquals(securityEnhancerHelper.findCategoryResultTitle().getText().toString(), SecurityEnhancerHelper.SECURITY_ENHANCER_RESULT_TITLE_SAFE, "Incorrect architecture.category result title for architecture.category " + CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER);
        assertEquals(securityEnhancerHelper.findCategoryResultTitle().getText().toString(), SecurityEnhancerHelper.SECURITY_ENHANCER_RESULT_SUBTITLE_SAFE, "Incorrect architecture.category result subtitle for architecture.category " + CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER);
        assertEquals(securityEnhancerHelper.findCategoryActionButton().isDisplayed(), false, "Button is presented after protecting process in architecture.category " + CategoryHelper.CATEGORY_NAME_SECURITY_ENHANCER);
    }
}
