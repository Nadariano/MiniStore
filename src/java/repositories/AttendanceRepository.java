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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Attendance;

/**
 *
 * @author User
 */
public class AttendanceRepository {

    public List<Attendance> select() throws SQLException {
        List<Attendance> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select attendID, date, checkIn, checkOut, lateTime, overTime, attendance.status, "
                + "attendance.note, attendance.userID, users.fullName from attendance join users on attendance.userID = users.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setLateTime(rs.getInt("lateTime"));
            attendance.setOverTime(rs.getInt("overTime"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setStatus(rs.getInt("status"));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));
            attendance.setFullName(rs.getString("fullName"));
            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> selectUserAttendance(int userID) throws SQLException {
        List<Attendance> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, lateTime, overTime, attendance.status, "
                + "attendance.note, attendance.userID, fullName from attendance join users on attendance.userID = users.userID "
                + "where attendance.userID = ?");
        stm.setInt(1, userID);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setLateTime(rs.getInt("lateTime"));
            attendance.setOverTime(rs.getInt("overTime"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setStatus(rs.getInt("status"));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));
            attendance.setFullName(rs.getString("fullName"));
            list.add(attendance);
        }
        con.close();
        return list;
    }

    public void create(Attendance attendance) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Attendance values(?, ?, ?, ?, ?, ?, ?, ?)");
         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(1, sdf1.format(attendance.getDate()));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        stm.setString(2, sdf.format(attendance.getCheckIn()));
        stm.setString(3, sdf.format(attendance.getCheckOut()));
       stm.setInt(4, attendance.getLateTime());
        stm.setInt(5, attendance.getOverTime());
        stm.setInt(6, attendance.getStatus());
        stm.setString(7, attendance.getNote());
        stm.setInt(8, attendance.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }

    public Attendance read(int attendID) throws SQLException {
        Attendance attendance = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, lateTime, overTime, attendance.status, "
                + "attendance.note, attendance.userID, fullName from attendance join users on attendance.userID = users.userID where attendID = ?");
        stm.setInt(1, attendID);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        if (rs.next()) {
            attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setLateTime(rs.getInt("lateTime"));
            attendance.setOverTime(rs.getInt("overTime"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setStatus(rs.getInt("status"));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));
            attendance.setFullName(rs.getString("fullName"));
        }
        //Đóng kết nối
        con.close();
        return attendance;
    }

    public void update(Attendance attendance) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("update attendance set date = ?, checkIn = ?, checkOut = ?, lateTime = ?, overTime = ?, status = ?, note = ?, userID = ? from attendance join users on attendance.userID = users.userID where attendID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(1, sdf.format(attendance.getDate()));
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        stm.setString(2, sdf1.format(attendance.getCheckIn()));
        stm.setString(3, sdf1.format(attendance.getCheckOut()));
        stm.setInt(4, attendance.getLateTime());
        stm.setInt(5, attendance.getOverTime());
        stm.setInt(6, attendance.getStatus());
        stm.setString(7, attendance.getNote());
        stm.setInt(8, attendance.getUserID());
        stm.setInt(9, attendance.getAttendID());

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void delete(int attendID) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("delete from attendance where attendID = ?");
        stm.setInt(1, attendID);
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        con.close();
    }
}
