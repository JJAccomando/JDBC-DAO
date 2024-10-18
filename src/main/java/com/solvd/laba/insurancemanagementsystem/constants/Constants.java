package com.solvd.laba.insurancemanagementsystem.constants;

public class Constants {

    public static final String PROPERTIES_FILE = "dao.properties";

    public static final String PROPERTY_DRIVER = "driver";

    public static final String PROPERTY_URL = "url";

    public static final String PROPERTY_USERNAME = "user";

    public static final String PROPERTY_PASSWORD = "password";

    public static final String PROPERTY_KEY_NAME = "mySQL";

    public static final String SQL_INSERT = "INSERT INTO members (first_name, last_name, phone_number, email, date_of_birth, member_age_group_id) VALUES (?, ?, ?, ?, ?, ?);";

    public static final String SQL_FIND_BY_ID = "SELECT * FROM members WHERE member_id = ?;";

    public static final String SQL_FIND_BY_EMAIL = "SELECT * FROM members WHERE email = ?;";

    public static final String SQL_FIND_BY_PHONE = "SELECT * FROM members WHERE phone_number = ?;";

    public static final int MYSQL = 1;

    public static final int ORACLE = 2;

    public static final int POSTGRESQL = 3;

}
