package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class Gestures {

    public static void longPress(WebDriver driver,By locator){
        WebElement ele = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele ).getId(),
                "duration",2000
        ));
    }

    public static void scrollUsingUiAutomatorUntilText(WebDriver driver,String text){
        String txt  =  "\""+text+"\"";
        driver.findElement(AppiumBy.androidUIAutomator(("new UiScrollable(new UiSelector()).scrollIntoView(text("+txt+"))")));
    }

    public static void scrollUsingGesture(WebDriver driver,By locator){
        // if there is no elementId
        boolean canScrollMore;
        do {

             canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 200, "width", 200, "height", 500,
                    "direction", "down",
                    "percent", 3.0
            ));
            if(driver.findElements(locator).size() > 0){
                canScrollMore = false;
            }
            System.out.println(canScrollMore);
        }while (canScrollMore);

        driver.findElements(locator).get(0).click();
    }
    public static void swipe(WebDriver driver,By locator){
        WebElement ele = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele ).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }


}
