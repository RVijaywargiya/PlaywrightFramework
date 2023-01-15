package steps;

import io.cucumber.java.*;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;


public class BaseTest extends PageSetUp {

    @Before
    public void setUp() {
        try {
            maximize();
            getPage().navigate(new PropertyLoader().getBaseUrl());
            System.out.println(getPage().title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        getPage().close();
    }
}
