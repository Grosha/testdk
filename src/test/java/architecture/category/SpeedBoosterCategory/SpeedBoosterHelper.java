package architecture.category.SpeedBoosterCategory;

import io.appium.java_client.android.AndroidDriver;
import architecture.category.CategoryHelper;

public class SpeedBoosterHelper extends CategoryHelper {
    static String SPEED_BOOSTER_RESULT_TITLE_FAST = "Fast";
    static String SPEED_BOOSTER_RESULT_SUBTITLE_FAST = "Boost id not required";

    public SpeedBoosterHelper(AndroidDriver driver) {
        super(driver);
    }
}
