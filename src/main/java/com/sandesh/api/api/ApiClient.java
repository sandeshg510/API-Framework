package com.sandesh.api.api;

import com.sandesh.api.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public final class ApiClient {

    private ApiClient() {}

    public static RequestSpecification getRequestSpec() {
        return RestAssured
                .given()
                .baseUri(ConfigReader.get("baseUrl"))
                .header("Content-Type", "application/json");
    }

}
