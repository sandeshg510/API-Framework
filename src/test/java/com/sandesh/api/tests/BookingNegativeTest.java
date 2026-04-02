package com.sandesh.api.tests;

import com.sandesh.api.api.BookingService;
import com.sandesh.api.utils.BookingFactory;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingNegativeTest {

    private final BookingService bookingService = new BookingService();

    @Test
    public void testCreateBookingWithMissingFirstname() {

        Response response = bookingService.createBooking(
                BookingFactory.createBookingWithMissingFirstname()
        );

        Assert.assertNotEquals(response.getStatusCode(), 200,
                               "API accepted booking with missing firstname");

        Assert.assertTrue(response.getBody()
                                  .asString()
                                  .length() > 0,
                          "Response body should contain error details");
    }

    @Test
    public void testCreateBookingWithNegativePrice() {

        Response response = bookingService.createBooking(
                BookingFactory.createBookingWithNegativePrice()
        );

        Assert.assertNotEquals(response.getStatusCode(), 200,
                               "API accepted booking with negative price");

        Assert.assertTrue(response.getTime() < 2000,
                          "API response too slow for invalid request");
    }

}