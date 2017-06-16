package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageclass.MainPage;


public class MainPageTest extends SetUpAppium {
    public MainPage mainPage;

    public void initDriver() {
        mainPage = new MainPage(driver);
    }

    @DataProvider(name = "category")
    public static Object[][] categoryData() {
        return new Object[][]{
                {SPEED_BOOSTER},
                {SYSTEM_CLEANER},
                {SECURITY_ENHANCER},
                {BATTERY_SAVER},
        };
    }


    @Test(dataProvider = "category")
    public void testOpenCategory(String categoryName) {
        Assert.assertEquals(mainPage.getMainToolbarTitle(), SYSTEM_STATUS);
        mainPage.waitTitleIssues();
        mainPage.openCategory(categoryName);
        Assert.assertEquals(mainPage.getToolbarTitle(), categoryName);
    }

    @Test
    public void testOpenCooler() {
        Assert.assertEquals(mainPage.getMainToolbarTitle(), SYSTEM_STATUS);
        mainPage.waitTitleIssues();
        mainPage.openCooler();
        Assert.assertEquals(mainPage.getToolbarTitle(), PHONE_COOLER);
    }

    @Test
    public void testOpenScrollBlock() {
        Assert.assertEquals(mainPage.getMainToolbarTitle(), SYSTEM_STATUS);
        mainPage.waitTitleIssues();
        ttr();
        ttr();
        ttr();
        ttr();
        ttr();
        ttr();
        //Assert.assertEquals(mainPage.getToolbarTitle(), PHONE_COOLER);
    }

    public void ttr(){
        mainPage.swipe();
        //mainPage.openScrollBlock();
    }
}
