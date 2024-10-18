package com.solvd.laba.insurancemanagementsystem.dao;

import com.solvd.laba.insurancemanagementsystem.model.Members;

import java.sql.SQLException;

public interface MembersDAO extends GenericDAO<Members, Integer> {

    void create(Members element) throws SQLException;

    Members findById(Integer id) throws SQLException;

    Members findByEmail(String email) throws SQLException;

}
