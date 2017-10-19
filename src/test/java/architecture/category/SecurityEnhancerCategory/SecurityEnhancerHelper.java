package architecture.category.SecurityEnhancerCategory;

import io.appium.java_client.android.AndroidDriver;
import architecture.category.CategoryHelper;

public class SecurityEnhancerHelper extends CategoryHelper {

    public static String SECURITY_ENHANCER_RESULT_TITLE_SAFE = "Safe";
    public static String SECURITY_ENHANCER_RESULT_SUBTITLE_SAFE = "Nothing to protect";

    public SecurityEnhancerHelper(AndroidDriver driver) {
        super(driver);
    }

}
