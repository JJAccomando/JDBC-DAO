package com.solvd.laba.insurancemanagementsystem;


import com.solvd.laba.insurancemanagementsystem.constants.SearchColumn;
import com.solvd.laba.insurancemanagementsystem.factory.DAOFactory;
import com.solvd.laba.insurancemanagementsystem.model.Members;
import com.solvd.laba.insurancemanagementsystem.services.MembersService;
import org.junit.*;


import java.sql.SQLException;


import static com.solvd.laba.insurancemanagementsystem.constants.Constants.MYSQL;

public class DAOTest {

    private static final Members MEMBER;

    static {
            MEMBER = new Members();
            MEMBER.setFirstName("William");
            MEMBER.setLastName("Heart");
            MEMBER.setPhoneNum("5551235555");
            MEMBER.setEmail("will.heart@example.com");
            MEMBER.setDateOfBirth("1945-03-16");
        }

    @Test
    public void createMembers() throws SQLException {
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(MYSQL);
        MembersService membersService = new MembersService(mySQLFactory);
        System.out.println("DAOFactory successfully obtained: " + mySQLFactory);
        membersService.createMembers(MEMBER);
        System.out.println("Member successfully created.");
        Members memberById = membersService.getMember(MEMBER.getId());
        if (memberById == null)
            throw new AssertionError("Error: Member not found by ID.");
        checkMembers(memberById);
        Members memberByEmail = membersService.getMember(SearchColumn.EMAIL, MEMBER.getEmail());
        if (memberByEmail == null)
            throw new AssertionError("Error: Member not found by email.");
        checkMembers(memberByEmail);
        Members memberByPhone = membersService.getMember(SearchColumn.PHONE_NUM, MEMBER.getPhoneNum());
        if (memberByPhone == null)
            throw new AssertionError("Error: Member not found by phone number.");
        checkMembers(memberByPhone);
    }

    private void checkMembers(Members member) {
        Assert.assertEquals("Members first name must match.", MEMBER.getFirstName(), member.getFirstName());
        Assert.assertEquals("Members last name must match.", MEMBER.getLastName(), member.getLastName());
        Assert.assertEquals("Members phone number must match.", MEMBER.getPhoneNum(), member.getPhoneNum());
        Assert.assertEquals("Members email must match.", MEMBER.getEmail(), member.getEmail());
        Assert.assertEquals("Members date of birth must match.", MEMBER.getDateOfBirth().toString(), member.getDateOfBirth().toString());
        Assert.assertEquals("Members age group must match.", MEMBER.getAgeGroup().toString(), member.getAgeGroup().toString());
    }

}
