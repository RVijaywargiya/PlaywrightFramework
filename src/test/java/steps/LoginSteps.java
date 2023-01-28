package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private final BaseTest bt;

    public LoginSteps(BaseTest bt) {
        this.bt = bt;
    }

    @Given("User is at login page")
    public void userIsAtLoginPage() {
        System.out.println("At login page : " +Thread.currentThread().getId());
        Assert.assertEquals(bt.loginPage.getPageTitle(),"Swag Labs", "Title is incorrect");
        System.out.println(Thread.currentThread().getId());
    }

    @And("Enter {string} and {string}")
    public void enterAnd(String arg0, String arg1) {
        bt.loginPage.enterUsername(arg0);
        bt.loginPage.enterPassword(arg1);
    }

    @When("Click on login button")
    public void clickOnLoginButton() {
        bt.loginPage.clickLoginBtn();
    }

    @Then("User should be able to login successfully with {string}")
    public void userShouldBeAbleToLoginSuccessfullyWith(String arg0) {
        System.out.println("expected msg : " +arg0);
        if(arg0.equals("")) {
            Assert.assertEquals(bt.homePage.getPageTitle(), "Swag Labs","Home Page title is incorrect");
            return;
        }
        Assert.assertEquals(bt.loginPage.getErrorMessage(), arg0,"Error message is incorrect");
    }
}
