package utilities;

import config.ConfigurationManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertyLoader {

    public PropertyLoader() throws FileNotFoundException {
    }

    public String getBaseUrl() throws IOException {
        return ConfigurationManager.configuration().baseUrl();
    }

}
