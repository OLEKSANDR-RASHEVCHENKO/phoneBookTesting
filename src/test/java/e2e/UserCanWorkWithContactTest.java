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

    private void checkContactData(ContactInfoPage page,String firstName,String lastName,String description){
        String actualFirstName = contactInfoPage.getFirstName();
        String actualLastName = contactInfoPage.getLastName();
        String actualDescription = contactInfoPage.getDescription();
        Assert.assertEquals(actualFirstName,firstName,actualFirstName + " is not equal " + firstName);
        Assert.assertEquals(actualLastName,lastName,actualLastName + " is not equal " + lastName);
        Assert.assertEquals(actualDescription,description,actualDescription + " is not equal " + description);
    }

    @Test
    public void userCanWorkWithContactTest() throws InterruptedException {
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        String firstName =faker.internet().uuid();
        String lastName =faker.internet().uuid();
        String description =faker.lorem().sentence();

        String editFirstName = faker.internet().uuid();
        String editLastName = faker.internet().uuid();
        String editDescription = faker.lorem().sentence();

        // login as user " войти как пользователь "
        loginPage=new LoginPage(app.driver);
        loginPage.login(email,password);

        // Check that user was logged " Проверьте, что пользователь залогинился "
        contactsPage = new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin());

        // add contact " добавить контакт "
        Thread.sleep(2000);
        addContactDialog = contactsPage.openAddContactDialog();
        addContactDialog.setAddContactForm(firstName,lastName,description);
        addContactDialog.saveContact();

        // check created contact " Создать новый контакт "


        contactInfoPage = new ContactInfoPage(app.driver);
        checkContactData(contactInfoPage,firstName,lastName,description);


        // edit contact " изменить контакт "
        editContactForm = contactInfoPage.openEditContactForm();
        editContactForm.setFirstNameInput(editFirstName);
        editContactForm.setLastNameInput(editLastName);
        editContactForm.setDescriptionInput(editDescription);
        editContactForm.saveChanges();



        checkContactData(contactInfoPage,editFirstName,editLastName,editDescription);

        //open contacts page
        contactInfoPage.openContactsPage();
        //filter by contact name
        contactsPage.filterByContact(editFirstName);
        Thread.sleep(2000);
        int actualContactCountRow = contactsPage.getContactCount();
        Assert.assertEquals(actualContactCountRow, 1, "Contact count row after filter should be 1");

        deleteContactDialog = contactsPage.openDeleteDialog();
        deleteContactDialog.setConfirmDeletion();
        deleteContactDialog.removeContact();
        Thread.sleep(2000);
        Assert.assertTrue(contactsPage.isNoResultMessageDisplayed(), "No result message is not visible");

    }
}
