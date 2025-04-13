package utilities;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class APIUtility {
    private final Playwright playwright = Playwright.create();

    protected APIResponse response;

    Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(APIUtility.class);

    public APIRequestContext getApiRequestContext() throws IOException {
        TestReporter.setupReports();
        TestReporter.startTest("My Test");
        return playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(getPropertyFromPropertyFile("baseUrl")));
    }

    private void loadPropertyFile() throws IOException {
        String filePath = "src/main/resources/api.properties";
        properties.load(new FileInputStream(filePath));
    }

    public String getPropertyFromPropertyFile(String propertyName) throws IOException {
        loadPropertyFile();
        return properties.getProperty(propertyName);
    }

    public APIResponse get(String pathParamGet) throws IOException {
        response = getApiRequestContext().get(pathParamGet);
        return response;
    }

    public APIResponse postResource(String pathParam, Object obj) throws IOException {
        logger.info("Invoking POST call with end point as : " + pathParam);
        Map<String, String> data = new HashMap<>();
        return getApiRequestContext().post(pathParam,RequestOptions.create().setData(obj));
    }

    protected APIResponse deleteResource() throws IOException {
        logger.info("Invoking DELETE call with Base URL" + "and end point as : " + "pathParamDelete");
        return getApiRequestContext().delete("pathParamDelete");
    }
}
