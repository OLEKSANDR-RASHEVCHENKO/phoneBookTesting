package integration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiBase {

    final String BASE_URI = "http://phonebook.telran-edu.de:8080/";
    final String API_KEY = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6Im5ld3Rlc3RAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTcwNTIzMjA5MH0.CIpR5eZzkcVAim3qEgCKoq9VIfFLwUcC1dSDq4_IWqW9r5RjoQm7loONS_Mqje_CGvSn7UPkSNJ5sS5H-uITzQ";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();

    protected Response getRequest(String endpoint, int code){
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

    protected Response getRequestWithParam(String endpoint, int code,String paramName, int id){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam(paramName,id)
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(code);
        return response;
    }

    protected Response postRequest(String endpoint, int code, Object body){
        Response response = RestAssured.given()
                .spec(spec)//метод,спецификация входная
                .body(body)//
                .when()// kogda
                .log().all()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(code);
        return response;
    }

    protected Response putRequest(String endpoint, int code, Object body){
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .put(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(code);
        return response;
    }

    protected Response deleteRequest(String endpoint, int code, int id){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id",id)
                .log().all()
                .delete(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(code);
        return response;
    }
}
