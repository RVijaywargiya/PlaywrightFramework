package utilities;

import com.microsoft.playwright.*;
import config.ConfigurationManager;

import java.awt.*;

public class PageSetUp {
    private static final ThreadLocal<Page> page = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return playwright.get();
    }

    public static void setPlaywright() {
        playwright.set(Playwright.create());
    }

    public static Browser getBrowser() {
        return browser.get();
    }

    private static final String browserType = ConfigurationManager.configuration().browser();

    public static void setBrowser(String browserType) {
        switch (browserType) {
            case "chrome" ->
                    browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50)));
            case "edge" ->
                    browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50)));
            default -> {
            }
        }
    }

    public static void setContext() {
        context.set(getBrowser().newContext());
    }
    public static BrowserContext getContext() {
        return context.get();
    }

    public static Page getPage() {
        if(getPlaywright() == null) {
            setPlaywright();
            setBrowser(ConfigurationManager.configuration().browser());
            setContext();
            setPage();
        }
        return page.get();
    }

    public static void setPage() {
        page.set(getContext().newPage());
    }

    public static void maximize() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        getPage().setViewportSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
    }

}
