package integration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    final String BASE_URL = "http://phonebook.telran-edu.de:8080/";

    final String API_KEY = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6Im5ld3Rlc3RAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTcwNDk4MTE5MH0.HNjovIeYNWnp7ATlf9fMyYwqIkCPsHboMSVQJF3ceSFghUXvkJe9C2o5LyUNPE4TrTuEWm20E57LuDrur0gARg";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token",API_KEY)
            .build();

    protected Response getRequest(String endpoint,int code){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(code);
        return response;
    }
}
