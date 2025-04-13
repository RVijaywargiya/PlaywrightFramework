package apitests;

import com.microsoft.playwright.APIResponse;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import steps.api.BookingClient;

import java.io.IOException;

public class BookingsTest {

    private BookingClient bookingClient;
    private SoftAssertions softAssertions;

    public BookingsTest() {}

    public BookingsTest(BookingClient bookingClient) {
        this.bookingClient = new BookingClient();
        softAssertions = new SoftAssertions();
    }

    @Test
    public void verifyBookingStatusCode() throws IOException {
        APIResponse bookingsJsonResponse = bookingClient.getBookingsAsApi();
        Integer actualStatusCode = bookingsJsonResponse.status();
        System.out.println("Status code : " + actualStatusCode);
        softAssertions.assertThat(actualStatusCode).as("Check booking status").isEqualTo(200);
        softAssertions.assertAll();
    }

    @Factory
    public static Object[] createInstances() {
        BookingClient bookingClient = new BookingClient();  // Create or configure the BookingClient as needed
        return new Object[] { new BookingsTest(bookingClient) };
    }


}
