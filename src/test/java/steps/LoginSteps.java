package steps;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.PageSetUp;

public class LoginSteps extends PageSetUp {

    static private final Page page = getPage();

    static LoginPage loginPage;
    static HomePage homePage;

    public LoginSteps() {
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }


    @Given("User is at login page")
    public void userIsAtLoginPage() {
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs", "Title is incorrect");
    }

    @And("Enter {string} and {string}")
    public void enterAnd(String arg0, String arg1) {
        loginPage.enterUsername(arg0);
        loginPage.enterPassword(arg1);
    }

    @When("Click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() throws InterruptedException {
        Assert.assertEquals(homePage.getPageTitle(), "Swag Labs","Home Page title is incorrect");
    }

    @Then("User should be able to login successfully with {string}")
    public void userShouldBeAbleToLoginSuccessfullyWith(String arg0) {
        if(arg0.equals("")) {
            Assert.assertEquals(homePage.getPageTitle(), "Swag Labs","Home Page title is incorrect");
            return;
        }
        Assert.assertEquals(arg0,loginPage.getErrorMessage()," Error message is incorrect");
    }
}
