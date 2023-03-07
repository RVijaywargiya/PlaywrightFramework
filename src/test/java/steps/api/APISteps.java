package steps.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import utilities.PlaywrightFactory;

public class APISteps extends PlaywrightFactory {

    private Playwright playwright = Playwright.create();

    private APIRequestContext request;
    private APIResponse response;

    @Given("Get list of users")
    public void getListOfUsers() {
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://reqres.in/"));

        response = request.get("api/users?page=2");
        System.out.println(response.text());
    }
}
