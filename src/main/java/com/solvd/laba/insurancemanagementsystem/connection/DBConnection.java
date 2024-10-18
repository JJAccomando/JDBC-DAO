package com.solvd.laba.insurancemanagementsystem.connection;

import com.solvd.laba.insurancemanagementsystem.utilities.DAOProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.solvd.laba.insurancemanagementsystem.constants.Constants.*;

public class DBConnection {

    private static DBConnection instance;

    DAOProperties properties = new DAOProperties(PROPERTY_KEY_NAME);

    private final String url = properties.getProperty(PROPERTY_URL, true);

    private final String password = properties.getProperty(PROPERTY_PASSWORD, false);

    private final String user = properties.getProperty(PROPERTY_USERNAME, password != null);


    private DBConnection() {
        try {
            String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return DriverManager.getConnection(instance.url, instance.user, instance.password);
    }

}
