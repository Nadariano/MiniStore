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
import models.CheckOut;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author Dell
 */
public class CheckOutRepository {

    public static List<CheckOut> select() throws SQLException {
        List<CheckOut> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(" select co.checkOutID, co.checkOutTime, co.userID, u.fullName \n"
                + " from CheckOut as co left join Users as u \n"
                + " on co.userID = u.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            CheckOut checkOut = new CheckOut();
            checkOut.setCheckOutID(rs.getInt("checkOutID"));
            checkOut.setCheckOutTime(rs.getTimestamp("checkOutTime"));
            checkOut.setUserID(rs.getInt("userID"));
            checkOut.setFullName(rs.getString("fullName"));
            list.add(checkOut);
        }
        con.close();
        return list;
    }
     public void create(CheckOut checkOut) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into CheckOut values(?, ?)");
        stm.setString(1, sdfDateTime.format(checkOut.getCheckOutTime()));
        stm.setInt(2, checkOut.getUserID());
        stm.executeUpdate();
        con.close();
    }
      public void delete(int checkOutID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from CheckOut where checkOutID = ? ");
        stm.setInt(1, checkOutID);
        stm.executeUpdate();
        con.close();
    }
}
