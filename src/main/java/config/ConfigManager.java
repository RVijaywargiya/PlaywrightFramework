package config;

public final class ConfigManager {

    private ConfigManager() {
    }

    public static String baseUrl() {
        return System.getProperty(
                "baseUrl",
                "https://restful-booker.herokuapp.com"
        );
    }
}