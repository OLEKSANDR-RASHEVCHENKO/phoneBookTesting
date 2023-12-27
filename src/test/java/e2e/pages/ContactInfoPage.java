package e2e.pages;

import e2e.enums.ContactInfoTabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactInfoPage extends ContactsPage{
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='contact-first-name']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@id='contact-last-name']")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@id='contact-description']")
    WebElement descriptionField;

    @FindBy(xpath = "//button[@id='btn-edit-contact']")
    WebElement editButton;

    public void waitForLoading(){
        getWait().forVisibility(firstNameField);
        getWait().forVisibility(lastNameField);
        getWait().forVisibility(descriptionField);
        getWait().forVisibility(editButton);
        getWait().forClickable(editButton);
    }

//метод на все табы через энамы, смотреть по локаторамюю отличаются только цифрой-динамический
    public void openTab(ContactInfoTabs tab){
        driver.findElement(By.xpath("//*[@ng-reflect-_id='"+tab.value+"']")).click();

}
    // get метод, кот проверяет, создался/сохранился ли новый контакт, сохранились ли валидные данные - выводит содержимое Field
    public  String getFirstName(){
        return firstNameField.getText(); // поле в кот содержится имя но мы туда ничего не можем ввести -Field
    }

    public  String getLastName(){
        return lastNameField.getText();
    }

    public  String getDescription(){
        return descriptionField.getText();
    }
    // метод для редактирования
    public EditContactForm openEditContactForm(){
        editButton.click();
        Assert.assertFalse(isElementDisplayed(firstNameField), "Edit contact form was not opened"); // проверка, что хотябы
        //  первый элемент при открытии формы отображается, для того, чтобы потом написать методы на ввод данных
        return new EditContactForm(driver);
    }

}


