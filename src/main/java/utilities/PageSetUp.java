package utilities;

import com.microsoft.playwright.*;

import java.awt.*;

public class PageSetUp {
    private static Page page;
    private static Browser browser;

    private static Playwright getPlaywright() {
        return Playwright.create();
    }

    private static Browser getBrowser() {
        if (browser == null) {
            browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
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
