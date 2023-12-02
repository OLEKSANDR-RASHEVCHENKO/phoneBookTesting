package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Phones_Page extends ContactsPage {
    public Phones_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='ngb-nav-3']")
    WebElement phoneTab;

    @FindBy(xpath = "//*[@id='btn-add-phone']")
    WebElement AddPhoneButton;

    @FindBy(xpath = "//*[@id='selected-cc']")
    WebElement addPhoneNumber;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement saveButton;
}
