package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    protected void setInput(WebElement input, String value){
        input.click();
        input.clear();
        input.sendKeys(value);
    }
}
