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
    WebElement addPhoneButton;

    public void waitForLoading(){
        getWait().forVisibility(searchInput);
        getWait().forVisibility(addPhoneButton);

    }

}

