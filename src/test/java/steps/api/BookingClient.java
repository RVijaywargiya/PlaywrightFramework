package steps.api;

import com.microsoft.playwright.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Bookings;
import utilities.APIUtility;

import java.io.IOException;
import java.util.Map;

public class BookingClient {

    private static ObjectMapper mapper = new ObjectMapper();
    private APIResponse response;
    private APIRequest request;
    private APIUtility apiUtility;

    public BookingClient() {
        apiUtility = new APIUtility();
    }

    @Test
    public String getBookingsAsJson() throws IOException {
        response = apiUtility.get("https://bookstore.toolsqa.com/BookStore/v1/Books");
        System.out.println(response.text());
        Map<String, Object> jsonMap = mapper.readValue(response.text(), Map.class);
        System.out.println("Parsed JSON:");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
        return jsonString;
    }

    @Test
    public APIResponse getBookingsAsApi() throws IOException {
        response = apiUtility.get("https://bookstore.toolsqa.com/BookStore/v1/Books");
        return response;
    }

    @Test
    public Bookings getBookingsAsPojo() throws IOException {
        String json = getBookingsAsJson();
        return mapper.readValue(json, Bookings.class);
    }
}
