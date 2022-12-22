package utilities;

import com.microsoft.playwright.*;
import config.ConfigurationManager;

import java.awt.*;

public class PageSetUp {
    private static Page page;
    private static Browser browser;

    private static Playwright getPlaywright() {
        return Playwright.create();
    }

    private static final String browserType = ConfigurationManager.configuration().browser();

    private static Browser getBrowser() {
        if (browser == null)
        {
            switch (browserType) {
                case "chrome" ->
                        browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50));
                case "edge" ->
                        browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50));
                default -> {
                }
            }
        }

    return browser;
    }

    public static Page getPage() {
        if (page == null) {
            page = getBrowser().newPage();
        }
        return page;
    }

    public static void maximize() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        page.setViewportSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
    }

}
