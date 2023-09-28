package tests.day18_HtmlReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] wordsToSearchInAmazon() {

        Object[][] wordsToSearchInAmazonArray = {{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"GPU"}};

        return wordsToSearchInAmazonArray;

    }

    @Test (dataProvider = "wordsToSearchInAmazon")
    public void test01(String wordToSearch) {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.amazonSearchBox.sendKeys(wordToSearch+Keys.ENTER);

        String expectedResultText = wordToSearch;
        String actualResultText = amazonPage.amazonResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultText));

    }
}
