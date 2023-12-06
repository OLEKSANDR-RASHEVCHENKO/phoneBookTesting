package e2e.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmailDialog extends EmailPage {
    public AddEmailDialog(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[@role='dialog']")
    WebElement dialog;

    @FindBy(xpath = "//*[@id='input-email']")
    WebElement addEmailButton;



    @FindBy(xpath = "//*[@id='input-email']")
    WebElement emailInput;


    public void waitForOpen(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(addEmailButton);
        getWait().forVisibility(emailInput);
        getWait().forVisibility(saveButton);

    }

    public void setAddEmailButton(String addEmailButton){
        setInput(addEmailButton);
    }

    public void setLastNameInput(String lastName){
        setInput(lastNameInput, lastName);
    }

    public void setDescription(String description){
        setInput(descriptionInput, description);
    }

    public void setAddContactForm(String firstName, String lastName, String description){
        setAddEmailButton(addEmailButton);
        setLastNameInput(lastName);
        setDescription(description);
    }

    public void saveContact(){
        try {
            getWait().forClickable(saveButton);
            saveButton.click();
            getWait().forInvisibility(dialog);
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }

    }

}
