package com.solvd.laba.insurancemanagementsystem.dao.jdbc;

import com.solvd.laba.insurancemanagementsystem.connection.DBConnection;
import com.solvd.laba.insurancemanagementsystem.constants.AgeGroup;
import com.solvd.laba.insurancemanagementsystem.dao.MembersDAO;
import com.solvd.laba.insurancemanagementsystem.exceptions.DAOException;
import com.solvd.laba.insurancemanagementsystem.model.Members;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

import static com.solvd.laba.insurancemanagementsystem.constants.Constants.*;
import static com.solvd.laba.insurancemanagementsystem.utilities.DAOUtilities.prepareStatement;

public class MySQLMembersDAO implements MembersDAO {
    @Override
    public void create(Members member) throws SQLException {
        if (member.getId() != null) {
            throw new IllegalArgumentException("Member is already created. Member already has ID");
        }
        Object[] values = {member.getFirstName(), member.getLastName(), member.getPhoneNum(), member.getEmail(), member.getDateOfBirth(), member.getAgeGroup().getId()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values)) {
            statement.executeUpdate();
            try (ResultSet generateKeys = statement.getGeneratedKeys()) {
                if (generateKeys.next()) {
                    member.setId(generateKeys.getInt(1));
                } else {
                    throw new DAOException("Error: New member creation failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error: New member creation failed.");
        }
    }

    @Override
    public Members findById(Integer id) { return findInt(id); }

    @Override
    public Members findByEmail(String email) { return findString(email); }

    private Members findInt(Object... values) throws DAOException {
        Members member = null;
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_ID, false, values);
            ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                member = getMembersFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("Error: Could not retrieve member information.");
        }
        return member;
    }

    private Members findString(Object... values) throws DAOException {
        Members member = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = prepareStatement(connection, SQL_FIND_BY_EMAIL, false, values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                member = getMembersFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("Error: Could not retrieve member information.");
        }
        return member;
    }

    private Members getMembersFromResultSet(ResultSet resultSet) throws SQLException {
        Members member = new Members();
        member.setId(resultSet.getInt("member_id"));
        member.setFirstName(resultSet.getString("first_name"));
        member.setLastName(resultSet.getString("last_name"));
        member.setPhoneNum(resultSet.getString("phone_number"));
        member.setEmail(resultSet.getString("email"));
        member.setDateOfBirth(resultSet.getDate("date_of_birth"));
        int age = calculateAge(member.getDateOfBirth());
        member.setAgeGroup(determineAgeGroup(age));
        return member;
    }

    private int calculateAge(Date date) {
        LocalDate localDate = date.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(localDate, currentDate).getYears();
    }

    private AgeGroup determineAgeGroup(int age) {
        if (age < 13) {
            return AgeGroup.CHILD;
        } else if (age < 18) {
            return AgeGroup.YOUTH;
        } else if (age < 26) {
            return AgeGroup.YOUNG_ADULT;
        } else if (age < 65) {
            return AgeGroup.ADULT;
        } else {
            return AgeGroup.SENIOR;
        }
    }

}
