package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualityDemyPage {

    public QualityDemyPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//a[@class='btn btn-sign-in-simple']")
    public WebElement logInButton;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBox;

    // (//button[@type='submit'])[1]
    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='icon']//a[normalize-space()='My courses']")
    public WebElement userHomePageMyCourcesButton;

    @FindBy(xpath = "//p[text()='Provide your valid login credentials']")
    public WebElement enterYourCreateText;






}
