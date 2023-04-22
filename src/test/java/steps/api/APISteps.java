package steps.api;

import com.microsoft.playwright.APIResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.APIUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APISteps extends APIUtility {

    APIResponse response;
    JsonNode jsonResponse;
    private final ObjectMapper mapper = new ObjectMapper();

    @Given("Get list of users")
    public void getListOfUsers() throws IOException {
        response = new APIUtility().getResource(getProperty("baseUrl"),getProperty("pathParam"));
        jsonResponse = mapper.readTree(response.body());
    }

    @Given("Add user")
    public void addUser() {

    }

    @And("Display response body")
    public void displayResponseBody() throws IOException {
        System.out.println(jsonResponse.toPrettyString());
    }

    @Then("Verify status as {int}")
    public void verifyStatusAs(int arg0) {
        Assert.assertEquals(response.status(), arg0, "Status code is incorrect");
    }
}
