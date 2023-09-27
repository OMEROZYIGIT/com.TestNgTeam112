package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTestWithConfPro {

    @Test
    public void invalidEmailAndvalidPasswordLoginTest() {

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a valid email in emailTextBox (valid email:a@a.com)
        qualityDemyPage.emailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidEmail"));

        // 4) enter a valid password in passwordTextBox (Az.123123123)
        qualityDemyPage.passwordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidPassword"));

        // 5) click login button
        qualityDemyPage.submit.submit();

        // 6) test that user SHOULD NOT able to log in
        Assert.assertTrue(qualityDemyPage.enterYourCreateText.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void validEmailAndInvalidPasswordLoginTest() {

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a valid email in emailTextBox (valid email:a@a.com)
        qualityDemyPage.emailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidEmail"));

        // 4) enter a valid password in passwordTextBox (Az.123123123)
        qualityDemyPage.passwordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidPassword"));

        // 5) click login button
        qualityDemyPage.submit.submit();

        // 6) test that user SHOULD NOT able to log in
        Assert.assertTrue(qualityDemyPage.enterYourCreateText.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void invalidEmailAndInvalidPasswordLoginTest() {
        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a valid email in emailTextBox (valid email:a@a.com)
        qualityDemyPage.emailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidEmail"));

        // 4) enter a valid password in passwordTextBox (Az.123123123)
        qualityDemyPage.passwordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidPassword"));

        // 5) click login button
        qualityDemyPage.submit.submit();

        // 6) test that user SHOULD NOT able to log in
        Assert.assertTrue(qualityDemyPage.enterYourCreateText.isDisplayed());

        Driver.closeDriver();

    }
}
