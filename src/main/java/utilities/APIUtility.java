package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class APIUtility {
    private Playwright playwright = Playwright.create();

    protected APIRequestContext request;
    protected APIResponse response;

    public APIResponse getResource(String pathParam) {
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://reqres.in/"));
        response = request.get(pathParam);
        return response;
    }
}
