package com.solvd.laba.insurancemanagementsystem.services;

import com.solvd.laba.insurancemanagementsystem.dao.MembersDAO;
import com.solvd.laba.insurancemanagementsystem.exceptions.DAOException;
import com.solvd.laba.insurancemanagementsystem.factory.DAOFactory;
import com.solvd.laba.insurancemanagementsystem.model.Members;

import java.sql.SQLException;

public class MembersService {

    private final MembersDAO membersDAO;

    public MembersService(DAOFactory daoFactory) throws DAOException {
        this.membersDAO = daoFactory.getMembersDAO();
    }

    public void createMembers(Members member) throws SQLException {
        membersDAO.create(member);
    }

    public Members getMember(Integer id) {
        return membersDAO.findById(id);
    }

    public Members getMember(String email) {
        return membersDAO.findByEmail(email);
    }

}
