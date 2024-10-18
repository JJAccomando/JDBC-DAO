package com.solvd.laba.insurancemanagementsystem.factory;

import com.solvd.laba.insurancemanagementsystem.dao.MembersDAO;
import com.solvd.laba.insurancemanagementsystem.dao.jdbc.OracleMembersDAO;
import com.solvd.laba.insurancemanagementsystem.exceptions.DAOException;

public class OracleDAOFactory extends DAOFactory {
    @Override
    public MembersDAO getMembersDAO() throws DAOException {
        return new OracleMembersDAO();
    }
}
