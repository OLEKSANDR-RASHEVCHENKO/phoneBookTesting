package e2e;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.enums.ContactInfoTabs;
import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanAddPhoneNumber extends TestBase {
    LoginPage loginPage;// пуустые переменные, туда будем записывать новые экземпляры класса
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhonesPage phonesPage;
    AddPhoneDialog addPhoneDialog;


    Faker faker = new Faker();

    private void checkContactData(ContactInfoPage page, String firstName, String lastName, String description) {
        contactInfoPage = new ContactInfoPage(app.driver);
        String actualFirstName = page.getFirstName();
        String actualLastName = page.getLastName();
        String actualDescription = page.getDescription();
        Assert.assertEquals(actualFirstName, firstName, actualFirstName + "is not equal" + firstName); // актуальное с ожидаемым
        Assert.assertEquals(actualLastName, lastName, actualLastName + "is not equal" + lastName); // актуальное с ожидаемым
        Assert.assertEquals(actualDescription, description, actualDescription + "is not equal" + description);
    }

    @Test(enabled = false)
    public void userCanAddPhoneNumber()throws InterruptedException {
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";
        String language = "English";

        String firstName = faker.internet().uuid(); // faker генерирует рандомные данные через генератор uuid
        String lastName = faker.internet().uuid();
        String description = faker.lorem().sentence(); // рандомный текст

        String editFirstName = faker.internet().uuid();
        String editLastName = faker.internet().uuid();
        String editDescription = faker.lorem().sentence();

        // login as user
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        // check that user was logged
        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
        contactsPage.selectLanguage(language);
        Assert.assertEquals(contactsPage.getLanguage(), language);

        // Add contact
        addContactDialog = contactsPage.openAddContactDialog();
        addContactDialog.waitForOpen(); // только для диалога
        addContactDialog.setAddContactForm(firstName, lastName, description);
        addContactDialog.saveContact();

        //
        contactInfoPage = new ContactInfoPage(app.driver);
        contactInfoPage.waitForLoading();
        contactInfoPage.openTab(ContactInfoTabs.PHONES);

        //phone page
        phonesPage = new PhonesPage(app.driver);
        phonesPage.waitForLoading();


    }

}