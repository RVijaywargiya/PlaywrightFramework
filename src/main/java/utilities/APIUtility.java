package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class APIUtility {
    private Playwright playwright = Playwright.create();

    protected APIRequestContext request;
    protected APIResponse response;

    public APIResponse getResource(String baseUrl, String pathParam) {
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(baseUrl));
        response = request.get(pathParam);
        return response;
    }
}
