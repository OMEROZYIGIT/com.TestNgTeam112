package tests.day19_CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AmazonNutellaTest extends TestBaseCross {

    @Test
    public void test01() {

        driver.get(ConfigReader.getProperty("amazonUrl"));

        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement amazonResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResultText = amazonResultText.getText();
        String expectedResultText = "Nutella";

        Assert.assertTrue(actualResultText.contains(expectedResultText));


    }
}
