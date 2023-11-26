package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    //import Constructor!!!
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Describe locator
    @FindBy(xpath = "//*[@name='email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement loginButton;



    //Describe metods "
    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
