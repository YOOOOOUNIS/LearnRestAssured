package com.qacart;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Assertion {

    @Test
    public void test() {

        given() // all the information that we will send as part of our request parameters, headers, auth,body
                .when() // the action, here we will define the method: GET, POST, PUT, DELETE
                .then(); // the outcome of the request response body, status code, cookies, response headers


    }


    @Test
    public void getAllData() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all();


    }

    @Test
    public void assertionOnStatusCode() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200);


    }

    @Test
    public void bodyAssertion() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", is(equalTo("Rodolfo Schumm")));


    }

    @Test
    public void bodyAssertion_assertThatItemExist() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", is(equalTo("Rodolfo Schumm")))
                .assertThat().body("name", is(hasItem("Cecelia Funk")));


    }

    @Test
    public void bodyAssertion_assertThatItemsExist() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", is(equalTo("Rodolfo Schumm")))
                .assertThat().body("name", is(hasItems("Cecelia Funk", "Rodolfo Schumm")));


    }

    @Test
    public void bodyAssertion_assertThatItemsNotExist() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", is(equalTo("Rodolfo Schumm")))
                .assertThat().body("name", is(not(hasItems("Cecelia Funky", "Rodolfo Schummn"))));


    }

    @Test
    public void bodyAssertion_assertThatListContainsItems() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", is(equalTo("Rodolfo Schumm")))
                .assertThat().body("name", is(contains("Cecelia Funky", "Rodolfo Schummn")));


    }

    @Test
    public void bodyAssertion_assertThatListContainsItemsInAnyOrder() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name", is(equalTo("Rodolfo Schumm")))
                .assertThat().body("name", is(containsInAnyOrder("Cecelia Funky", "Rodolfo Schummn")));


    }

    @Test
    public void bodyAssertion_assertThatListIsNotEmpty() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(is(not(empty())));


    }


    @Test
    public void bodyAssertion_assertOnListSize() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", is(hasSize(30)));


    }


    @Test
    public void bodyAssertion_assertOnِEveryItemInListSize() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("createdAt", everyItem(is(startsWith("2024"))));


    }

    @Test
    public void bodyAssertion_assertOnKeyOrValue() {

        given().baseUri("https://66f2e51571c84d8058772254.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0]", hasKey("id")) // check on key only
                .assertThat().body("[0]", hasValue("1")) // check on value only
                .assertThat().body("[0]", hasEntry("id", "1")); // check on that key that he have the value


    }
}
