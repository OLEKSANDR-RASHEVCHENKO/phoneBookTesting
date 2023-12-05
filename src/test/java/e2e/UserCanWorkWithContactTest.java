package e2e;

import com.github.javafaker.Faker;
import e2e.pages.*;
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

    private void checkContactData(ContactInfoPage page, String firstName, String lastName, String description){
        String actualFirstName = page.getFirstName();
        String actualLastName = page.getLastName();
        String actualDescription = page.getDescription();
        Assert.assertEquals(actualFirstName,firstName, actualFirstName + " is not equal " + firstName);
        Assert.assertEquals(actualLastName,lastName, actualLastName + " is not equal " + lastName);
        Assert.assertEquals(actualDescription,description, actualDescription + " is not equal " + description);
    }

    @Test
    public void userCanWorkWithContactTest() throws InterruptedException {
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";
        String language = "English";

        String firstName = faker.internet().uuid();
        String lastName = faker.internet().uuid();
        String description = faker.lorem().sentence();

        String editFirstName = faker.internet().uuid();
        String editLastName = faker.internet().uuid();
        String editDescription = faker.lorem().sentence();

        // login as user
        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        // check that user was logged
        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
        contactsPage.selectLanguage(language);
        Assert.assertEquals(contactsPage.getLanguage(), language);

        // add contact
        Thread.sleep(2000);
        addContactDialog = contactsPage.openAddContactDialog();
        addContactDialog.waitForOpen();
        addContactDialog.setAddContactForm(firstName,lastName,description);
        addContactDialog.saveContact();

        // check created contact
        contactInfoPage = new ContactInfoPage(app.driver);
        contactInfoPage.waitForLoading();
        checkContactData(contactInfoPage, firstName,lastName,description);

        // edit contact
        editContactForm = contactInfoPage.openEditContactForm();
        editContactForm.waitForOpen();
        editContactForm.setFirstNameInput(editFirstName);
        editContactForm.setLastNameInput(editLastName);
        editContactForm.setDescriptionInput(editDescription);
        editContactForm.saveChanges();

        contactInfoPage.waitForLoading();


        //check edited contact
        contactsPage.waitForLoading();
        checkContactData(contactInfoPage, editFirstName, editLastName, editDescription);

        //open contacts page
        contactInfoPage.openContactPage();
        contactsPage.waitForLoading();

        //filter by contact name
        contactsPage.filterByContact(editFirstName);
        contactsPage.waitForLoading();

        //check rows count after filter by contact name
        int actualContactCountRow = contactsPage.getContactCount();
        Assert.assertEquals(actualContactCountRow, 1, "Contact count row after 1");

        //delete contact
        deleteContactDialog = contactsPage.openDeleteDialog();
        deleteContactDialog.waitForOpen();
        deleteContactDialog.setConfirmDeletion();
        deleteContactDialog.removeContact();
        contactsPage.waitForLoading();


        //check that contact was deleted

        Assert.assertTrue(contactsPage.isNoResultMassageDisplayed(),"No result massage is not visible");


    }
}
