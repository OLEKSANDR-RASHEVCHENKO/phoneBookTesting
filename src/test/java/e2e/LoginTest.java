package e2e;

import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
//import e2e.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage;
    ContactsPage contactsPage;

    @Test
    public void userCanLogin(){
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);

        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataProvider.class)
    public void userCannotLogin(String email, String password){
        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);
        loginPage.waitForLoading();
    }
}