package steps.api;

import com.microsoft.playwright.APIResponse;
import io.cucumber.java.en.Given;
import utilities.APIUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APISteps extends APIUtility {

    Properties properties = new Properties();

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
