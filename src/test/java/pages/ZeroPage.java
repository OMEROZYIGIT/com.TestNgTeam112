package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (id = "signin_button")
    public WebElement signInButtom;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement login;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    //span[@id='pay_bills_link']
    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBills;

    @FindBy(xpath = "//li[@class='ui-state-default ui-corner-top'][2]")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement CurrencyDropdownButton;




}
