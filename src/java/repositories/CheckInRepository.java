/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;


import config.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.CheckIn;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author Dell
 */
public class CheckInRepository {

    public static List<CheckIn> select() throws SQLException {
        List<CheckIn> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(" select ci.checkInID, ci.checkInTime, ci.userID, u.fullName \n"
                + " from CheckIn as ci left join Users as u \n"
                + " on ci.userID =u.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            CheckIn checkIn = new CheckIn();
            checkIn.setCheckInID(rs.getInt("checkInID"));
            checkIn.setCheckInTime(rs.getTimestamp("checkInTime"));
            checkIn.setUserID(rs.getInt("userID"));
            checkIn.setFullName(rs.getString("fullName"));
            list.add(checkIn);
        }
        con.close();
        return list;
    }
     public void create(CheckIn checkIn) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into CheckIn values(?, ?)");
        stm.setString(1, sdfDateTime.format(checkIn.getCheckInTime()));
        stm.setInt(2, checkIn.getUserID());
        stm.executeUpdate();
        con.close();
    }
      public void delete(int checkInID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from CheckIn where checkInID = ? ");
        stm.setInt(1, checkInID);
        stm.executeUpdate();
        con.close();
    }
}
