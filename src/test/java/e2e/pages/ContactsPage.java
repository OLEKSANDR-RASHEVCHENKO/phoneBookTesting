package e2e.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{
    public ContactsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='collapse navbar-collapse']")
    WebElement header;
    @FindBy(xpath ="//select[@id='langSelect")
    WebElement languageDropDown;
    @FindBy(xpath = "//input[@formcontrolname='searchInput']")
    WebElement searchInput;
    @FindBy(xpath = "//*[@href='/contacts']")
    WebElement addContactButton;
    @FindBy(xpath = "//*[@id='contacts-list'] ")
    WebElement contactList;
    @FindBy(xpath = "//*[@ng-reflect-router-link='/account']")
    WebElement account;
    @FindBy(xpath = "//*[@src='/assets/icons/trash.svg']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@text()='Logout']")
    WebElement logoutButton;

    public boolean confirmLogin(){return header.isDisplayed();}

    public AddContactDialog openAddContactDialog(){
        addContactButton.click();
        return new AddContactDialog(driver);
    }

    public void openDeleteDialog(){
        deleteButton.click();
    }

    public void setSearchInput(String contactValue){
        searchInput.sendKeys(contactValue);
    }

    }

