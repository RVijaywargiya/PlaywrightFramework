package testData;

import models.BookingRequest;

public final class BookingData {

    private BookingData() {
    }

    public static BookingRequest validBooking() {

        return new BookingRequest(
                "John",
                "Doe",
                1000,
                true
        );
    }
}