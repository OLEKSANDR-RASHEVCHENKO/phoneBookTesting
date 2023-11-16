package pages;

import org.testng.Assert;
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

        Assert.assertFalse(contactsPage.confirmLogin(), "User is not logged");
    }
}
