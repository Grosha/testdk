package testclass;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class SetUpAppium implements Variable {
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability("platformVersion", "7.1.2");

        capabilities.setCapability("appPackage", Variable.packageDK);
        capabilities.setCapability("appWaitPackage", Variable.packageDK);
        capabilities.setCapability("appActivity", Variable.mainActivity);
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
