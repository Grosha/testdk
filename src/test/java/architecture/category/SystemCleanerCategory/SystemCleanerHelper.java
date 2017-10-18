package architecture.category.SystemCleanerCategory;

import io.appium.java_client.android.AndroidDriver;
import architecture.category.CategoryHelper;

public class SystemCleanerHelper extends CategoryHelper {
    public SystemCleanerHelper(AndroidDriver driver) {
        super(driver);
    }

    public static String UNINSTALLER = "Uninstaller";
    public static String LARGE_FILES = "Large files";
    public static String SYSTEM_CLEANER_RESULT_TITLE_CLEAR = "Clear";
    public static String SYSTEM_CLEANER_RESULT_SUBTITLE_CLEAR = "Nothing to clean";
}
