package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private WebDriver driver;

    @Given("User is at login page")
    public void userIsAtLoginPage() {
        Assert.assertEquals(driver.findElement(new LoginPage().getLoginPageTitle()).getText(),"Swag Labs", "Title is incorrect");
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
