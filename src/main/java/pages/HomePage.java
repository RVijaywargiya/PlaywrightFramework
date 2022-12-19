package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utilities.PageSetUp;

public class HomePage extends BasePage {
    private final Page page;

    public HomePage(Page page) {
        super(page);
        this.page = page;
    }

    public String getPageTitle() {
        return page.locator("\\title").textContent();
    }
}
