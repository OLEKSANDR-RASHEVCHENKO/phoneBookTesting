package e2e;

import com.github.javafaker.Faker;
import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanWorkWithContactTest extends TestBase{
    LoginPage loginPage;// пуустые переменные, туда будем записывать новые экземпляры класса
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    EditContactForm editContactForm;
    DeleteContactDialog deleteContactDialog;

    Faker faker = new Faker();


    private  void checkContactData(ContactInfoPage page, String firstName, String lastName,String description){
        contactInfoPage = new ContactInfoPage(app.driver);
        String actualFirstName = page.getFirstName();
        String actualLastName = page.getLastName();
        String actualDescription = page.getDescription();
        Assert.assertEquals(actualFirstName, firstName, actualFirstName + "is not equal" + firstName); // актуальное с ожидаемым
        Assert.assertEquals(actualLastName, lastName, actualLastName + "is not equal" + lastName); // актуальное с ожидаемым
        Assert.assertEquals(actualDescription, lastName, actualDescription + "is not equal" + description);
    }

    @Test
    public void userCanWorkWithContactTest() throws InterruptedException {
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        String firstName = faker.internet().uuid(); // faker генерирует рандомные данные через генератор uuid
        String lastName = faker.internet().uuid();
        String description = faker.lorem().sentence();

        String  editFirstName = faker.internet().uuid();
        String  editLastName = faker.internet().uuid();
        String  editDescription = faker.lorem().sentence();

        // login as user
        loginPage=new LoginPage(app.driver);
        loginPage.login(email,password);

        // check that user was logged
        contactsPage = new ContactsPage(app.driver);
        Assert.assertTrue(contactsPage.confirmLogin());

        // Add contact
        Thread.sleep(2000);
        addContactDialog = contactsPage.openAddContactDialog();
        addContactDialog.setAddContactForm(firstName,lastName,description);
        addContactDialog.saveContact();

        // check created contact
        contactInfoPage = new ContactInfoPage(app.driver);
        checkContactData(contactInfoPage, firstName, lastName, description);

        // edit contact
        editContactForm = contactInfoPage.openEditContactForm();// лежит новый экземпляр класса из котю мы достаем
        editContactForm.setFirstNameInput(editFirstName);
        editContactForm.setLastNameInput(editLastName);
        editContactForm.setDescriptionInput(editDescription);
        editContactForm.saveChange();
    }

}
