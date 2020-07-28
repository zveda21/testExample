package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    AppiumDriver<MobileElement> driver;

    public static DesiredCapabilities myCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A50");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 999);
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\zveda.hayrapetyan\\Desktop\\casino-vivarobet.apk");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        return capabilities;
    }

    @Test
    public void test() {


        try {

            URL local = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<>(local, myCapabilities());

            System.out.println("Session start");
            waitSeconds(5);

            // driver.findElement(MobileBy.AndroidUIAutomator("Text(\"Բացել\")")).click();
            //     driver.findElement(By.id("sign_in")).click();
            System.out.println("Find element");


            driver.quit();
            System.out.println("Session end");


        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
