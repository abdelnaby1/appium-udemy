package appiumUdemy;

import appiumUdemy.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest extends BaseTest {

   @Test
    public void firstTest()   {
       driver.findElement(By.xpath("//*[contains(@text,'Preference')]")).click();
       driver.findElement(By.xpath("(//*[contains(@text,'3. Preference dependencies')])[1]")).click();
       WebElement wifiSettingBtn = driver.findElement(By.xpath("//*[contains(@text,'WiFi settings')]"));
       if(!wifiSettingBtn.isEnabled()){
           driver.findElement(By.id("android:id/checkbox")).click();
       }
       wifiSettingBtn.click();
       WebDriverWait wait = new WebDriverWait((AppiumDriver)driver, Duration.ofSeconds(20));
       WebElement ele =  driver.findElement(By.id("android:id/edit"));
       wait.until(ExpectedConditions.visibilityOf(ele));
      ele.sendKeys("Ahmed");
       driver.findElement(By.id("android:id/button1")).click();
   }

}
