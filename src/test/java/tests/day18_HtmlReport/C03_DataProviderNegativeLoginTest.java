package tests.day18_HtmlReport;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderNegativeLoginTest {
    @DataProvider
    public static Object[][] provideUsernameAndPassword() {
        Object[][] usernameAndPassword = {{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};

        return usernameAndPassword;

    }

    // 1) go to QualityDemy homepage
    // 2) enter the wrong password and username
    // 3) test that user cannot log in
    /*
    username  password
    A11         A12345
    B12         B12345
    C13         C12345
    D14         D12345
    E15         E12345

     */

    @Test (dataProvider = "provideUsernameAndPassword")
    public void test01(String username,String password) {

        // 1) go to QualityDemy homepage
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) enter the wrong password and username
        QualityDemyPage qualityDemyPage = new QualityDemyPage();
        qualityDemyPage.logInButton.click();
        qualityDemyPage.emailTextBox.sendKeys(username);
        qualityDemyPage.passwordTextBox.sendKeys(password);
        qualityDemyPage.submit.submit();

        String actualText = qualityDemyPage.enterYourCreateText.getText();
        String expectedText = "Provide your valid login credentials";

        Assert.assertEquals(actualText,expectedText);




    }
}
