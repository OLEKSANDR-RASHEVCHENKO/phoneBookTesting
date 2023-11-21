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
    @FindBy(xpath = "//*[@id='contacts-list'] ")
    WebElement contactList;
    @FindBy(xpath = "//*[@ng-reflect-router-link='/account']")
    WebElement account;
    @FindBy(xpath = "//*[@src='/assets/icons/trash.svg']")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@text()='Logout']")
    WebElement logoutButton;

    public boolean confirmLogin(){
        try{
            header.isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
