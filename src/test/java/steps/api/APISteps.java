package steps.api;

import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import utilities.APIUtility;
import utilities.PlaywrightFactory;
import utilities.PropertyLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class APISteps extends APIUtility {

    Properties properties = new Properties();
//    public Properties getProperty() throws IOException {
//        properties.load(new FileInputStream("src/main/resources/api.properties"));
//        return properties;
//    }

    @Given("Get list of users")
    public void getListOfUsers() throws IOException {
        properties.load(new FileInputStream("src/main/resources/api.properties"));
        APIResponse response = new APIUtility().getResource(properties.getProperty("pathParam"));
        System.out.println(response.text());
    }

    @Given("Add user")
    public void addUser() {

    }
}
