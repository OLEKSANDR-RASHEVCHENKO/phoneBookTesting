package e2e;

import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import e2e.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase{
    LoginPage loginPage; //
    ContactsPage contactsPage;



    @Test
    public void userCanLogin() {
        String email = "newtest@gmail.com";
        String password = "newtest@gmail.com";


        loginPage = new LoginPage(app.driver); //драйвер берем из апликейшн манагер
        loginPage.login(email, password);

        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();

    }
    @Test
    public void userCannotLoginInvalidEmail(){
        String email = "newtestgmail.com";
        String password = "newtest@gmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        loginPage.waitForLoading();


    }

    @Test(dataProvider = "userCannotLogin", dataProviderClass = DataProviders.class)
        public void userCannotLoginWithInvalidEmail(String email, String password, String caseName){
            //String email = "newtestgmail.com";
            //String password = "newtest@gmail.com";


            loginPage = new LoginPage(app.driver); //драйвер берем из апликейшн манагер
            loginPage.login(email, password);
            loginPage.waitForLoading();

            loginPage.waitForLoading();
            loginPage.takeLoginPageScreenshot(caseName + "_negativ_login_test");
}


@Test
    public void userCannotLoginInvalidPassword(){
        String email = "newtest@gmail.com";
        String password = "newtestgmail.com";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        loginPage.waitForLoading();

}

@Test
    public  void userCannotLoginWithInvalidData(){
    String email = "newtestgmail.com";
    String password = "newtestgmail.com";

    loginPage = new LoginPage(app.driver);
    loginPage.login(email, password);
    loginPage.waitForLoading();
}

private void loginTestMethod(String email, String password, String screenshotName, boolean negativeCase){
    loginPage = new LoginPage(app.driver);
    loginPage.waitForLoading();
    loginPage.login(email, password);
    if (negativeCase){
        loginPage.waitForLoading();
        loginPage.takeLoginPageScreenshot(screenshotName);
    }else {
        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
        contactsPage.takeScreenshotHeader();
    }

}
@Test
public  void userCanLoginWithValidData(){
        loginTestMethod("newtest@gmail.com", "newtest@gmail.com", null,false );
}
// TODO: there is a bug ....
@Test
public  void userCanLoginWithInvalidEmail(){
    loginTestMethod("newtestgmail.com", "newtest@gmail.com",  "login_invalid_email", true);
}
@Test
public  void userCanLoginWithInvalidPassword(){
    loginTestMethod("newtest@gmail.com", "newtestgmail.com", "login_invalid_password", true);
}
@Test
public  void userCanLoginWithInvalidEmailAndPassword(){
    loginTestMethod("newtestgmail.com", "newtestgmail.com", "login_invalid_data", true);
}
}




