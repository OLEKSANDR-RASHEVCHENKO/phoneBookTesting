package integration.contact;

import com.github.javafaker.Faker;
import integration.ApiBase;
import integration.schemas.ContactDto;
import io.restassured.response.Response;

public class ContactApi extends ApiBase {
    Response response;
    ContactDto dto;
    Faker faker = new Faker();
    String firstName = faker.internet().uuid();
    String lastName = faker.internet().uuid();
    String description = faker.internet().uuid();
    String editFirstName = faker.internet().uuid();
    String editLastName = faker.internet().uuid();
    String editDescription = faker.internet().uuid();

    private ContactDto rndDataForCreatedContact() {
        dto = new ContactDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDescription(description);
        return dto;
    }

    private ContactDto rndDataForEditContact(int id) {
        dto = new ContactDto();
        dto.setId(id);
        dto.setFirstName(editFirstName);
        dto.setLastName(editLastName);
        dto.setDescription(editDescription);
        return dto;
    }

    private Response createContact(int code) {
        String endpoint = "/api/contact";
        Object body = rndDataForCreatedContact();
        response = postRequest(endpoint, code, body);
        response.as(ContactDto.class);
        return response;
    }

    private void editContact(int code, int id) {
        String endpoint = "/api/contact";
        Object body = rndDataForEditContact(id);
        putRequest(endpoint, code, body);
    }

    private Response deleteContact(int code, int id) {
        String endpoint = "/api/contact/{id}";
        response = deleteRequest(endpoint, code, id);
        return response;
    }
}
