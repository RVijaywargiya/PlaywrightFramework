package steps.api;

import com.microsoft.playwright.APIResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utilities.APIUtility;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

public class APISteps extends APIUtility {

    APIResponse response;
    private final ObjectMapper mapper = new ObjectMapper();
    private static String baseUrl = null;
    private static String getUserApiEndPoint = null;
    SoftAssertions softAssert;

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
        assertThat(response.status()).isEqualTo(arg0);
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
        SoftAssertions test = new SoftAssertions();


    }

    @When("I create a new user")
    public void iCreateANewUser() throws IOException {
        response = postResource("pathParamPost");
    }

    @And("Verify user is added")
    public void verifyUserIsAdded() {
        softAssert.assertThat(response.status()).isEqualTo(200);
    }

    @When("I remove a user")
    public void iRemoveAUser() throws IOException {
        response = deleteResource();
    }


    @Then("Verify user is removed")
    public void verifyUserIsRemoved() {
        softAssert.assertThat(response.status()).isEqualTo(200);
        softAssert.assertThat(response.statusText()).isEqualTo("OK");
        softAssert.assertThat(response.text()).isEqualTo("User deleted successfully");
    }
}
