package e2e.pages;

import e2e.enums.ContactInfoTabs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends ContactInfoPage{
    //import constructor!!!
    public EmailPage(WebDriver driver) {
        super(driver);
    }

    // Describe locator
    @FindBy(xpath = "//*[@id='search']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addEmailButton;

    @FindBy(xpath = "//*[@id='input-email']")
    WebElement emailField;


    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;

    public void waitForLoading(){
        getWait().forVisibility(searchInput);
        getWait().forVisibility(addEmailButton);
        getWait().forVisibility(emailField);
        getWait().forVisibility(saveButton);


    }

}
