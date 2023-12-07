package e2e;

import com.github.javafaker.Faker;
import e2e.pages.ContactInfoPage;
import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class UserCanAddAddressTest extends TestBase {
    LoginPage loginPage;
    ContactsPage contactsPage;
    ContactInfoPage contactInfoPage;
    Faker faker = new Faker();

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

        //login as user
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        //open contacts page
        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
        contactInfoPage.openContactsPage();

    }
}
