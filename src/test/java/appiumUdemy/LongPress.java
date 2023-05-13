package appiumUdemy;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Gestures.longPress;

public class LongPress extends BaseTest{

    @Test
    public void longPressGesture(){
        driver.findElement(By.xpath("//*[contains(@text,'Views')]")).click();
        driver.findElement(By.xpath("//*[contains(@text,'Expandable Lists')]")).click();
        driver.findElement(By.xpath("(//*[contains(@text,'1. Custom Adapter')])[1]")).click();

        longPress(driver,By.xpath("//*[contains(@text,'People Names')]"));

        WebElement pop1Txt = driver.findElement(By.xpath("//*[contains(@text,'Sample menu')]"));
        assertTrue(pop1Txt.isDisplayed());
        String pop2Txt  = driver.findElement(By.xpath("//*[contains(@text,'Sample action')]")).getText();
        assertEquals(pop2Txt,"Sample action");
    }
}
