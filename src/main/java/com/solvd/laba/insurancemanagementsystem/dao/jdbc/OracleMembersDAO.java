package com.solvd.laba.insurancemanagementsystem.dao.jdbc;

import com.solvd.laba.insurancemanagementsystem.dao.MembersDAO;
import com.solvd.laba.insurancemanagementsystem.model.Members;

import java.sql.SQLException;

public class OracleMembersDAO implements MembersDAO {
    @Override
    public void create(Members element) throws SQLException {}

    @Override
    public Members findById(Integer id) {
        return null;
    }

    @Override
    public Members findByEmail(String email) { return null; }
}
