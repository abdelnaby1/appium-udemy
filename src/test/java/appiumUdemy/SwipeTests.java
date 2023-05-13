package appiumUdemy;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static utils.Gestures.scrollUsingUiAutomatorUntilText;
import static utils.Gestures.swipe;

public class SwipeTests extends BaseTest{
    @Test
    public void testSwipe(){
        driver.findElement(By.xpath("//*[contains(@text,'Views')]")).click();
        scrollUsingUiAutomatorUntilText(driver,"Gallery");
        driver.findElement(By.xpath("//*[contains(@text,'Gallery')]")).click();
        driver.findElement(By.xpath("//*[contains(@text,'1. Photos')]")).click();
        By imgLoc = By.xpath("(//*[contains(@resource-id,'com.hmh.api:id/gallery')]//*[contains(@class,'android.widget.ImageView')])[1]");
        assertEquals(driver.findElement(imgLoc).getAttribute("focusable"),"true");
        swipe(driver,imgLoc);
        assertEquals(driver.findElement(imgLoc).getAttribute("focusable"),"false");

    }
}
