package pages;

import com.microsoft.playwright.Page;
import org.openqa.selenium.By;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        return page.title();
    }

    public LoginPage enterUsername(String userName) {
        page.locator("#user-name").type(userName);
        return this;
    }

    public void enterPassword(String password) {
        page.locator("#password").type(password);
    }

    public void clickLoginBtn() {
        page.locator("#login-button").click();
        new HomePage(page);
    }
}
