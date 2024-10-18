package com.solvd.laba.insurancemanagementsystem.utilities;

import com.solvd.laba.insurancemanagementsystem.exceptions.DAOConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import static com.solvd.laba.insurancemanagementsystem.constants.Constants.PROPERTIES_FILE;

public class DAOProperties {

private static final Properties PROPERTIES = new Properties();

private final String propertyKeyName;

static {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

    if (propertiesFile == null) {
        throw new DAOConfigurationException("Error: Properties file '" + PROPERTIES_FILE + "' is not found.");
    }

    try {
        PROPERTIES.load(propertiesFile);
    } catch (IOException e) {
        throw new DAOConfigurationException("Error: Unable to load properties file '" + PROPERTIES_FILE + "'.");
    }
}

public DAOProperties(String propertyKeyName) throws DAOConfigurationException {
    this.propertyKeyName = propertyKeyName;
}

public String getProperty(String key, boolean required) throws DAOConfigurationException {
    String fullKey = propertyKeyName + "." + key;
    String property = Optional.ofNullable(PROPERTIES.getProperty(fullKey))
            .map(String::trim)
            .filter(value -> !value.isEmpty())
            .orElse(null);

    if (required && property == null) {
        throw new DAOConfigurationException("Required property '" + fullKey + "' is missing in properties file '" + PROPERTIES_FILE + "'.");
    }

    return property;
}

}
