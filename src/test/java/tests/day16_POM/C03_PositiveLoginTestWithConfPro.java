package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTestWithConfPro {

    // 1) go to the "https://www.qualitydemy.com"
    // 2) click login button
    // 3) enter a valid email in emailTextBox (valid email:a@a.com)
    // 4) enter a valid password in passwordTextBox (Az.123123123)
    // 5) click login button
    // 6) test that user could be able to log in

    @Test
    public void positiveLoginTest() {

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a valid email in emailTextBox (valid email:a@a.com)
        qualityDemyPage.emailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidEmail"));

        // 4) enter a valid password in passwordTextBox (Az.123123123)
        qualityDemyPage.passwordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidPassword"));

        // 5) click login button
        qualityDemyPage.submit.submit();

        // 6) test that user could be able to log in
        Assert.assertTrue(qualityDemyPage.userHomePageMyCourcesButton.isDisplayed());

        Driver.closeDriver();

    }
}
