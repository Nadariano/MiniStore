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
import models.Users;

/**
 *
 * @author Dell
 */
public class UsersRepository {
    
    public static List<Users> select() throws SQLException {
        List<Users> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select Users.userID, Users.userName, Users.password, Users.fullName, Users.avatar, Users.address, Users.phone, Users.email,Users.status, Users.note,Users.roleID, Roles.roleName\n"
                + "from Users \n"
                + "left join Roles on Users.roleID= Roles.roleID ");
        list = new ArrayList<>();
        while (rs.next()) {
            Users users = new Users();
            users.setUserID(rs.getInt("userID"));
            users.setUserName(rs.getString("userName"));
            users.setPassword(rs.getString("password"));
            users.setFullName(rs.getString("fullName"));
            users.setAvatar(rs.getString("avatar"));
            users.setAddress(rs.getString("address"));
            users.setPhone(rs.getString("phone"));
            users.setEmail(rs.getString("email"));
            users.setStatus(rs.getInt("status"));
            users.setStatusText1(Utilities.getStatusText1(Utilities.getInt(rs, "status")));
            users.setNote(rs.getString("note"));
            users.setRoleID(rs.getInt("roleID"));
            users.setRoleName(rs.getString("roleName"));
            list.add(users);
        }
        con.close();
        return list;
    }
    
    public void create(Users users) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Users values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, users.getUserName());
        stm.setString(2, users.getPassword());
        stm.setString(3, users.getFullName());
        stm.setString(4, users.getAvatar());
        stm.setString(5, users.getAddress());
        stm.setString(6, users.getPhone());
        stm.setString(7, users.getEmail());
        stm.setInt(8, users.getStatus());
        stm.setString(9, users.getNote());
        stm.setInt(10, users.getRoleID());
        int count = stm.executeUpdate();
        con.close();
    }
    
    public Users read(int userID) throws SQLException {
        Users users = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Users where userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            users = new Users();
            users.setUserID(rs.getInt("userID"));
            users.setUserName(rs.getString("userName"));
            users.setPassword(rs.getString("password"));
            users.setFullName(rs.getString("fullName"));
            users.setAvatar(rs.getString("avatar"));
            users.setAddress(rs.getString("address"));
            users.setPhone(rs.getString("phone"));
            users.setEmail(rs.getString("email"));
            users.setStatus(rs.getInt("status"));
            users.setNote(rs.getString("note"));
            users.setRoleID(rs.getInt("roleID"));
        }
        con.close();
        return users;
    }
    
    public void update(Users users) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Users set username = ?, fullName = ?, avatar = ?, address = ?, phone = ?, email = ?, status = ?, note = ?, roleID = ? where userID = ?");
        stm.setString(1, users.getUserName());
        stm.setString(2, users.getFullName());
        stm.setString(3, users.getAvatar());
        stm.setString(4, users.getAddress());
        stm.setString(5, users.getPhone());
        stm.setString(6, users.getEmail());
        stm.setInt(7, users.getStatus());
        stm.setString(8, users.getNote());
        stm.setInt(9, users.getRoleID());
        stm.setInt(10, users.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }
    
//    public void delete(int userID) throws SQLException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("delete from Users where userID = ?");
//        stm.setInt(1, userID);
//        int count = stm.executeUpdate();
//        con.close();
//    }
    
//    public List<Object> myProfile(int userId) throws SQLException {
//        List list = null;
//        Connection con = DBContext.getConnection();
//        String sql = "select Users.userID, Users.userName, Users.password, Users.fullName, Users.avatar, Users.address, Users.phone, Users.email, Roles.roleName\n"
//                + "from Users \n"
//                + "left join Roles on Users.roleID= Roles.roleID \n"
//                + "where userID = ?";
//        PreparedStatement stm = con.prepareStatement(sql);
//        stm.setInt(1, userId);
//        ResultSet rs = stm.executeQuery();
//        while (rs.next()) {
//            Users users = new Users();
//            int userID = rs.getInt("userID");
//            list.add(userID);
//            String userName = rs.getString("userName");
//            list.add(userName);
//            String password = rs.getString("password");
//            list.add(password);
//            String fullName = rs.getString("fullName");
//            list.add(fullName);
//            String avatar = rs.getString("avatar");
//            list.add(avatar);
//            String address = rs.getString("address");
//            list.add(address);
//            String phone = rs.getString("phone");
//            list.add(phone);
//            String email = rs.getString("email");
//            list.add(email);
//            String roleName = rs.getString("roleName");
//            list.add(roleName);
//
////            users.setUserID(rs.getInt("userID"));
////            users.setUsername(rs.getString("username"));
////            users.setPassword(rs.getString("password"));
////            users.setFullName(rs.getString("fullName"));
////            users.setAvatar(rs.getString("avatar"));
////            users.setAddress(rs.getString("address"));
////            users.setPhone(rs.getString("phone"));
////            users.setEmail(rs.getString("email"));
////            users.setRoleName(rs.getString("roleName"));
//        }
//        con.close();
//        return list;
//    }

    
    
   
    
}
