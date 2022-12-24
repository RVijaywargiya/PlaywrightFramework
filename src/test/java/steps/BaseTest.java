package steps;


import com.microsoft.playwright.Page;

import io.cucumber.java.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest extends PageSetUp {

    static private final Page page = getPage();

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
