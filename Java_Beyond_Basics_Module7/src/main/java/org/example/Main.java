package org.example;

import models.AppLogger;
import models.DatabaseConfig;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConfig config = new DatabaseConfig("db.properties");

            AppLogger logger = new AppLogger(config.getLogLevel());

            logger.log("INFO", "Database URL: " + config.getUrl());
            logger.log("INFO", "Username: " + config.getUsername());
            logger.log("CONFIG", "Configuration loaded successfully");
            logger.log("FINE", "This is a fine-level debug message");

            logger.log("SEVERE", "This is a severe error message");
            logger.log("WARNING", "This is a warning message");
            logger.log("FINEST", "This finest message may not show depending on log level");

        } catch (Exception e) {
            System.err.println("Application error: " + e.getMessage());
        }
    }
}