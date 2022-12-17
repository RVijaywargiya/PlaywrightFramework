package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage = new LoginPage(page);
    HomePage homePage = new HomePage(page);

    @Given("User is at login page")
    public void userIsAtLoginPage() {
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs", "Title is incorrect");
    }

    @And("Enter username and password")
    public void enterUsernameAndPassword() {
        loginPage.enterUsername("standard_user").enterPassword("secret_sauce");
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        Assert.assertEquals(homePage.getPageTitle(), "Swag Labs", "Home [age title is incorrect");
    }
}
