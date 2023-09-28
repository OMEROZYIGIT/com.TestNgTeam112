package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginTest {

    QualityDemyPage qualityDemyPage ;


    @Test (priority = 1)
    public void invalidEmailTest() {
        qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get("https://www.qualitydemy.com");

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a Invalid email in emailTextBox
        qualityDemyPage.emailTextBox.sendKeys("aaaaa@a.com");

        // 4) enter a valid password in passwordTextBox
        qualityDemyPage.passwordTextBox.sendKeys("Az.123123123");

        // 5) click login button
        qualityDemyPage.submit.submit();
        ReusableMethods.waitFor(3);

        // 6) test that user SHOULD NOT be able to log in
        Assert.assertTrue(qualityDemyPage.enterYourCreateText.isDisplayed());

        Driver.quitDriver();

    }

    @Test (priority = 2)
    public void invalidPasswordTest() {
        qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get("https://www.qualitydemy.com");

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a Invalid email in emailTextBox
        qualityDemyPage.emailTextBox.sendKeys("a@a.com");

        // 4) enter a valid password in passwordTextBox
        qualityDemyPage.passwordTextBox.sendKeys("asdfgh");

        // 5) click login button
        qualityDemyPage.submit.submit();
        ReusableMethods.waitFor(3);

        // 6) test that user SHOULD NOT be able to log in
        Assert.assertTrue(qualityDemyPage.enterYourCreateText.isDisplayed());

        Driver.quitDriver();

    }

    @Test (priority = 3)
    public void invalidEmailAndInpasswordTest() {

        qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get("https://www.qualitydemy.com");

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a Invalid email in emailTextBox
        qualityDemyPage.emailTextBox.sendKeys("aaaaa@a.com");

        // 4) enter a valid password in passwordTextBox
        qualityDemyPage.passwordTextBox.sendKeys("asdfghjkl");

        // 5) click login button
        qualityDemyPage.submit.submit();
        ReusableMethods.waitFor(3);

        // 6) test that user SHOULD NOT be able to log in
        Assert.assertTrue(qualityDemyPage.enterYourCreateText.isDisplayed());

        Driver.quitDriver();

    }
}
