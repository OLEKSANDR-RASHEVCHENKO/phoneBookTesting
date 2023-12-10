package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesPage extends ContactInfoPage{
    public PhonesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@formcontrolname='searchInput']")
    WebElement searchInput;
    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addPhoneNumber;
    @FindBy(xpath = "//*[@id='cc-select']")
    WebElement countrySelect;
    @FindBy(xpath = "//*[@formcontrolname='phoneNumber']")
    WebElement phoneNumberField;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;


    public void waitForLoading(){
        getWait().forVisibility(searchInput);
        getWait().forVisibility(addPhoneNumber);
    }




}