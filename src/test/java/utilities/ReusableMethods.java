package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class ReusableMethods {


    public static void waitFor(int second) {

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name)throws IOException{
        //naming the screenshot with current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
        // take Screenshot is an interface of selenium that takes screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir")+"/target/Screenshots"+name+date+".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source,finalDestination);
        return target;
    }

    //===========Switching Window======//
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle:Driver.getDriver().getWindowHandles()
             ) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        // Driver.getDriver().switchTo().window(origin);
    }
    //============Hover Over============//
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //============Return a list of String given a list of WebElement=======//
    public static List<String> getElementText(List<WebElement> list){
        List<String> elementTexts = new ArrayList<>();
        for (WebElement eachElement: list
             ) {
            if (!eachElement.getText().isEmpty()){
                elementTexts.add(eachElement.getText());
            }
        }
        return elementTexts;
    }

    //========Returns the Text of the element given an element locator====//
    public static List<String> getElementsText(By locator){
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el:elems
             ) {
            if (!el.getText().isEmpty()){
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //===========Explicit Wait ===============//
    public static WebElement waitForVisibility (WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility (By locator,int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickability (WebElement element,int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickability (By locator,int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element,int timeout){
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            }catch (WebDriverException e){
                waitFor(1);
            }
        }
    }
}
