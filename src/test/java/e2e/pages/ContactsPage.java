package e2e.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='collapse navbar-collapse']")
    WebElement header;

    @FindBy(xpath = "//*[@href='/contacts']")
    WebElement addContactButton;

    @FindBy(xpath = "//select[@id='langSelect']")
    WebElement languageDropdown;

    @FindBy(xpath = "//*[@id='contacts-list']")
    WebElement contactsList;

    @FindBy(xpath = "//*[@formcontrolname='searchInput']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@ng-reflect-router-link='/account']")
    WebElement accountButton;

    @FindBy(xpath = "//*[@src='/assets/icons/trash.svg']")
    WebElement deleteButton;

    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;

    public boolean confirmLogin() {
        return header.isDisplayed();
    }

    // метод кот открывает диалоговое окно контакта, аргументы не нужны, т.к. это метод действия это
    public AddContactDialog openAddContactDialog(){
        Assert.assertTrue(isElementDisplayed(addContactButton));
        addContactButton.click();
        return new AddContactDialog(driver); // после клика мы выводим новый экземпляр класса AddContact Dialog
    }

    // метод удаления контакта
    public void openDeleteDialog(){
        deleteButton.click();
    }

    // метод, кот ввводит данные в серчинг(set - заполнить).
    public void setSearchInput (String contactValue){
        searchInput.sendKeys(contactValue);
    }
}
