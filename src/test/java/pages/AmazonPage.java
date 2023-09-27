package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // we will locate our web-elements in this class and use them we will call then from here
    // to use a page class we need to create a constructor without any parameter

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement amazonResultText;

    @FindBy (xpath = "(//div[@class='sg-col-inner'])[8]")
    public WebElement firstProductOfSearch;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement productTitle;

}
