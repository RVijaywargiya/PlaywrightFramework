package utilities;

import com.microsoft.playwright.*;

public class PageSetUp {
    private static Page page;
    private static Browser browser;

    private static BrowserContext browserContext;
    private static Playwright getPlaywright() {
        return Playwright.create();
    }

    private static Browser getBrowser() {
        if (browser == null) {
            browser = getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        }
        return browser;
    }

    public static BrowserContext getBrowserContext() {
        if (browserContext == null) {
            browserContext = getBrowser().newContext();
        }
        return browserContext;
    }

    public static Page getPage() {
        if (page == null) {
            page = getBrowser().newPage();
        }
        return page;
    }

}
