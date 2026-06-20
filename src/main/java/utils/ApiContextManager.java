package utils;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public final class ApiContextManager {

    private static final Playwright PLAYWRIGHT =
            Playwright.create();

    private static final APIRequestContext API_CONTEXT =
            PLAYWRIGHT.request().newContext();

    private ApiContextManager() {
    }

    public static APIRequestContext context() {
        return API_CONTEXT;
    }
}