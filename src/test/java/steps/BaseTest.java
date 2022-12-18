package steps;


import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;

public class BaseTest extends PageSetUp{

    private final Page page = getPage();

    @Before
    public void setUp() {
        try {
            page.navigate(new PropertyLoader().getPropertyFromConfig("url"));
            System.out.println(page.title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @After
//    public void tearDown() {
//        page.close();
//    }
}
