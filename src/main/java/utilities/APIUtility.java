package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class APIUtility {
    private final Playwright playwright = Playwright.create();

    protected APIResponse response;

    Properties properties = new Properties();

    public APIRequestContext getApiRequestContext() throws IOException {
        return playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(getProperty("baseUrl")));
    }

    private void loadPropertyFile() throws IOException {
        String filePath = "src/main/resources/api.properties";
        properties.load(new FileInputStream(filePath));
    }

    public String getProperty(String propertyName) throws IOException {
        loadPropertyFile();
        return properties.getProperty(propertyName);
    }

    public APIResponse getResource(String baseUrl, String pathParam) throws IOException {
        response = getApiRequestContext().get(pathParam);
        return response;
    }

    public APIResponse postResource(String pathParam) throws IOException {
        Map<String, String> data = new HashMap<>();
        data.put("name","morpheus");
        data.put("job","leader");
        return getApiRequestContext().post(pathParam,RequestOptions.create().setData(data));
    }
}
