package e2e.pages;

import com.github.javafaker.Faker;
import e2e.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanWorkWithContactTest extends TestBase {
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    EditContactForm editContactForm;
    DeleteContactDialog deleteContactDialog;
    Faker faker = new Faker();
    @Test
    public void userCanWorkWithContactTest(){
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";
        String firstName = faker.internet().uuid();
        String lastName = faker.internet().uuid();
        String description = faker.lorem().sentence();

        loginPage = new LoginPage(app.driver);
        loginPage.login(email,password);

        contactsPage = new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin());

        addContactDialog = contactsPage.openAddContactDialog();
        contactsPage.setAddContactForm(firstName, lastName, description);
        addContactDialog.saveContact();

        contactInfoPage = contactInfoPage(app.driver);


    }

}
