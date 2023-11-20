package e2e;

import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
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
        Assert.assertTrue(contactsPage.confirmLogin(),"User is not logged");
    }


    @Test
    public void userCannotLoginWithInvalidEmail() {
        String email = "newtestgmail.com";
        String password = "newtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        contactsPage = new ContactsPage(app.driver);
        Assert.assertFalse(contactsPage.confirmLogin(), "User should not be logged in with invalid email");

    }

    @Test
    public void userCannotLoginWithInvalidPassword(){
        String email = "newtest@gmail.com";
        String password = "invalid@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);
        contactsPage = new ContactsPage(app.driver);
        Assert.assertFalse(contactsPage.confirmLogin(),"User is login");

}
    @Test
    public void userCannotLoginWithInvalidEmailAndPassword(){
        String email = "invalid@gmail.com";
        String password = "invalid@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);
        contactsPage = new ContactsPage(app.driver);
        Assert.assertFalse(contactsPage.confirmLogin(),"User is  expected to be logged in");
    }
    @Test
    public void userCannotLoginWithInvalidPasswordAndEmail() {
        String email = "newtesttt@gmail.com";
        String password = "invalidPassword123";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        contactsPage = new ContactsPage(app.driver);
        Assert.assertFalse(contactsPage.confirmLogin(), "The user cannot log in with invalid credentials.");
    }
}



