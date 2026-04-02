package com.sandesh.api.utils;

import com.sandesh.api.models.Booking;
import com.sandesh.api.models.BookingDates;

public class BookingFactory {

    private BookingFactory() {}

    public static Booking createValidBooking() {

        BookingDates dates = new BookingDates("2026-01-01", "2026-01-05");

        return new Booking(
                "John",
                "Doe",
                1000,
                true,
                dates,
                "Breakfast"
        );
    }

    public static Booking createBookingWithMissingFirstname() {

        BookingDates dates = new BookingDates("2024-01-01", "2024-01-05");

        return new Booking(
                null,
                "Doe",
                1000,
                true,
                dates,
                "Breakfast"
        );
    }

    public static Booking createBookingWithNegativePrice() {

        BookingDates dates = new BookingDates("2024-01-01", "2024-01-05");

        return new Booking(
                "John",
                "Doe",
                -500,
                true,
                dates,
                "Breakfast"
        );
    }

}
