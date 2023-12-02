package e2e;

import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    ContactsPage contactsPage;

    @Test
    public void userCanLogin() {
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
    }

    @Test
    public void userCannotLoginWithInvalidEmail() {
        String email = "newtestgmail.com";
        String password = "newtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        contactsPage = new ContactsPage(app.driver);
        contactsPage.getWait().forInvisibility(contactsPage.header);

    }

    @Test
    public void userCannotLoginWithInvalidPassword() {
        String email = "invalid@gmail.com";
        String password = "invalid@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        loginPage.waitForLoading();

    }

    @Test
    public void userCannotLoginWithInvalidPasswordAndEmail(){

    String email = "newtesttest@gmail.com";
    String password = "invalidPassw678";
    loginPage = new LoginPage(app.driver);


    loginPage.login(email,password);
    loginPage.waitForLoading();
}
@Test
    public  void userCannotLoginWithInvalidEmailAndPassword(){
        String email="newtesttest@gmail.com";
        String password="invalidPassw678";
        loginPage= new LoginPage(app.driver);
        loginPage.login(email,password);
        loginPage.waitForLoading();

        }

}


