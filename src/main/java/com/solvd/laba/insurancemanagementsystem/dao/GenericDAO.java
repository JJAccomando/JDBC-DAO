package com.solvd.laba.insurancemanagementsystem.dao;

import java.sql.SQLException;

public interface GenericDAO <T, V, U, S> {

    void create(T element) throws SQLException;

    T findByPrimaryKey(V value) throws SQLException;

    T findByUniqueColumn(S column, U value) throws SQLException;

}

