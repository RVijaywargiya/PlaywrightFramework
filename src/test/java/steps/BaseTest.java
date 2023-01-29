package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.PlaywrightFactory;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest {
    Page page;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void setUp() throws IOException {
        page = new PlaywrightFactory().initBrowser();
        page.navigate(new PropertyLoader().getBaseUrl());
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        BasePage.maximize(page);
    }
}
