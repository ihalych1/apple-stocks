import configuration.DriverConfig;
import configuration.SystemConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", SystemConfig.getDeviceName());
        capabilities.setBrowserName("Chrome");
        capabilities.setVersion("10");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("chromedriverExecutable", DriverConfig.getDriverBinary());
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.get("https://finance.yahoo.com/");
    }

    @AfterClass
    public void tierDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}