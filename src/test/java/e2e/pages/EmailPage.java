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


    @FindBy(xpath = "//*[@id='search']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addEmailButton;
    @FindBy(xpath = "//*[@class='row-table w-95']")
    WebElement emailField;
    @FindBy(xpath = "//*[@class='dropdown-toggle btn btn-outline-light btn-block']")
    WebElement optionDropDown;



    public void waitForLoading(){
        getWait().forVisibility(searchInput);
        getWait().forClickable(addEmailButton);
        getWait().forVisibility(emailField);
        getWait().forVisibility(optionDropDown);
    }

    public void clickOnAddEmailButton(){
        addEmailButton.click();
    }
    public String getEmail(){
        return emailField.getText();
    }
    public void clickOnDropdownButtonEdit(String edit){
        getSelect(optionDropDown).selectByVisibleText(edit);
    }
    public void clickOnDropdownButtonDelete(String remove){
        getSelect(optionDropDown).selectByVisibleText(remove);
    }
}