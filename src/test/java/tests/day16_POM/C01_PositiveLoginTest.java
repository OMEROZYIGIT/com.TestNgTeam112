package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PositiveLoginTest {

    // 1) go to the "https://www.qualitydemy.com"
    // 2) click login button
    // 3) enter a valid email in emailTextBox (valid email:a@a.com)
    // 4) enter a valid password in passwordTextBox (Az.123123123)
    // 5) click login button
    // 6) test that user could be able to log in

    @Test (groups = {"reg2","smoke"})
    public void test01() {



        // 1) go to the "https://www.qualitydemy.com"
        Driver.getDriver().get("https://www.qualitydemy.com");

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 2) click login button
        qualityDemyPage.logInButton.click();

        // 3) enter a valid email in emailTextBox
        qualityDemyPage.emailTextBox.sendKeys("a@a.com");

        // 4) enter a valid password in passwordTextBox
        qualityDemyPage.passwordTextBox.sendKeys("Az.123123123");

        // 5) click login button
        qualityDemyPage.submit.submit();
        ReusableMethods.waitFor(3);

        // 6) test that user could be able to log in
        Assert.assertTrue(qualityDemyPage.userHomePageMyCourcesButton.isDisplayed());


    }
}
