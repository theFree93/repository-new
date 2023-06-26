package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    private static final String PATH_TO_PROPERTIES_FILE = "src/main/resources/";

    public static String loadingProperties(String fileName, Enum variable) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH_TO_PROPERTIES_FILE + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(String.valueOf(variable));
    }
}
