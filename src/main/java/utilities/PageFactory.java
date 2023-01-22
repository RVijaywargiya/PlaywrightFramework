package utilities;

import com.microsoft.playwright.*;
import config.ConfigurationManager;

public class PageFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static synchronized Playwright getTlPlaywright() {
        return tlPlaywright.get();
    }

    public static void setPlaywright() {
        tlPlaywright.set(Playwright.create());
    }

    public static synchronized Browser getTlBrowser() {
        return tlBrowser.get();
    }

    private static final String browserType = ConfigurationManager.configuration().browser();

    public static void setTlBrowser(String browserType) {
        switch (browserType) {
            case "chrome" ->
                    tlBrowser.set(getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50)));
            case "edge" ->
                    tlBrowser.set(getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50)));
            default -> {
            }
        }
    }

    public static void setContext() {
        tlBrowserContext.set(getTlBrowser().newContext());
    }
    public static synchronized BrowserContext getTlBrowserContext() {
        return tlBrowserContext.get();
    }

    public static synchronized Page getTlPage() {
//        if(getTlPlaywright() == null) {
            setPlaywright();
            setTlBrowser(ConfigurationManager.configuration().browser());
            setContext();
            setPage();
//        }
        return tlPage.get();
    }

    public static void setPage() {
        tlPage.set(getTlBrowserContext().newPage());
    }

}
