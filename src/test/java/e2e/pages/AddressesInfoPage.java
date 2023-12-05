package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddressesInfoPage extends ContactInfoPage {


    public AddressesInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='search']")
    WebElement searchInput;
    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addAddressButton;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closeButton;
    @FindBy(xpath = "//*[@class='dropdown-toggle btn btn-outline-light btn-block']")
    WebElement optionDropDown;



    public void waitForLoading() {
        //getWait().forVisibility(searchInput);
        getWait().forVisibility(addAddressButton);
        getWait().forVisibility(closeButton);
        getWait().forVisibility(optionDropDown);
    }
    public void clickOnAddressButton(){
        addAddressButton.click();
    }
}
