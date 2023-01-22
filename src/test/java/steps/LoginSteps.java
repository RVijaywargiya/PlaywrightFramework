package steps;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.PageFactory;

public class LoginSteps extends PageFactory {

    static LoginPage loginPage;
    static HomePage homePage;

    public LoginSteps() {
        Page page = getTlPage();
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

    @Then("User should be able to login successfully with {string}")
    public void userShouldBeAbleToLoginSuccessfullyWith(String arg0) {
        System.out.println("expected msg : " +arg0);
        if(arg0.equals("")) {
            Assert.assertEquals(homePage.getPageTitle(), "Swag Labs","Home Page title is incorrect");
            return;
        }
        Assert.assertEquals(loginPage.getErrorMessage(), arg0,"Error message is incorrect");
    }
}
