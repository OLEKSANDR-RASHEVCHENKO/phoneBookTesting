package e2e.pages;

import e2e.pages.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='collapse navbar-collapse']")
    WebElement header;
    @FindBy(xpath = "//div[@id='langSelect']")
    WebElement languageDropdown;

    @FindBy(xpath = "//div[@id='Contacts']")
    WebElement contactList;

    @FindBy(xpath = "//div[@formcontrolname='searchInput']")
    WebElement searchInput;

    @FindBy(xpath = "//div[@ng-reflect-router-link='/account']")
    WebElement accountButton;

    @FindBy(xpath = "//div[@src='/assets/icons/trash.svg']")
    WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;

    public boolean confirmLogin(){
        try {
            header.isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
