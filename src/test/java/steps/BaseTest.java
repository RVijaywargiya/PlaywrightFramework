package steps;


import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.PageSetUp;
import utilities.PropertyLoader;

import java.io.IOException;
import java.nio.file.Paths;

public class BaseTest extends PageSetUp{

    private final Page page = getPage();
    private final BrowserContext browserContext = getBrowserContext();

    @Before
    public void setUp() {
        try {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));
            page.navigate(new PropertyLoader().getPropertyFromConfig("url"));
            System.out.println(page.title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }
}
