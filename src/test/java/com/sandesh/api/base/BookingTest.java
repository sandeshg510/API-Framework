package com.sandesh.api.tests;

import com.sandesh.api.base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BookingTest extends BaseTest {

    @Test
    public void getAllBookings() {

        given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .log().all();
    }
}