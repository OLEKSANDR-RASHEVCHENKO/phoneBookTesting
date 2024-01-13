package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class ContactInfoPage extends ContactsPage {
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//class[@name='btn btn-secondary cansel-btn-ec']")
    WebElement canselButton;
    @FindBy(xpath = "//class[@name='btn btn-secondary submit-btn-ec']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@id='contact-first-name']")
    WebElement firstNameField;
    @FindBy(xpath = "//div[@id='contact-last-name']")
    WebElement lastNameField;
    @FindBy(xpath = "//div[@id='contact-description']")
    WebElement descriptionField;
    @FindBy(xpath = "//button[@id='btn-edit-contact']")
    WebElement editButton;

    public String getFirstName(){
        return firstNameField.getText();
    }
    public String getLastName() {
        return lastNameField.getText();
    }
    public String getDescription(){
        return descriptionField.getText();
    }
    public EditContactForm openEditContactForm(){
        editButton.click();
        Assert.assertFalse(isElementDisplayed(firstNameField));;
        return new EditContactForm(driver);
    }


    }
    class EditContactForm extends ContactInfoPage{

        public EditContactForm(WebDriver driver) {
            super(driver);
        }
        @FindBy(xpath = "//input[@name='input-ec-firstName']")
        WebElement firstNameInput;
        @FindBy(xpath = "//input[@name='input-ec-lastName']")
        WebElement lastNameInput;
        @FindBy(xpath = "//input[@name='input-ec-description']")
        WebElement descriptionInput;

        public void setFirstNameInput(String firstName){
            setInput(firstNameInput, firstName);
    }

    }