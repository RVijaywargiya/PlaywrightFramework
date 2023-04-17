package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIUtility {
    private Playwright playwright = Playwright.create();

    protected APIRequestContext request;
    protected APIResponse response;

    Properties properties = new Properties();

    private void loadPropertyFile() throws IOException {
        String filePath = "src/main/resources/api.properties";
        properties.load(new FileInputStream(filePath));
    }

    public String getProperty(String propertyName) throws IOException {
        loadPropertyFile();
        return properties.getProperty(propertyName);
    }

    public APIResponse getResource(String baseUrl, String pathParam) {
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(baseUrl));
        response = request.get(pathParam);
        return response;
    }
}
