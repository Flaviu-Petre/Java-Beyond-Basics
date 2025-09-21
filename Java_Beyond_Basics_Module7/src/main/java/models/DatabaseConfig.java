package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private Properties properties;

    public DatabaseConfig(String filename) {
        properties = new Properties();
        try {
            var inputStream = getClass().getClassLoader().getResourceAsStream(filename);
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                try (FileInputStream input = new FileInputStream(filename)) {
                    properties.load(input);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
        }
    }

    public String getUrl() {
        return properties.getProperty("db.url", "");
    }

    public String getUsername() {
        return properties.getProperty("db.username", "");
    }

    public String getPassword() {
        return properties.getProperty("db.password", "");
    }

    public String getLogLevel() {
        return properties.getProperty("log.level", "INFO");
    }
}