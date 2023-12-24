package e2e;

import com.github.javafaker.Faker;
import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanWorkWithPhone extends TestBase{
    LoginPage loginPage;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhoneInfoPage phoneInfoPage;
    AddPhoneDialog addPhoneDialog;
    Faker faker = new Faker();
    private void checkContactData(ContactInfoPage page,String firsName,String lastName,String description){
        String actualFirstName=page.getFirstName();
        String actualLastName=page.getLastName();
        String actualDescription=page.getDescription();
        Assert.assertEquals(actualFirstName,firsName,actualFirstName+ "is not equal "+firsName);
        Assert.assertEquals(actualLastName,lastName,actualLastName+ "is not equal "+lastName);
        Assert.assertEquals(actualDescription,description,actualDescription+ "is not equal "+description);
    }

    private void checkPhoneData(PhoneInfoPage page,String phoneInput){
        String actualPhoneNumber = page.getPhone();
        Assert.assertEquals(actualPhoneNumber,phoneInput,actualPhoneNumber+ "is not equal "+phoneInput);
    }

    @Test
    private void userCanWorkWithPhoneNumber(){
        String email = "newTest@gmail.com";
        String password = "newtest@gmail.com";
        String language = "English";
        String phoneNumberInput = "0966451658";
        String dropDownEdit = "Edit";
        String changedPhone = "5533444333";
        String dropDownRemove = "Remove";

        String firsName = faker.internet().uuid();
        String lastName = faker.internet().uuid();
        String description = faker.lorem().sentence();


    }
}
