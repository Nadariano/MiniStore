/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import services.Utilities;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import models.UserShift;

/**
 *
 * @author Dell
 */
public class UserShiftRepository {

    public static List<UserShift> select() throws SQLException {
        List<UserShift> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select Users.userID, Users.fullName, UserShift.shiftID, UserShift.date, UserShift.status, UserShift.note, UserShift.isOT\n"
                + "from UserShift \n"
                + "left join Users on UserShift.userID = Users.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            UserShift userShift = new UserShift();
            userShift.setUserID(rs.getInt("userID"));
            userShift.setShiftID(rs.getInt("shiftID"));
            userShift.setDate(rs.getDate("date"));
            userShift.setStatus(rs.getInt("status"));
            userShift.setStatusText2(Utilities.getStatusText2(Utilities.getInt(rs, "status")));
            userShift.setNote(rs.getString("note"));
            userShift.setIsOT(rs.getBoolean("isOT"));
            userShift.setFullName(rs.getString("fullName"));
            userShift.setOtText(Utilities.getOtText(Utilities.getBoolean(rs, "isOT")));
            list.add(userShift);
        }
        con.close();
        return list;
    }

    public UserShift read(int userID) throws SQLException {
        UserShift userShift = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from UserShift where userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            userShift = new UserShift();
            userShift.setUserID(rs.getInt("userID"));
            userShift.setShiftID(rs.getInt("shiftID"));
            userShift.setDate(rs.getDate("date"));
            userShift.setStatus(rs.getInt("status"));
            userShift.setNote(rs.getString("note"));
            userShift.setIsOT(rs.getBoolean("isOT"));
        }
        con.close();
        return userShift;
    }

    public void create(UserShift userShift) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into UserShift values(?, ?, ?, ?, ?, ?)");
        stm.setInt(1, userShift.getUserID());
        stm.setInt(2, userShift.getShiftID());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(userShift.getDate()));
        stm.setInt(4, userShift.getStatus());
        stm.setString(5, userShift.getNote());
        stm.setBoolean(6, userShift.isIsOT());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(UserShift userShift) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update UserShift set date =?, status = ?, note = ?, isOT = ? where userID = ? and shiftID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(1, sdf.format(userShift.getDate()));
        stm.setInt(2, userShift.getStatus());
        stm.setString(3, userShift.getNote());
        stm.setBoolean(4, userShift.isIsOT());
        stm.setInt(5, userShift.getUserID());
        stm.setInt(6, userShift.getShiftID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int userID, int shiftID, Date date) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from UserShift where userID = ? and shiftID = ? and date = ?");
        stm.setInt(1, userID);
        stm.setInt(2, shiftID);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(date));
        int count = stm.executeUpdate();
        con.close();
    }

//    public void delete1(int userID) throws SQLException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("delete from UserShift where userID = ?");
//        stm.setInt(1, userID);
//        int count = stm.executeUpdate();
//        con.close();
//    }
}
