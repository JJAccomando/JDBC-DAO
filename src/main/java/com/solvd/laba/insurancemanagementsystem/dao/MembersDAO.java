package com.solvd.laba.insurancemanagementsystem.dao;

import com.solvd.laba.insurancemanagementsystem.constants.SearchColumn;
import com.solvd.laba.insurancemanagementsystem.model.Members;

import java.sql.SQLException;

public interface MembersDAO extends GenericDAO<Members, Integer, String, SearchColumn> {

    void create(Members element) throws SQLException;

    Members findByPrimaryKey(Integer id) throws SQLException;

    Members findByUniqueColumn(SearchColumn column, String value) throws SQLException;

}
