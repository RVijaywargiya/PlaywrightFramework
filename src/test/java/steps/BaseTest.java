package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import utilities.PageFactory;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest {

    protected static Page page;

    @Before
    public void setUp() {
        try {
            page = PageFactory.getTlPage();
            System.out.println("Thread ID : " + Thread.currentThread().getId());
            BasePage.maximize(page);
            page.navigate(new PropertyLoader().getBaseUrl());
            System.out.println(page.title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
