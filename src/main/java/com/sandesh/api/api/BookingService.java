package com.sandesh.api.api;

import com.sandesh.api.utils.AuthUtils;
import io.restassured.response.Response;

public class BookingService {

    public Response createBooking(Object body) {
        return ApiClient.getRequestSpec()
                        .body(body)
                        .post("/booking");
    }

    public Response getBooking(int id) {
        return ApiClient.getRequestSpec()
                        .get("/booking/" + id);
    }

    public Response updateBooking(int id, Object body) {
        return ApiClient.getRequestSpec()
                        .header("Cookie", "token=" + AuthUtils.getToken())
                        .body(body)
                        .put("/booking/" + id);
    }

    public Response deleteBooking(int id) {
        return ApiClient.getRequestSpec()
                        .header("Cookie", "token=" + AuthUtils.getToken())
                        .delete("/booking/" + id);
    }

}
