package bdd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static Properties properties;
    public TestProperties(String FilePath) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FilePath)){
            if (inputStream == null) {
                throw new IOException("Properties " + FilePath + " not found!");
            }
            properties = new Properties();
            properties.load(inputStream);
            System.out.println("Properties \"" + FilePath + "\" successfully loaded.");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
