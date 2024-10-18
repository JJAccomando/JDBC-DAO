package com.solvd.laba.insurancemanagementsystem.model;

import com.solvd.laba.insurancemanagementsystem.constants.AgeGroup;

import java.sql.Date;

public class Members {
    private Integer memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private Date dateOfBirth;
    private AgeGroup ageGroup;

    public Integer getId() { return memberId; }

    public void setId(Integer memberId) { this.memberId = memberId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName;}

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNum() { return phoneNum; }

    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }

    public java.sql.Date getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public AgeGroup getAgeGroup() { return ageGroup; }

    public void setAgeGroup(AgeGroup ageGroup) { this.ageGroup = ageGroup; }

    @Override
    public boolean equals(Object other) {
        if ((other instanceof Members) && (memberId != null)) {
            return memberId.equals(((Members) other).memberId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (memberId != null) {
            return this.getClass().hashCode() + memberId.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Member[ID: %d, Name: %s %s, Email: %s, Phone Number: %s]", memberId, firstName, lastName, email, phoneNum);
    }
}
