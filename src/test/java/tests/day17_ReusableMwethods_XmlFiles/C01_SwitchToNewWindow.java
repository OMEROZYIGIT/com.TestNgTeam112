package tests.day17_ReusableMwethods_XmlFiles;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SwitchToNewWindow {
    // go to the https://the-internet.herokuapp.com/iframe
    // click on an elemental selenium link
    // title of the new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
    // switch to new tab


    @Test
    public void test01() {

        // go to the https://the-internet.herokuapp.com/iframe
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // click on an elemental selenium link
        Driver.getDriver().findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        // the title of the new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro
        ReusableMethods.switchToWindow("elementalselenium");

        String expectedText = "Make sure your code lands";
        String actualText = Driver.getDriver().findElement(By.xpath("//h1[@class='home-header']")).getText();

        Assert.assertEquals(actualText,expectedText);

        Driver.closeDriver();
    }
}
