package tests.day01;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_NutellaTest {

    @Test
    public void test01() {

        Driver.getDriver().get("https://www.amazon.com");

        // search for nutella 50 times
        // to reach any variable from AmazonPage Class, we need to create an object from that class
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        // test that result has nutella
        String expectedResultWord ="Nutella";
        String actualResultText = amazonPage.amazonResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultWord));


        Driver.closeDriver();

    }
}
