package services;

import clients.BookingClient;
import com.microsoft.playwright.APIResponse;
import models.BookingRequest;
import models.BookingResponse;
import utils.JsonUtils;

public class BookingService {

    private final BookingClient bookingClient =
            new BookingClient();

    public BookingResponse createBooking(
            BookingRequest request) {

        APIResponse response =
                bookingClient.createBooking(
                        request);

        if (response.status() != 200) {
            throw new AssertionError(
                    "Booking creation failed"
            );
        }

        return JsonUtils.fromJson(
                response.text(),
                BookingResponse.class
        );
    }

    public APIResponse getBooking(
            int bookingId) {

        return bookingClient.getBooking(
                bookingId
        );
    }
}