package com.sandesh.api.tests;

import com.sandesh.api.api.BookingService;
import com.sandesh.api.models.Booking;
import com.sandesh.api.models.BookingDates;
import com.sandesh.api.utils.BookingFactory;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest {

    private final BookingService bookingService = new BookingService();

    @Test
    public void testCreateAndGetBooking() {

        BookingDates dates = new BookingDates("2024-01-01", "2024-01-05");

        Booking booking = BookingFactory.createValidBooking();
        Response createResponse =
                bookingService.createBooking(booking);

        Assert.assertEquals(createResponse.getStatusCode(), 200);

        int bookingId = createResponse.jsonPath()
                                      .getInt("bookingid");

        Response getResponse = bookingService.getBooking(bookingId);

        Assert.assertEquals(getResponse.getStatusCode(), 200);

        getResponse.then()
                   .assertThat()
                   .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("booking-schema.json"));

        Assert.assertTrue(getResponse.getTime() < 2000, "Response time is too high");
    }

}
