import org.testng.annotations.Test;

public class DrawerTest extends SetUpAppium{
    public BasePage page = new BasePage(driver);

    @Test
    public void openFeatureThroughDrawer(){
        page.openDrawer();
        page.openFeatureFromDrawer(CACHE_FILES);
    }
}
