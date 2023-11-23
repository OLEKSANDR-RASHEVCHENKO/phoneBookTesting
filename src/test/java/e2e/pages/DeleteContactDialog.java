package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeleteContactDialog extends ContactsPage{
    public DeleteContactDialog(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@role='dialog']")
    WebElement dialog;
    @FindBy(xpath = "//*[@id='check-box-remove-contact']")
    WebElement confirmDeleteCheckbox;
    @FindBy(xpath = "//*[@id='submit-remove']")
    WebElement removedContactButton;

    public void setConfirmDeletion(){
        Assert.assertTrue(isElementDisplayed(dialog));
        confirmDeleteCheckbox.click();
    }
    public void removeContact(){
        removedContactButton.click();
        Assert.assertFalse(isElementDisplayed(dialog));
    }
}
