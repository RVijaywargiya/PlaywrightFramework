package utilities;

import com.microsoft.playwright.*;
import config.ConfigurationManager;
import pages.BasePage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static  Playwright getTlPlaywright() {
        return tlPlaywright.get();
    }

    public static void setTlPlaywright() {
        tlPlaywright.set(Playwright.create());
    }

    public static  Browser getTlBrowser() {
        return tlBrowser.get();
    }

    private static final String browserType = ConfigurationManager.configuration().browser();

    public static void setTlBrowser(String browserType) {
        switch (browserType) {
            case "chrome" -> {
                tlBrowser.set(getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50)));
                break;
            }
            case "edge" -> {
                tlBrowser.set(getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50)));
                break;
            }
            default -> {
            }
        }
    }

    public static void setTlContext() {
        tlBrowserContext.set(getTlBrowser().newContext());
    }
    public static  BrowserContext getTlContext() {
        return tlBrowserContext.get();
    }

    public Page initBrowser() throws IOException {
        setTlPlaywright();
        setTlBrowser(ConfigurationManager.configuration().browser());
        setTlContext();
        setTlPage();
        getTlPage().navigate(new PropertyLoader().getBaseUrl());
        BasePage.maximize(getTlPage());
        return getTlPage();
    }

    public static void setTlPage() {
        tlPage.set(getTlContext().newPage());
    }

    public static Page getTlPage() {
        return tlPage.get();
    }
}
