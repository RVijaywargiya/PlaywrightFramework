package pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Page page;

    public LoginPage(Page page) {
        super(page);
        this.page = page;
    }

    private String loginPageTitle = "//title";
    private String userNameXpath = "#user-name";
    private String passwordXpath = "#password";
    private String loginBtnXpath = "#login-button";

    private String lockedOutUserErrorMsgText = "//div[@class='error-message-container error']";

    public String getPageTitle() {
        return getElementText(loginPageTitle);
    }

    public void enterUsername(String userName) {
        enterText(userNameXpath,userName);
    }

    public void enterPassword(String password) {
        enterText(passwordXpath,password);
    }

    public void clickLoginBtn() {
        clickElement(loginBtnXpath);
    }

    public String getErrorMessage() {
        return getElementAttribute(lockedOutUserErrorMsgText, "innerText");
    }
}
