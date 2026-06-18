package steps.api;

import com.microsoft.playwright.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import factory.BookingData;
import org.testng.annotations.Test;
import pojo.Booking;
import utilities.BaseApiClient;

import java.io.IOException;
import java.util.Map;

public class BookingClient {

    private static ObjectMapper mapper = new ObjectMapper();
    private APIResponse response;
    private APIRequest request;
    private BaseApiClient apiClient;

    public BookingClient() {
        apiClient = new BaseApiClient();
    }

    @Test
    public String getBookingsAsJson() throws IOException {
        response = apiClient.get("https://bookstore.toolsqa.com/BookStore/v1/Books");
        System.out.println(response.text());
        Map<String, Object> jsonMap = mapper.readValue(response.text(), Map.class);
        System.out.println("Parsed JSON:");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
        return jsonString;
    }

    @Test
    public APIResponse getAllBookingsResponse() {
        response = apiClient.get(BookingData.BOOKING_IDS);
        return response;
    }

//    @Test
//    public APIResponse createBooking() {
//        response = apiClient.post()
//    }

    @Test
    public Booking getBookingsAsPojo() throws IOException {
        String json = getBookingsAsJson();
        return mapper.readValue(json, Booking.class);
    }
}
