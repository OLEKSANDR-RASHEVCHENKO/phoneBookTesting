package e2e.pages;

import e2e.enums.ContactInfoTabs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailsPage extends ContactInfoPage{
    public EmailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//*[@id='search']")
    WebElement searchInput;
    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement addEmailButton;
    @FindBy(xpath = "//*[@id='input-email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;




}
