package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddContactDialog extends ContactsPage{
    public AddContactDialog(WebDriver driver) {
        super(driver);
    }
    // Describe locator
    @FindBy(xpath = "//*[@role='dialog']")
    WebElement dialog;

    @FindBy(xpath = "//*[@id='form-name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='form-lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='form-about']")
    WebElement descriptiontInput;

    @FindBy(xpath = "//*[@type='reset']")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "//*[@aria-label='Close']")
    WebElement closeWindowsButton;

    @FindBy(xpath = "//*[@id='form-error-firstName']")
    WebElement errorMessage;

    public void setFirstNameInput(String firstName){
        setInput(firstNameInput, firstName);// заменяет 3 строки внизу

        //firstNameInput.click(); //кликнуть -доступен для ввода
        //firstNameInput.clear();
        //firstNameInput.sendKeys(firstName);// ввод значения в инпут

    }
    public  void setLastNameInput(String lastName){
        setInput(lastNameInput, lastName);

        //lastNameInput.click();
        //lastNameInput.clear();
        //lastNameInput.sendKeys(lastName);

    }

    public void setDescription(String description){
        setInput(descriptiontInput, description);

        //descriptiontInput.click();
        //descriptiontInput.clear();
        //descriptiontInput.sendKeys(description);

    }
    public  void setAddContactForm(String firstName,String lastName, String description){
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setDescription(description);
    }
    public void SaveContact(){
        saveButton.click();
        Assert.assertFalse(isElementDisplayed(dialog), "Dialog is not closed");
    }

}
