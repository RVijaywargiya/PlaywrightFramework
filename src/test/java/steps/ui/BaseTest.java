package steps.ui;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.*;
import pages.HomePage;
import pages.LoginPage;
import factory.PlaywrightFactory;

import java.io.IOException;
import java.nio.file.Paths;


public class BaseTest {

    PlaywrightFactory pf;
    BrowserContext context;
    Page page;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp() throws IOException {
        pf = new PlaywrightFactory();
        page = pf.initBrowser();
        PlaywrightFactory.getTlContext().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @After
    public void tearDown() {
        PlaywrightFactory.getTlContext().tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        page.context().browser().close();
    }
}
