package appiumUdemy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;
//    AppiumDriverLocalService builder
    @BeforeClass
    public void configureAppium(){
// start appium server programmatically
        // through AppiumServiceBuilder
//
//        String pathToAppium = "/usr/local/lib/node_modules/appium/build/lib/main.js";
//        AppiumDriverLocalService builder = new AppiumServiceBuilder().withAppiumJS(new File(pathToAppium))
//                .withIPAddress("0.0.0.0")
//                .usingPort(4723)
//                .build();
//        builder.start();

        UiAutomator2Options options  = new UiAutomator2Options();
        options.setApp("/Users/developer/intellij/appium-udemy/apps/API Demos_4.0_apkcombo.com.apk");
        options.setDeviceName("Pixel 3a API 31");
        options.setPlatformVersion("12.0");
        options.setAutoGrantPermissions(true);
        options.setFullReset(true);
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[contains(@text,'OK')]")).click();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
        // stop appium server programmatically
        // builder.stop();
    }
}
