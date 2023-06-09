/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.security.NoSuchAlgorithmException;
import models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import services.Utilities;

/**
 * Pass=role
 *
 * @author PHT
 */
public class AccountRepository {

    public Account login(String userName, String password) throws SQLException {
        Account Account = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Users u join Roles r on (u.roleID = r. roleID) "
                + "where userName= ? COLLATE Latin1_General_CS_AS "
                + "and password= ? COLLATE Latin1_General_CS_AS");
        //Compare Strings with CASE SENSITIVE
        stm.setString(1, userName);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Account = new Account();
            Account.setUserID(rs.getInt("userID"));
            Account.setUserName(rs.getString("userName"));
            Account.setFullName(rs.getString("fullName"));
            Account.setPassword(rs.getString("password"));
            Account.setAvatar(rs.getString("avatar"));
            Account.setAddress(rs.getString("address"));
            Account.setPhone(rs.getString("phone"));
            Account.setEmail(rs.getString("email"));
            Account.setStatus(rs.getInt("status"));
            Account.setRoleName(rs.getString("roleName"));
        }
        con.close();
        return Account;
    }

    public Account read(int userID) throws SQLException {
        Account Account = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Users u join Roles r on (u.roleID = r. roleID) where userID= ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Account = new Account();
            Account.setUserID(rs.getInt("userID"));
            Account.setUserName(rs.getString("userName"));
            Account.setFullName(rs.getString("fullName"));
            Account.setPassword(rs.getString("password"));
            Account.setAvatar(rs.getString("avatar"));
            Account.setAddress(rs.getString("address"));
            Account.setPhone(rs.getString("phone"));
            Account.setEmail(rs.getString("email"));
            Account.setRoleName(rs.getString("roleName"));
        }
        con.close();
        return Account;
    }

    public boolean comparePass(int userID, String oldPass) throws SQLException, NoSuchAlgorithmException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Users where userID = ? and password = ? COLLATE Latin1_General_CS_AS");
        stm.setInt(1, userID);
        stm.setString(2, Utilities.hash(oldPass));
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            return true;
        }
        con.close();
        return false;
    }

    public void updatePass(int userID, String NewPass2) throws SQLException, NoSuchAlgorithmException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Users set password= ? where userID = ?");
        stm.setString(1, Utilities.hash(NewPass2));
        stm.setInt(2, userID);
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Account account) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Users set userName= ?, fullName = ?, avatar = ?, address = ?, phone = ?, email = ? where userID = ?");
        stm.setString(1, account.getUserName());
        stm.setString(2, account.getFullName());
        stm.setString(3, account.getAvatar());
        stm.setString(4, account.getAddress());
        stm.setString(5, account.getPhone());
        stm.setString(6, account.getEmail());
        stm.setInt(7, account.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }

    public boolean isActive(int status) {
        return status == 1;
    }
}
