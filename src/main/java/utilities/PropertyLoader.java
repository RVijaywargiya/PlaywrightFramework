package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyLoader {
    public static String getProperty(String propertyName) throws FileNotFoundException {
        return new Properties(new FileInputStream("")).getProperty(propertyName);
    }

}
