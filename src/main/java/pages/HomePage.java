package pages;

import com.microsoft.playwright.Page;

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
