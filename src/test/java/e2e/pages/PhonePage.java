package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonePage extends ContactInfoPage{
    public PhonePage(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath = "/*[@type='text']")
    WebElement searchLabel;
    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addPhoneNumber;
    @FindBy(xpath = "//*[@id='cc-select']")
    WebElement countryCode;
    @FindBy(xpath = "//*[@for='selected-cc']")
    WebElement phoneNumber;
    @FindBy(xpath = "//*[@id='selected-cc']")
    WebElement phoneNumberField;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement saveButton;//*[@for='search']/

}
