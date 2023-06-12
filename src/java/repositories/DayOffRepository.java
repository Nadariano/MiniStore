/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import models.DayOff;
import services.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static services.Utilities.sdfDate;
/**
 *
 * @author Pc
 */
public class DayOffRepository {

    public List<DayOff> select() throws SQLException {
        List<DayOff> list = null;
        // Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        try {
            // Tạo đối tượng statement
            Statement stm = con.createStatement();
            // Thực thi lệnh SELECT
            ResultSet rs = stm.executeQuery("select * from DayOff");
            list = new ArrayList<>();
            while (rs.next()) {
                DayOff dayOff = new DayOff();
                dayOff.setDayOffID(Utilities.getInt(rs, "dayOffID"));
                dayOff.setDate(Utilities.getDate(rs, "date"));
                dayOff.setCoefficient(Utilities.getFloat(rs, "coefficient"));
                dayOff.setDescription(Utilities.getString(rs, "description"));
                dayOff.setStatusText(Utilities.getStatusTextForDayOff(Utilities.getInt(rs, "status")));
                dayOff.setNote(Utilities.getString(rs, "note"));

                // Format integer and double values as "N/A" strings
//                dayOff.setIDText(Utilities.formatInt(dayOff.getID()));
//                dayOff.setCoefficentText(Utilities.formatDouble(Double.parseDouble(dayOff.getCoefficent())));
                list.add(dayOff);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public DayOff read(int id) throws SQLException {
        DayOff dayOff = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select * from DayOff where dayOffID = ?");
        stm.setInt(1, id);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng DayOff nếu có
        if (rs.next()) {

//            dayOff.setRoleID(Utilities.getInt(rs, "roleID"));
//            dayOff.setRoleName(Utilities.getString(rs, "roleName"));
//            dayOff.setStatusText(Utilities.getStatusText(Utilities.getInt(rs, "status")));
//            dayOff.setDescription(Utilities.getString(rs, "description"));
            dayOff = new DayOff();
            dayOff.setDayOffID(Utilities.getInt(rs, "dayOffID"));

            dayOff.setDate(Utilities.getDate(rs, "date"));
            dayOff.setCoefficient(Utilities.getFloat(rs, "coefficient"));
            dayOff.setDescription(Utilities.getString(rs, "description"));
            dayOff.setStatusText(Utilities.getStatusTextForDayOff(Utilities.getInt(rs, "status")));
            dayOff.setNote(Utilities.getString(rs, "note"));
        }

        //Đóng kết nối
        con.close();
        return dayOff;

    }

    public void create(DayOff dayOff) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("insert DayOff values( ?, ?, ?, ?, ?)");
        stm.setString(1, sdfDate.format(dayOff.getDate()));
        stm.setFloat(2, dayOff.getCoefficient());
        stm.setString(3, dayOff.getDescription());
        stm.setInt(4, dayOff.getStatus());
        stm.setString(5, dayOff.getNote());
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void update(DayOff dayOff) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("update DayOff set date = ?,coefficient=? , description = ?,status= ?,note=? where dayOffID = ?");
        stm.setString(1, sdfDate.format(dayOff.getDate()));
        stm.setFloat(2, dayOff.getCoefficient());
        stm.setString(3, dayOff.getDescription());
        stm.setInt(4, dayOff.getStatus());
        stm.setString(5, dayOff.getNote());
        stm.setInt(6, dayOff.getDayOffID());
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void delete(int dayOffID) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("delete from DayOff where dayOffID = ?");
        stm.setInt(1, dayOffID);
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        con.close();
    }

}
