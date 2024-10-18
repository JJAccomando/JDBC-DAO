package com.solvd.laba.insurancemanagementsystem.dao;

import java.sql.SQLException;

public interface GenericDAO <T, V> {

    void create(T element) throws SQLException;

    T findById(V id) throws SQLException;

}

