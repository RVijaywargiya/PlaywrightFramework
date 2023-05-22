package steps.api;

import com.microsoft.playwright.APIResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Builder;
import org.assertj.core.api.SoftAssertions;
import pojo.Airline;
import utilities.APIUtility;
import utilities.FakeDataUtils;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

public class APISteps extends APIUtility {

    APIResponse response;
    private static String baseUrl;
    private static String endPoint;
    SoftAssertions softAssert = new SoftAssertions();
    private final FakeDataUtils fakeDataUtils = new FakeDataUtils();

    @Given("Get list of users")
    public void getListOfUsers() throws IOException {
    }

    @And("Display response body")
    public void displayResponseBody() throws IOException {
        Map<String, String> headers = response.headers();
        headers.forEach((k, v) -> System.out.println(k + " : " + v));
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
        endPoint = getPropertyFromPropertyFile("pathParamPost");
    }

    //    @When("I get list of users")
//    public void iGetListOfUsers() throws IOException {
//        response = new APIUtility().getResource(baseUrl, getUserApiEndPoint);
//    }
    @Then("Verify users are displayed")
    public void verifyUsersAreDisplayed() {
        softAssert.assertThat(response.status()).isEqualTo(200);
        softAssert.assertThat(response.statusText()).isEqualTo("OK");
    }

    @When("I create a new airline")
    public void iCreateANewAirline() throws IOException {
        Airline airline = Airline.builder()
                .id(fakeDataUtils.getId())
                .name(fakeDataUtils.getName())
                .country(fakeDataUtils.getCountry())
                .logo("https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png")
                .slogan("\"From Sri Lanka\"")
                .head_quaters("\"Katunayake, Sri Lanka\"")
                .website("www.srilankaairways.com")
                .established("1990")
                .build();
        response = postResource(endPoint, airline);
        System.out.println(response.text());
    }

    @And("Verify airline is added")
    public void verifyAirlineIsAdded() {
        softAssert.assertThat(response.status()).isEqualTo(200);
        softAssert.assertThat(response.statusText()).isEqualTo("OK");
    }

    @When("I remove an airline")
    public void iRemoveAnAirline() throws IOException {
        response = deleteResource();
    }


    @Then("Verify airline is removed")
    public void verifyAirlineIsRemoved() {
        softAssert.assertThat(response.status()).isEqualTo(200);
        softAssert.assertThat(response.statusText()).isEqualTo("OK");
        softAssert.assertThat(response.text()).isEqualTo("Airline deleted successfully");
    }
}
