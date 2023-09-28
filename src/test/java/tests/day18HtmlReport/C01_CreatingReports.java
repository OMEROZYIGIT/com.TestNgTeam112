package tests.day18HtmlReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_CreatingReports extends TestBaseRapor {

    @Test
    public void testName() {

        extentTest = extentReports.createTest("Amazon Nutella Test","User should be able to search for Nutella");

        // 1) go to the amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("User reached the website (amazon)");
        ReusableMethods.waitFor(1);

        // 2) Search for Nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys(ConfigReader.getProperty("amazonSearchBoxKey1")+ Keys.ENTER);
        extentTest.info("User searched for Nutella in amazon");
        ReusableMethods.waitFor(2);

        // 3) Test that result text has nutella
        String expectedWord = ConfigReader.getProperty("amazonSearchBoxKey1");
        String actualResultText = amazonPage.amazonResultText.getText();
        extentTest.info("System saved result text");
        Assert.assertTrue(actualResultText.contains(expectedWord));
        extentTest.pass("Tested that result text contains the word");
        ReusableMethods.waitFor(1);



    }
}
