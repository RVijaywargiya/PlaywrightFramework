package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps {
    @Given("User is at login page")
    public void userIsAtLoginPage() {
        System.out.println("j");
    }

    @And("Enter username and password")
    public void enterUsernameAndPassword() {
        
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
    }
}
