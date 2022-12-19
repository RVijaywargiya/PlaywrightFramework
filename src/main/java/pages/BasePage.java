package pages;

import com.microsoft.playwright.Page;

public class BasePage {

    private static Page page;

    public BasePage(Page page) {
        BasePage.page = page;
    }
    String getElementText(String locator) {
        return page.locator(locator).textContent();
    }

    void enterText(String locator, String text) {
        page.locator(locator).type(text);
    }

    void clickElement(String locator) {
        page.locator(locator).click();
    }

}