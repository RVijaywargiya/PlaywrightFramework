package tests;

import models.BookingRequest;
import models.BookingResponse;
import org.testng.annotations.Test;
import services.BookingService;
import testData.BookingData;

import static org.assertj.core.api.Assertions.*;

public class BookingTest {

    private final BookingService bookingService =
            new BookingService();

    @Test
    public void shouldCreateBooking() {

        BookingRequest request =
                BookingData.validBooking();

        BookingResponse response =
                bookingService.createBooking(
                        request
                );

        assertThat(
                response.getBookingid()
        ).isGreaterThan(0);
    }
}