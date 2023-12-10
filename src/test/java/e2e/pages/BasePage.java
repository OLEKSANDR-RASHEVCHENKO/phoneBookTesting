package e2e.pages;

import e2e.Wait.Wait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


// общие методы, кот используем в  Page
public class BasePage {
    public WebDriver driver;



    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Wait getWait(){
        return new Wait(driver);
    }

    public Select getSelect(WebElement element){
        return new Select(element);
    }

    // метод кот находит элемент
    protected boolean isElementDisplayed(WebElement element) { // указываем типизацию элемента в аргументах
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException e){ // из селениеума
            return false;
        }
    }
    // заполняет импут там где это нужно, будем к нему обращаться, то что заменили в AddContactDialog
    protected void setInput(WebElement input, String value){ // input - сам элемент, локатор из FindBy(firstNameInput)
        // value -это уже само значение, кот мы будем вводить(firstName...)

        input.click();
        input.clear();
        input.sendKeys(value);

    }


}
