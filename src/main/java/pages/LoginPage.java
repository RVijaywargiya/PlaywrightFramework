package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.openqa.selenium.By;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        return page.locator("//title").textContent();
    }

    public void enterUsername(String userName) {
        page.locator("#user-name").type(userName);
    }

    public void enterPassword(String password) {
        page.locator("#password").type(password);
    }

    public void clickLoginBtn() {
        page.locator("#login-button").click();
    }

    public String getErrorMessage() {
        return page.locator("//h3[@data-test='error']").textContent();
    }
}
