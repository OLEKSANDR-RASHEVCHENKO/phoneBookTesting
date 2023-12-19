package e2e;

import e2e.pages.BasePage;
import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import e2e.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    ContactsPage contactsPage;

    @Test
    public void userCanLogin(){
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
    }

    @Test(dataProvider = "invalidDataForLogin",dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidEmail(String email,String password,String caseName) throws IOException {

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email,password);

        loginPage.waitForLoading();
        loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
    }

    private void loginTestMethod(String email, String password,String screenshotName, boolean negativeCase){
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);
        if (negativeCase){
            loginPage.waitForLoading();
            loginPage.takeLoginPageScreenshot(screenshotName);
        }else {
            contactsPage = new ContactsPage(app.driver);
            contactsPage.waitForLoading();
        }
    }


    @Test
    public void userCanLoginWithValidData(){
        loginTestMethod("newtest@gmail.com","newtest@gmail.com",null,false);
    }
    @Test
    public void userCanLoginWithValidEmail(){
        loginTestMethod("neeeewtest@gmail.com","newtest@gmail.com","login_invalid_email",true);
    }

    @Test
    public void userCanLoginWithValidPassword(){
        loginTestMethod("newtest@gmail.com","neeeewtest@gmail.com","login_invalid_password",true);
    }
    @Test
    public void userCanLoginWithValidEmailAndPassword(){
        loginTestMethod("neeeeeewtest@gmail.com","neeeewtest@gmail.com","login_invalid_email_and_password",true);
    }
}
