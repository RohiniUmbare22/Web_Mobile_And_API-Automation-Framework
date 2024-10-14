package framework;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class MobileBaseTest {
    public static Map<String, String> getConfigMAP() {
        try {
            String path = System.getProperty("user.dir") + "/config.Properties";
            File config = new File(path);
            FileInputStream input;
            input = new FileInputStream(config.getAbsolutePath());
            Properties prop = new Properties();
            prop.load(input);
            Map<String, String> properties = new HashMap<>();
            for (Object key : prop.keySet()) {
                properties.put(key.toString(), prop.getProperty(key.toString()));
            }
            input.close();
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String randomAlphaNumeric()
    {
        return RandomStringUtils.randomAlphanumeric(7);
    }

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver getDriver() throws MalformedURLException {

        String device = getConfigMAP().get("device_name");
        switch (device) {
            case "Android":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appium:udid", "emulator-5554");
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                capabilities.setCapability("appium:appPackage", "info.testingdaily");
                capabilities.setCapability("appium:appActivity", "info.testingdaily.MainActivity");
                capabilities.setCapability("autoGrantPermissions", true);
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"),capabilities);
                break;
        }

        return driver;
    }


    public static void waitForMilliSeconds(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
