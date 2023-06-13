/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import models.Bonus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class BonusRepository {

    public static List<Bonus> select() throws SQLException {
        List<Bonus> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select bs.bonusID, bs.bonus, bs.description, bs.status, bs.note, bs.userID, u.fullName\n"
                + " from Bonus as bs left join Users as u \n"
                + " on bs.userID = u.userID ");
        list = new ArrayList<>();
        while (rs.next()) {
            Bonus bonus = new Bonus();
            bonus.setBonusID(rs.getInt("bonusID"));
            bonus.setBonus(rs.getFloat("bonus"));
            bonus.setDescription(rs.getString("description"));
            bonus.setStatus(rs.getInt("status"));
            bonus.setNote(rs.getString("note"));
            bonus.setUserID(rs.getInt("userID"));
            bonus.setFullName(rs.getString("fullName"));
            list.add(bonus);
        }
        con.close();
        return list;
    }

    public Bonus read(int bonusID) throws SQLException {
        Bonus bonus = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Bonus where bonusID = ?");
        stm.setInt(1, bonusID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            bonus = new Bonus();
            bonus.setBonusID(rs.getInt("bonusID"));
            bonus.setBonus(rs.getFloat("bonus"));
            bonus.setDescription(rs.getString("description"));
            bonus.setStatus(rs.getInt("status"));
            bonus.setNote(rs.getString("note"));
            bonus.setUserID(rs.getInt("userID"));
        }
        con.close();
        return bonus;
    }

    public void create(Bonus bonus) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Bonus values(?, ?, ?, ?, ?)");
        stm.setFloat(1, bonus.getBonus());
        stm.setString(2, bonus.getDescription());
        stm.setInt(3, bonus.getStatus());
        stm.setString(4, bonus.getNote());
        stm.setInt(5, bonus.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Bonus bonus) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Bonus set bonus=?, description=?, status = ?, note = ?, userID= ? where bonusID = ?");
        stm.setFloat(1, bonus.getBonus());
        stm.setString(2, bonus.getDescription());
        stm.setInt(3, bonus.getStatus());
        stm.setString(4, bonus.getNote());
        stm.setInt(5, bonus.getUserID());
        stm.setInt(6, bonus.getBonusID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int bonusID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Bonus where bonusID = ? ");
        stm.setInt(1, bonusID);
        int count = stm.executeUpdate();
        con.close();
    }

}
