package steps;


import com.microsoft.playwright.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest extends PageSetUp {

    private final Page page = getPage();

    @Before
    public void setUp() {
        try {
            maximize();
            page.navigate(new PropertyLoader().getPropertyFromConfig());
            System.out.println(page.title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        page.locator("//button[@id='react-burger-menu-btn']").click();
        page.locator("//a[@id='logout_sidebar_link']").click();
    }
}
