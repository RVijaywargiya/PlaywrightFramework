package steps.api;

import com.microsoft.playwright.APIResponse;
import factory.LoggerFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Builder;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
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

    private final Logger logger = LoggerFactory.initLogger();

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

    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() throws IOException {
        logger.info("Getting Base URL and endpoint from property file");
        baseUrl = getPropertyFromPropertyFile("baseUrl");
        endPoint = getPropertyFromPropertyFile("pathParamPost");
    }

    @Then("Verify users are displayed")
    public void verifyUsersAreDisplayed() {
        softAssert.assertThat(response.status()).isEqualTo(200);
        softAssert.assertThat(response.statusText()).isEqualTo("OK");
    }

    @When("I create a new airline")
    public void iCreateANewAirline() throws IOException {
        logger.info("Building payload to create airline");
        Airline airline = Airline.builder()
                .id(fakeDataUtils.getId())
                .name(fakeDataUtils.getName())
                .country(fakeDataUtils.getCountry())
                .logo("https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png")
                .slogan("From" + fakeDataUtils.getCountry())
                .head_quaters(fakeDataUtils.getCity() + ", " +fakeDataUtils.getCountry())
                .website("www."+ fakeDataUtils.getCountry() + "airways.com")
                .established(fakeDataUtils.getYear())
                .build();
        logger.info("Initiating POST call");
        response = postResource(endPoint, airline);
        logger.info("POST call completed");
        System.out.println(response.text());
        System.out.println("LOG LEVEL : "+logger.getLevel());
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

    @When("I get airline details")
    public void iGetAirlineDetails() throws IOException {
        logger.info("Getting airline data");
        response = getResource(getPropertyFromPropertyFile("pathParamGet"));
    }

    @Then("I should see airline details")
    public void iShouldSeeAirlineDetails() {
        logger.info("Verify GET airline details call happens successfully");
        Assert.assertEquals(response.status(),200, "Response code " + response.status() + "is incorrect");
        System.out.println(response.status());
        System.out.println(response.text());
    }
}
