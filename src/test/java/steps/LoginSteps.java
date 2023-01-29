package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;
    private final HomePage homePage;

    /**
     * Dependency Injection
     * @param bt
     */
    public LoginSteps(BaseTest bt) {
        this.loginPage = bt.loginPage;
        this.homePage = bt.homePage;
    }

    @Given("User is at login page")
    public void userIsAtLoginPage() {
        System.out.println("At login page : " +Thread.currentThread().getId());
        Assert.assertEquals(loginPage.getPageTitle(),"Swag Labs", "Title is incorrect");
        System.out.println(Thread.currentThread().getId());
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
