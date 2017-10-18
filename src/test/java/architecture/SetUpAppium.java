package architecture;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class SetUpAppium {
    private String packageDK = "com.highlyrecommendedapps.droidkeeper";
    private String mainActivity = ".ui.MainActivity";
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("testDeviceName", "Android Emulator");
        //capabilities.setCapability("platformVersion", "7.1.2");

        capabilities.setCapability("appPackage", packageDK);
        capabilities.setCapability("appWaitPackage", packageDK);
        capabilities.setCapability("appActivity", mainActivity);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        initDriver();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    public abstract void initDriver();
}
