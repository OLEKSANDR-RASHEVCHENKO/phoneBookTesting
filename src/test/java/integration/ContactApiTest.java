package integration;


import integration.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContactApiTest {
    ContactApi contactApi;

    @Test
    public void userCanWorkWithContactViaApiTest() {

        // Create Contact
        contactApi = new ContactApi();
        JsonPath object = contactApi.createContact(201).jsonPath();
        int contactId = object.getInt("id");
        JsonPath actualObject = contactApi.getContact(200, contactId).jsonPath();
        LinkedHashMap<String, String> contactObjects = new LinkedHashMap<>();
        contactObjects.put(actualObject.getString("firstName"), contactApi.rndDataForCreateContact().getFirstName());
        contactObjects.put(actualObject.getString("lastName"), contactApi.rndDataForCreateContact().getLastName());
        contactObjects.put(actualObject.getString("description"), contactApi.rndDataForCreateContact().getDescription());
        for (Map.Entry<String, String> contactObject : contactObjects.entrySet()
        ) {
            String actualResult = contactObject.getKey();
            String expectedResult = contactObject.getValue();
            Assert.assertEquals(actualResult, expectedResult, " Created contact is not equals getting contact");
        }
        //updated Contact
        contactApi.editContact(200,contactId);
        JsonPath actualEditObject = contactApi.getContact(200, contactId).jsonPath();
        LinkedHashMap<String, String> editedContactObjects = new LinkedHashMap<>();
        editedContactObjects.put(actualEditObject.getString("firstName"), contactApi.rndDataForEditContact(contactId).getFirstName());
        editedContactObjects.put(actualEditObject.getString("lastName"), contactApi.rndDataForEditContact(contactId).getLastName());
        editedContactObjects.put(actualEditObject.getString("description"), contactApi.rndDataForEditContact(contactId).getDescription());
        for (Map.Entry<String, String> editContactObject : editedContactObjects.entrySet()
        ) {
            String actualResult = editContactObject.getKey();
            String expectedResult = editContactObject.getValue();
            Assert.assertEquals(actualResult, expectedResult, " Edited contact is not equals getting contact");
        }
    }
}

