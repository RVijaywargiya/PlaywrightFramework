package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.PageFactory;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest {
    Page page;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void setUp() throws IOException {
        page = new PageFactory().initBrowser();
        page.navigate(new PropertyLoader().getBaseUrl());
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        BasePage.maximize(page);
    }
}
