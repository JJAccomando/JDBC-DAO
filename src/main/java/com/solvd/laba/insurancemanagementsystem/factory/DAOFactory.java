package com.solvd.laba.insurancemanagementsystem.factory;

import com.solvd.laba.insurancemanagementsystem.dao.MembersDAO;
import com.solvd.laba.insurancemanagementsystem.exceptions.DAOException;

import static com.solvd.laba.insurancemanagementsystem.constants.Constants.*;

public abstract class DAOFactory {

    public abstract MembersDAO getMembersDAO() throws DAOException;

    public static DAOFactory getDAOFactory(int factoryType) {
        switch (factoryType) {
            case MYSQL:
                return new MySQLDAOFactory();
            case ORACLE:
                return new OracleDAOFactory();
            case POSTGRESQL:
                return new PostgreSQLDAOFactory();
            default:
                return null;
        }
    }
}
