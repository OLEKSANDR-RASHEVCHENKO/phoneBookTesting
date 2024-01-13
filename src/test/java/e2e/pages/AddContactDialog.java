package e2e.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddContactDialog extends ContactsPage {
    public AddContactDialog(WebDriver driver) {
        super(driver);
    }


        @FindBy(xpath = "//*[@role='dialog']")
        WebElement dialog;

        @FindBy(xpath = "//*[@href='/contacts']")
        WebElement addContactButton;

        @FindBy(xpath = "//*[@id='form-name']")
        WebElement firstNameInput;

        @FindBy(xpath = "//*[@id='form-lastName']")
        WebElement lastNameInput;

        @FindBy(xpath = "//*[@id='form-about']")
        WebElement descriptionInput;

        @FindBy(xpath = "//*[@type='reset']")
        WebElement resetAddContact;

        @FindBy(xpath = "//*[@class='btn btn-primary']")
        WebElement submitAddContact;

        @FindBy(xpath = "//*[@aria-label='Close']")
        WebElement closeAddContact;

        @FindBy(xpath = "//*[@type='danger']")
        WebElement dangerAddContact;



        public void setFirstNameInput(String firstName){
            setInput(firstNameInput, firstName);
        }


        public void setLastNameInput(String lastName){
            setInput(lastNameInput, lastName);
        }

        public void setDescriptionContact(String description){
            setInput(descriptionInput, description);
        }

        public void setAddContactForm(String firstName, String lastName, String description){
            setFirstNameInput(firstName);
            setLastNameInput(lastName);
            setDescriptionContact(description);
    }

        public void clickOnSaveButton(){
            submitAddContact.click();
            Assert.assertFalse(isElementDisplayed(dialog), "Dialog is not closed");
        }

    }

