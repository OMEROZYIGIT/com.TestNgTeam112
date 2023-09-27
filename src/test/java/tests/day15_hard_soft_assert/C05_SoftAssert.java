package tests.day15_hard_soft_assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C05_SoftAssert {

    // Create a New Class: C03_SoftAssert
    // 1. Go to “http://zero.webappsecurity.com/”
    // 2. Press Sign-in button
    // 3. Type “username” in login box
    // 4. Type “password” in the Password box
    // 5. Press Sign-in button
    // 6. Go to the Pay Bills page in the online banking menu
    // 7. Press the “Purchase Foreign Currency” key
    // 8. Select Eurozone from “Currency” drop down menu
    // 9. Test that "Eurozone (euro)" is selected using soft assert
    // 10.Test that the DropDown list has these options using soft assert "Select One",
    //"Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark
    //(krone) ","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan
    //(yen)","Mexico (peso)","Norway (krone)","New Zealand ( dollar)","Sweden
    //(krona)","Singapore (dollar)","Thailand (


    @Test
    public void test01() {

        // 1. Go to “http://zero.webappsecurity.com/”
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // 2. Press Sign-in button
        ZeroPage zeroPage = new ZeroPage();
        zeroPage.signInButtom.click();

        // 3. Type “username” in the login box
        zeroPage.login.sendKeys("username");

        // 4. Type “password” in the Password box
        zeroPage.password.sendKeys("password");

        // 5. Press Sign-in button
        zeroPage.submit.click();
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().navigate().back();

        // 6. Go to the Pay Bills page in the online banking menu
        zeroPage.onlineBankingMenu.click();
        zeroPage.payBills.click();

        // 7. Press the “Purchase Foreign Currency” key
        zeroPage.purchaseForeignCurrency.click();

        // 8. Select Eurozone from “Currency” drop down menu
        Select select =new Select(zeroPage.CurrencyDropdownButton);
        select.selectByValue("EUR");

        // 9. Test that "Eurozone (euro)" is selected using soft assert
        SoftAssert softAssert = new SoftAssert();

        // 10.Test that the DropDown list has these options using soft assert
        /*
        "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark
        (krone) ","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan
        (yen)","Mexico (peso)","Norway (krone)","New Zealand ( dollar)","Sweden
        (krona)","Singapore (dollar)","Thailand (baht)"
         */
        List<WebElement> listOfDropDownOptions = select.getOptions();
        List<String> actualOptionsList = new ArrayList<>();
        String textOfEachWebElement;
        for (WebElement eachOptionText:listOfDropDownOptions
             ) {
            textOfEachWebElement = eachOptionText.getText();
            actualOptionsList.add(textOfEachWebElement);
        }
        String[] arr = {"Select One","Australia (dollar)","Canada (dollar)","Switzerland (franc)",
                        "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                        "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                        "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedListOptionList = Arrays.asList(arr);

        softAssert.assertEquals(actualOptionsList,expectedListOptionList);


        softAssert.assertAll();

    }
}
