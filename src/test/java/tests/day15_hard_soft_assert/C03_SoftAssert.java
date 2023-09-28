package tests.day15_hard_soft_assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SoftAssert {

    @Test (groups = "reg2")
    public void test01() {

        // go to https://www.amazon.com
        // verify that you are in amazon.com
        // search for nutella and click on the first product
        // verified that you searched for nutella
        // search for java
        // verify that there is a more than 1000-result
        // close driver

        // go to https://www.amazon.com
        Driver.getDriver().get("https://www.amazon.com");

        // verify that you are in amazon.com
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl));

        // search for nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("nutella"+ Keys.ENTER);

        // and click on the first product
//        amazonPage.firstProductOfSearch.click();
//        String actualTitle = amazonPage.productTitle.getText();
//        System.out.println(actualTitle);
//        String expectedTitleWord = "Nutella";
//        softAssert.assertTrue(actualTitle.contains(expectedTitleWord));

        // verified that you searched for nutella
        String expectedResultText = "nutella";
        String actualResultText = amazonPage.amazonResultText.getText();
        System.out.println(actualResultText);                                   // 1-48 of 785 results for "nutella"
        softAssert.assertTrue(actualResultText.contains(expectedResultText));

        // search for java
        amazonPage.amazonSearchBox.clear();
        amazonPage.amazonSearchBox.sendKeys("Java"+Keys.ENTER);

        // verify that there is a more than 1000-result
        String actualResultTextForJava = amazonPage.amazonResultText.getText();
        System.out.println(actualResultTextForJava);                            // 1-48 of over 5,000 results for "Java"
        String[] arr = actualResultTextForJava.split(" ");
        String numberStr = arr[3].replaceAll(",","");
        System.out.println(numberStr);
        int resultNumber = Integer.valueOf(numberStr);

        softAssert.assertTrue(resultNumber>1000);

        softAssert.assertAll();

        ReusableMethods.waitFor(3);

        Driver.closeDriver();

    }
}
