package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmailDialog extends EmailsPage{
    public AddEmailDialog(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addEmailButton;

    @FindBy(xpath = "//*[@id='input-email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;


}
