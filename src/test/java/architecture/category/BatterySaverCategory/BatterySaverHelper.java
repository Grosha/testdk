package architecture.category.BatterySaverCategory;

import io.appium.java_client.android.AndroidDriver;
import architecture.category.CategoryHelper;

public class BatterySaverHelper extends CategoryHelper {
    public static String BATTERY_SAVER_RESULT_TITLE_CLEAR = "Good";
    public static String BATTERY_SAVER_RESULT_SUBTITLE_CLEAR = "Nothing to stop";

    public BatterySaverHelper(AndroidDriver driver) {
        super(driver);
    }
}
