package com.sandesh.api.utils;

import io.restassured.response.Response;

public class ResponseUtils {

    private ResponseUtils() {}

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static String getBody(Response response) {
        return response
                .getBody()
                .asString();
    }

    public static long getResponseTime(Response response) {
        return response.getTime();
    }

}
