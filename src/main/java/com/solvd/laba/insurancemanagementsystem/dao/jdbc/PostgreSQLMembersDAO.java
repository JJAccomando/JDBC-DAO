package com.solvd.laba.insurancemanagementsystem.dao.jdbc;

import com.solvd.laba.insurancemanagementsystem.constants.SearchColumn;
import com.solvd.laba.insurancemanagementsystem.dao.MembersDAO;
import com.solvd.laba.insurancemanagementsystem.model.Members;

import java.sql.SQLException;

public class PostgreSQLMembersDAO implements MembersDAO {
    @Override
    public void create(Members element) throws SQLException {}

    @Override
    public Members findByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Members findByUniqueColumn(SearchColumn column, String value) throws SQLException { return null; }

}
