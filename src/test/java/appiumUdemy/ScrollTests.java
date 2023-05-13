package appiumUdemy;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static utils.Gestures.scrollUsingGesture;
import static utils.Gestures.scrollUsingUiAutomatorUntilText;

public class ScrollTests extends BaseTest{
    @Test
    public void testScroll(){
        driver.findElement(By.xpath("//*[contains(@text,'Views')]")).click();
//        scrollUsingUiAutomatorUntilText(driver,"WebView");

         scrollUsingGesture(driver,By.xpath("//*[contains(@text,'Grid')]"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
