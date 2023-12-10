package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    //import constructor принимает на себя драйвер
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //describe locator
    @FindBy (xpath = "//*[@name='email']")// short annotation ,  способ по кот мы хотим
    WebElement emailInput;

    @FindBy (xpath = "//*[@name='password']")// short annotation ,  способ по кот мы хотим
    WebElement passwordInput;

    @FindBy (xpath = "//*[@type='submit']")// short annotation ,  способ по кот мы хотим
    WebElement loginButton;

    public void waitForLoading(){ //только для эл. кот видимые,
        getWait().forVisibility(emailInput);
        getWait().forVisibility(passwordInput);
        getWait().forVisibility(loginButton);
    }

    //described method
    public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
