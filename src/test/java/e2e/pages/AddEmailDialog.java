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
    WebElement emailInputField;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;
    @FindBy(xpath = "//*[@aria-label='Close']")
    WebElement closeWindowsButton;


    public void waitForOpen(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(emailInputField);
        getWait().forClickable(saveButton);
        getWait().forClickable(closeWindowsButton);

    }
    public void setEmailFieldInput(String email){
        emailInputField.sendKeys(email);
    }
    public void saveEmail(){
        try {
            getWait().forClickable(saveButton);
            saveButton.click();
            getWait().forInvisibility(dialog);
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }

    }

}