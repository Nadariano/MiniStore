/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import models.Role;
import services.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class RoleRepository {

   public List<Role> select() throws SQLException {
    List<Role> list = null;

    // Tạo connection để kết nối vào DBContextMS
    Connection con = DBContext.getConnection();

    try {
        // Tạo đối tượng statement
        Statement stm = con.createStatement();
        
        // Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Roles");

        list = new ArrayList<>();

        while (rs.next()) {
            Role roles = new Role();
            roles.setRoleID(Utilities.getInt(rs, "roleID"));
            roles.setRoleName(Utilities.getString(rs, "roleName"));
            roles.setStatusText(Utilities.getStatusText(Utilities.getInt(rs, "status")));
            roles.setDescription(Utilities.getString(rs, "description"));

            if (roles.getDescription().trim().isEmpty()) {
                roles.setDescription("N/A");
            }

            list.add(roles);
        }

        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return list;
}

    public Role read(int id) throws SQLException {
        Role roles = null;
        //Tạo connection để kết nối vào DBContextMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select * from Roles where roleID = ?");
        stm.setInt(1, id);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng Role nếu có
        if (rs.next()) {
            roles = new Role();
            roles.setRoleID(rs.getInt("roleID"));
            roles.setRoleName(rs.getString("roleName"));
            roles.setRoleStatus(rs.getInt("status"));
            roles.setDescription(rs.getString("description"));
            
//            roles.setRoleID(Utilities.getInt(rs, "roleID"));
//            roles.setRoleName(Utilities.getString(rs, "roleName"));
//            roles.setStatusText(Utilities.getStatusText(Utilities.getInt(rs, "status")));
//            roles.setDescription(Utilities.getString(rs, "description"));
        }

        //Đóng kết nối
        con.close();
        return roles;

    }

    public void create(Role roles) throws SQLException {
        //Tạo connection để kết nối vào DBContextMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("insert Roles values( ?, ?, ?)");

        stm.setString(1, roles.getRoleName());
        stm.setInt(2, roles.getRoleStatus());
        stm.setString(3, roles.getDescription());

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

 public void update(Role roles) throws SQLException {
        //Tạo connection để kết nối vào DBContextMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("update Roles set roleName = ?, status= ?, description = ? where roleID = ?");
        stm.setString(1, roles.getRoleName());
        stm.setInt(2, roles.getRoleStatus());
        stm.setString(3, roles.getDescription());
        stm.setInt(4, roles.getRoleID());
        //Thực thi lệnh sql
        int count = stm.executeUpdate();       
        //Đóng kết nối
        con.close();
    }

    public void delete(int roleID) throws SQLException {
        //Tạo connection để kết nối vào DBContextMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("delete from Roles where roleID = ?");
        stm.setInt(1, roleID);
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        con.close();
    }

}
