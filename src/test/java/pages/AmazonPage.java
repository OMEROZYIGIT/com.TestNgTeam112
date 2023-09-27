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

    @FindBy(xpath = "//div[@class='sg-col-4-of-24 sg-col-3-of-12 sg-col-4-of-16 sg-col s-breadcrumb sg-col-4-of-20']")
    public WebElement amazonResultText;

}
