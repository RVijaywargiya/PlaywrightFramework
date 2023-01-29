package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.PlaywrightFactory;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp() throws IOException {
        pf = new PlaywrightFactory();
        page = pf.initBrowser();
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @After
    public void tearDown() {
        page.context().browser().close();
    }
}
