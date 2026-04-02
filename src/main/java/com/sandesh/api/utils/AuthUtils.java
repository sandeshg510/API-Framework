package com.sandesh.api.utils;

import com.sandesh.api.api.ApiClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthUtils {

    private AuthUtils() {}

    public static String getToken() {
        Map<String, String> body = new HashMap<>();
        body.put("username", ConfigReader.get("username"));
        body.put("password", ConfigReader.get("password"));

        Response response = ApiClient
                .getRequestSpec()
                .body(body)
                .post("/auth");

        return response
                .jsonPath()
                .getString("token");
    }

}
