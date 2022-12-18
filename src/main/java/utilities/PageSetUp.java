package utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageSetUp {
    private static Page page;
    private static Playwright getPlaywright() {
        return Playwright.create();
    }

    private static Browser getBrowser() {
        return getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
    }

    public static Page getPage() {
        if (page == null) {
            page = getBrowser().newPage();
        }
        return page;
    }

}
