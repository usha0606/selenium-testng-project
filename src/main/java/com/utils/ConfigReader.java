package com.utils;

import java.util.Properties;
import java.io.FileInputStream;

public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";  

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(CONFIG_FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE_PATH);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }   

    public static String getBrowser() {
        return getProperty("browser");
    }
    
    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }

    public static String getUrl() {
        return getProperty("url");
    }
}
