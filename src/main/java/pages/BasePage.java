package pages;

import com.microsoft.playwright.Page;

import java.awt.*;

public class BasePage {

    private static Page page;

    public BasePage(Page page) {
        BasePage.page = page;
    }
    String getElementText(String locator) {
        return page.locator(locator).textContent();
    }

    String getElementAttribute(String locator) {
        return page.locator(locator).getAttribute("innerText");
    }

    void enterText(String locator, String text) {
        page.locator(locator).type(text);
    }

    void clickElement(String locator) {
        page.locator(locator).click();
    }

    public static void maximize(Page page) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        page.setViewportSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
    }


}
