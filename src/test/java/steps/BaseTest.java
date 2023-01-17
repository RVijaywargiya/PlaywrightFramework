package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import pages.BasePage;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.awt.*;
import java.io.IOException;


public class BaseTest extends PageSetUp {

    @Before
    public void setUp() {
        try {
            Page page = getPage();
            BasePage.maximize(page);
            page.navigate(new PropertyLoader().getBaseUrl());
            System.out.println(getPage().title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @After
//    public void tearDown() {
//        page.close();
//    }
}
