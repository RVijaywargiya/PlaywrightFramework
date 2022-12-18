package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;

public class BaseTest extends PageSetUp{

    private final Page page = PageSetUp.getPage();
//    public BaseTest(Page page) {
//        this.page = page;
//    }

//    private Page page = PageSetUp.getPage();

    @Before
    public void setUp() {
        try {
            page.navigate(new PropertyLoader().getPropertyFromConfig("url"));
            System.out.println(page.title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        page.close();
    }
}
