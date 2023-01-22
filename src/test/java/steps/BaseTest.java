package steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import pages.BasePage;
import utilities.PageFactory;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest extends PageFactory {

//    private Page page;

    @Before
    public void setUp() {
        try {
//            Page page = getTlPage();
            System.out.println("Thread ID : " + Thread.currentThread().getId());
            BasePage.maximize(getTlPage());
            getTlPage().navigate(new PropertyLoader().getBaseUrl());
            System.out.println(getTlPage().title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @After
//    public void tearDown() {
//        page.close();
//    }
}
