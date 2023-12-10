package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

public class AddPhoneDialog extends PhonesPage{
    public AddPhoneDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//@for='cc-select']")
    WebElement countryCodeLabel;
    @FindBy(xpath = "//*[@id='cc-select']")
    WebElement countryCodeDropDown;
    @FindBy(xpath = "//*for='selected-cc]")
    WebElement phoneNumberField;
    @FindBy(xpath = "//@id='selected-cc']")
    WebElement phoneNumberInput;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement saveButton;

    public void waitForOpen(){
        getWait().forVisibility(countryCodeLabel);
        getWait().forVisibility(countryCodeDropDown);
        getWait().forVisibility(phoneNumberField);
        getWait().forVisibility(phoneNumberInput);
        getWait().forVisibility(saveButton);
    }

    public void setCountryCode(String country){
        getSelect(countryCodeDropDown).selectByVisibleText(country);
    }



}
