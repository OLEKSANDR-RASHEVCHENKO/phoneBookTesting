package e2e.pages;

import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPhoneDialog extends PhonesPage {
    public AddPhoneDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='cc-select']")
    WebElement countryCode;

    @FindBy(xpath = "//*[@for='selected-cc']")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id='selected-cc']")
    WebElement phoneNumberField;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement saveButton;

    public void waitForOpen() {
        getWait().forVisibility(countryCode);
        getWait().forVisibility(phoneNumber);
        getWait().forVisibility(phoneNumberField);
        getWait().forVisibility(saveButton);
    }

    public void selectCountryCode(String country) {
        getSelect(countryCode).selectByVisibleText(country);
    }

    public String getLCountry() {
        return getSelect(countryCode).getFirstSelectedOption().getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public void setPhoneNumber(WebElement input, String value) {
        input.click();
        input.clear();
        input.sendKeys(value);
    }
    public void savePhone() throws InterruptedException {
        saveButton.click();
        getWait().forInvisibility(saveButton);
    }
}