package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest extends PageSetUp {

    private final Page page = getPage();

    @Before
    public void setUp() {
        try {
            maximize();
            page.navigate(new PropertyLoader().getBaseUrl());
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
