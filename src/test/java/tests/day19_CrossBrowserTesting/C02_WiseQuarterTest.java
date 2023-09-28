package tests.day19_CrossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_WiseQuarterTest extends TestBaseCross {

    @Test
    public void test01() {

        driver.get("https://wisequarter.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));
    }
}
