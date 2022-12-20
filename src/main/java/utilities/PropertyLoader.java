package utilities;

import config.ConfigurationManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertyLoader {
//    private final Properties properties = new Properties();
//    private final FileInputStream fis = new FileInputStream("src//main//resources//config//config.properties");

    public PropertyLoader() throws FileNotFoundException {
    }

    public String getPropertyFromConfig() throws IOException {
        return ConfigurationManager.configuration().baseUrl();
//        properties.load(fis);
//        return properties.getProperty(propertyName);
    }

}
