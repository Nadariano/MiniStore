/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import services.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.PaySlip;

/**
 *
 * @author Dell
 */
public class PaySlipRepository {

    public static List<PaySlip> select() throws SQLException {
        List<PaySlip> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select p.paySlipID, p.userID, u.fullName, p.salary, p.bonus, p.minus, p.status, p.note \n"
                + "from PaySlip as p left join  Users as u on p.userID = u.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            PaySlip paySlip = new PaySlip();
            paySlip.setPaySlipID(rs.getInt("paySlipID"));
            paySlip.setUserID(rs.getInt("userID"));
            paySlip.setFullName(rs.getString("fullName"));
            paySlip.setSalary(rs.getFloat("salary"));
            paySlip.setBonus(rs.getFloat("bonus"));
            paySlip.setMinus(rs.getFloat("minus"));
            paySlip.setStatus(rs.getInt("status"));
            paySlip.setStatusText3(Utilities.getStatusText3(Utilities.getInt(rs, "status")));
            paySlip.setNote(rs.getString("note"));
            list.add(paySlip);
        }
        con.close();
        return list;
    }

    public PaySlip myPaySlip(int userID) throws SQLException {
        PaySlip paySlip = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select p.paySlipID, p.userID, u.fullName, p.salary, p.bonus, p.minus, p.status, p.note \n"
                + "from PaySlip as p left join  Users as u on p.userID = u.userID\n"
                + "where p.userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            paySlip = new PaySlip();
            paySlip.setPaySlipID(rs.getInt("paySlipID"));
            paySlip.setUserID(rs.getInt("userID"));
            paySlip.setFullName(rs.getString("fullName"));
            paySlip.setSalary(rs.getFloat("salary"));
            paySlip.setBonus(rs.getFloat("bonus"));
            paySlip.setMinus(rs.getFloat("minus"));
            paySlip.setStatus(rs.getInt("status"));
            paySlip.setStatusText3(Utilities.getStatusText3(Utilities.getInt(rs, "status")));
            paySlip.setNote(rs.getString("note"));
        }
        con.close();
        return paySlip;
    }

    public List<PaySlip> select1(int userID) throws SQLException {
        List<PaySlip> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select p.paySlipID, p.userID, u.fullName, p.salary, p.bonus, p.minus, p.status, p.note \n"
                + "from PaySlip as p left join  Users as u on p.userID = u.userID\n"
                + "where p.userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            PaySlip paySlip = new PaySlip();
            paySlip.setPaySlipID(rs.getInt("paySlipID"));
            paySlip.setUserID(rs.getInt("userID"));
            paySlip.setFullName(rs.getString("fullName"));
            paySlip.setSalary(rs.getFloat("salary"));
            paySlip.setBonus(rs.getFloat("bonus"));
            paySlip.setMinus(rs.getFloat("minus"));
            paySlip.setStatus(rs.getInt("status"));
            paySlip.setStatusText3(Utilities.getStatusText3(rs.getInt("status")));
            paySlip.setNote(rs.getString("note"));
            list.add(paySlip);
        }
        con.close();
        return list;
    }

    public PaySlip read(int userID, int paySlipID) throws SQLException {
        PaySlip paySlip = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from PaySlip where paySlipID = ? and userID = ?");
        stm.setInt(1, paySlipID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            paySlip = new PaySlip();
            paySlip.setPaySlipID(rs.getInt("paySlipID"));
            paySlip.setUserID(rs.getInt("userID"));
//            paySlip.setFullName(rs.getString("fullName"));
            paySlip.setSalary(rs.getFloat("salary"));
            paySlip.setBonus(rs.getFloat("bonus"));
            paySlip.setMinus(rs.getFloat("minus"));
            paySlip.setStatus(rs.getInt("status"));
//            paySlip.setStatusText3(Utilities.getStatusText3(Utilities.getInt(rs, "status")));
            paySlip.setNote(rs.getString("note"));
        }
        con.close();
        return paySlip;
    }

    public void create(PaySlip paySlip) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into PaySlip values(?, ?, ?, ?, ?, ?,?)");
        stm.setString(1, Utilities.sdfDate.format(paySlip.getCreateDate()));
        stm.setFloat(2, paySlip.getSalary());
        stm.setFloat(3, paySlip.getBonus());
        stm.setFloat(4, paySlip.getMinus());
        stm.setInt(5, paySlip.getStatus());
        stm.setString(6, paySlip.getNote());
        stm.setInt(7, paySlip.getUserID());
        stm.executeUpdate();
        con.close();
    }

    public void update(PaySlip paySlip) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update PaySlip set salary=?, bonus=?, minus=?,  status = ?, note = ?\n"
                + "from PaySlip as p\n"
                + " left join Users as u on p.userID = u.userID\n"
                + "where paySlipID = ? and p.userID = ?");
        stm.setFloat(1, paySlip.getSalary());
        stm.setFloat(2, paySlip.getBonus());
        stm.setFloat(3, paySlip.getMinus());
        stm.setInt(4, paySlip.getStatus());
        stm.setString(5, paySlip.getNote());
        stm.setInt(6, paySlip.getPaySlipID());
        stm.setInt(7, paySlip.getUserID());
        stm.executeUpdate();
        con.close();
    }

    public void done(int status) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update PaySlip set status = ? \n"
                + "from PaySlip as p left join Users as u on p.userID = u.userID");
        stm.setInt(1, status);
        stm.executeUpdate();
        con.close();
    }

    public void delete(int paySlipID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from PaySlip where paySlipID = ? ");
        stm.setInt(1, paySlipID);
        int count = stm.executeUpdate();
        con.close();
    }

}
