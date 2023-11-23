package e2e;

import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanWorkWithContactTest extends TestBase{
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    EditContactForm editContactForm;
    DeleteContactDialog deleteContactDialog;
    @Test
    public void userCanWorkWithContactTest(){
        String email = "newtest@gmail.com";
        String password = "enwtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);

        contactsPage = new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin());

    }
}
