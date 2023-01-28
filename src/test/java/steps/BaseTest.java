package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import pages.BasePage;
import utilities.PageFactory;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest {

    static PageFactory pf = new PageFactory();

    static Page page;

    @Before
    public void setUp() throws IOException {
        page = PageFactory.initBrowser();
        page.navigate(new PropertyLoader().getBaseUrl());
        BasePage.maximize(page);
    }

//    public void tearDown() {
//        page.context().browser().close();
//    }
}
