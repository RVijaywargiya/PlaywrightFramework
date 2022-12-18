package steps;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.PageSetUp;

public class LoginSteps extends PageSetUp {

    private final Page page = getPage();

    LoginPage loginPage;
    HomePage homePage;

    public LoginSteps() {
        this.loginPage = new LoginPage(page);
        this.homePage = new HomePage(page);
    }


    @Given("User is at login page")
    public void userIsAtLoginPage() {
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs", "Title is incorrect");
    }

    @And("Enter username and password")
    public void enterUsernameAndPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        Assert.assertEquals(homePage.getPageTitle(), "Swag Labs","Home Page title is incorrect");
    }
}
