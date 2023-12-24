package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPhone extends PhoneInfoPage{
    public EditPhone(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='cc-select']")
    WebElement countryCodeDropdown;
    @FindBy(xpath = "//*[@id='selected-cc']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;

    public void waitForLoading(){
        getWait().forVisibility(countryCodeDropdown);
        getWait().forVisibility(phoneNumberInput);
        getWait().forVisibility(saveButton);
    }

    public void selectCountryCode(String country){
        getSelect(countryCodeDropdown).selectByVisibleText(country);
    }
    public void setPhoneNumber(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
    }
    public void clickOnSaveButton(){
        saveButton.click();
    }


}
