package com.github.m0levich.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfigReader implements ConfigReader {
    private final Properties properties = new Properties();

    public PropertiesConfigReader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream config = contextClassLoader.getResourceAsStream("config/config.properties")){
            properties.load(config);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
