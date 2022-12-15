import com.microsoft.playwright.*;
import utilities.PropertyLoader;

import java.awt.*;
import java.util.Properties;

public class PlaywrightPractice {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate(new Properties().getProperty("url"));
            System.out.println(page.title());
        }
    }
}
