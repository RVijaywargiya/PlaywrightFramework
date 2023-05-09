package steps.api;

import com.microsoft.playwright.APIResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.APIUtility;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

public class APISteps extends APIUtility {

    APIResponse response;
    private final ObjectMapper mapper = new ObjectMapper();
    private static String baseUrl = null;
    private static String getUserApiEndPoint = null;

    @Given("Get list of users")
    public void getListOfUsers() throws IOException {
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

    @When("Create new user")
    public void userMakesAPostCall() throws IOException {
    }
//-------------------------------------
    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() throws IOException {
        baseUrl = getPropertyFromPropertyFile("baseUrl");
        getUserApiEndPoint = getPropertyFromPropertyFile("pathParamGet");
    }
    @When("I get list of users")
    public void iGetListOfUsers() throws IOException {
        response = new APIUtility().getResource(baseUrl, getUserApiEndPoint);
    }
    @Then("Verify users are displayed")
    public void verifyUsersAreDisplayed() {

    }
}
