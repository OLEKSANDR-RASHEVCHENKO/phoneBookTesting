package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddContactDialog extends ContactsPage{
    public AddContactDialog(WebDriver driver) {
        super(driver);
    }

    // Describe locator
    @FindBy(xpath = "//*[@role='dialog']") //   //- поиск по всем элементам, * - любой тэг,
    // [] - ищем атрибут со значением( @атрибут = 'значение')
    WebElement dialog;

    @FindBy(xpath = "//*[@id='form-name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='form-lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='form-about']")
    WebElement descriptiontInput;

    @FindBy(xpath = "//*[@type='reset']")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@role='dialog']//*[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "//*[@aria-label='Close']")
    WebElement closeWindowsButton;

    @FindBy(xpath = "//*[@id='form-error-firstName']")
    WebElement errorMessage;

    // метод запонения имени, фамилии и описания соответс.
    public void setFirstNameInput(String firstName){
        setInput(firstNameInput, firstName);// заменяет 3 строки внизу

        //firstNameInput.click(); //кликнуть на инпут -доступен для ввода
        //firstNameInput.clear(); // возможность стереть
        //firstNameInput.sendKeys(firstName);// ввод значения в инпут
    }
    public  void setLastNameInput(String lastName){
        setInput(lastNameInput, lastName);

        //lastNameInput.click();
        //lastNameInput.clear();
        //lastNameInput.sendKeys(lastName);
    }
    public void setDescription(String description){
        setInput(descriptiontInput, description);

        //descriptiontInput.click();
        //descriptiontInput.clear();
        //descriptiontInput.sendKeys(description);
    }
    // метод  кот включает в себя все 3 метода, заполняем полностью всю форму
    public  void setAddContactForm(String firstName,String lastName, String description){
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setDescription(description);
    }
    public void saveContact(){
        saveButton.click();
    }

}
