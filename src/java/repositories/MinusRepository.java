/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import models.Minus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class MinusRepository {

    public static List<Minus> select() throws SQLException {
        List<Minus> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(" select ms.minusID, ms.lateTime, ms.reduction, ms.fine, ms.description, ms.status, ms.note, ms.userID, u.fullName\n"
                + " from Minus as ms left join Users as u \n"
                + " on ms.userID = u.userID ");
        list = new ArrayList<>();
        while (rs.next()) {
            Minus minus = new Minus();
            minus.setMinusID(rs.getInt("minusID"));
            minus.setLateTime(rs.getInt("lateTime"));
            minus.setReduction(rs.getFloat("reduction"));
            minus.setFine(rs.getFloat("fine"));
            minus.setDescription(rs.getString("description"));
            minus.setStatus(rs.getInt("status"));
            minus.setNote(rs.getString("note"));
            minus.setUserID(rs.getInt("userID"));
            minus.setFullName(rs.getString("fullName"));
            list.add(minus);
        }
        con.close();
        return list;
    }

    public Minus read(int minusID) throws SQLException {
        Minus minus = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Minus where minusID = ?");
        stm.setInt(1, minusID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            minus = new Minus();
            minus.setMinusID(rs.getInt("minusID"));
            minus.setLateTime(rs.getInt("lateTime"));
            minus.setReduction(rs.getFloat("reduction"));
            minus.setFine(rs.getFloat("fine"));
            minus.setDescription(rs.getString("description"));
            minus.setStatus(rs.getInt("status"));
            minus.setNote(rs.getString("note"));
            minus.setUserID(rs.getInt("userID"));
        }
        con.close();
        return minus;
    }

    public void create(Minus minus) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Minus values(?, ?, ?, ?, ?, ?, ?)");
       stm.setInt(1, minus.getLateTime());
       stm.setFloat(2, minus.getReduction());
       stm.setFloat(3, minus.getFine());
       stm.setString(4, minus.getDescription());
       stm.setInt(5, minus.getStatus());
       stm.setString(6, minus.getNote());
       stm.setInt(7, minus.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Minus minus) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Minus set lateTime=?, reduction= ?, fine=? , description=?, status = ?, note = ?, userID= ? where minusID = ?");
        stm.setInt(1, minus.getLateTime());
       stm.setFloat(2, minus.getReduction());
       stm.setFloat(3, minus.getFine());
       stm.setString(4, minus.getDescription());
       stm.setInt(5, minus.getStatus());
       stm.setString(6, minus.getNote());
       stm.setInt(7, minus.getUserID());
       stm.setInt(8, minus.getMinusID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int minusID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Minus where minusID = ? ");
        stm.setInt(1, minusID);
        int count = stm.executeUpdate();
        con.close();
    }

}
