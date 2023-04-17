package steps.api;

import com.microsoft.playwright.APIResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import utilities.APIUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APISteps extends APIUtility {

    APIResponse response;

    @Given("Get list of users")
    public void getListOfUsers() throws IOException {
        response = new APIUtility().getResource(getProperty("baseUrl"),getProperty("pathParam"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonResponse = mapper.readTree(response.body());
        System.out.println(jsonResponse.toPrettyString());
    }

    @Given("Add user")
    public void addUser() {

    }
}
