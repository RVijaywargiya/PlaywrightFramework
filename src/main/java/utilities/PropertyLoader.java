package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private final Properties properties = new Properties();
    private final FileInputStream fis = new FileInputStream("src//main//resources//config//config.properties");

    public PropertyLoader() throws FileNotFoundException {
    }

    public String getPropertyFromConfig(String propertyName) throws IOException {
        properties.load(fis);
        return properties.getProperty(propertyName);
    }

}
