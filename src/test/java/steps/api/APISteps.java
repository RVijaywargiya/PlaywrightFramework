package steps.api;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.HttpHeader;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.APIUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class APISteps extends APIUtility {

    APIResponse response;
    JsonNode jsonResponse;
    private final ObjectMapper mapper = new ObjectMapper();

    @Given("Get list of users")
    public void getListOfUsers() throws IOException {
        response = new APIUtility().getResource(getProperty("baseUrl"),getProperty("pathParamGet"));
    }

    @And("Display response body")
    public void displayResponseBody() throws IOException {
        Map<String, String> headers = response.headers();
        headers.forEach((k,v) -> System.out.println(k + " : " + v));
        System.out.println(response.headers());
        System.out.println(response.status());
        System.out.println(response.statusText());
        System.out.println(response.text());
    }

    @Then("Verify status as {int}")
    public void verifyStatusAs(int arg0) {
        Assert.assertEquals(response.status(), arg0, "Status code is incorrect");
    }

    @When("User makes a post call")
    public void userMakesAPostCall() throws IOException {
        response = new APIUtility().postResource(getProperty("pathParamPost"));
    }
}
