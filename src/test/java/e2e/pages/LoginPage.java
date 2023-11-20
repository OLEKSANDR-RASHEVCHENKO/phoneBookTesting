package e2e.pages;

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //important constructor!!!
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // describe locator
    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement loginButton;

    //describe methods

    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }



}
