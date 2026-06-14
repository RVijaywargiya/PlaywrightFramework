package apitests;

import com.microsoft.playwright.APIResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.api.BookingClient;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingsTest {

    private BookingClient bookingClient;
    private APIResponse bookingsResponse;

    @BeforeClass
    public void setup() {
        bookingClient = new BookingClient();
        bookingsResponse = bookingClient.getBookingsAsApi();
    }

    @Test
    public void verifyBookingStatusCode() {
        assertThat(bookingsResponse.status())
                .as("Check booking status")
                .isEqualTo(200);
    }

    @Test
    public void verifyResponse() {
        System.out.println(bookingsResponse.text());
    }
}