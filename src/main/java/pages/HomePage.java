package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        return page.title();
    }
}
