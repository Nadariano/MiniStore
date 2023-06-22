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
import java.util.HashMap;
import java.util.List;
import models.Attendance;
import static services.Utilities.sdfTime;
import static services.Utilities.sdfDate;

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

//    public List<Attendance> selectUserAttendance(int userID) throws SQLException {
//        List<Attendance> list = null;
//        //Tạo connection để kết nối vào DBMS
//        Connection con = DBContext.getConnection();
//        //Tạo đối tượng statement
//        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, lateTime, overTime, attendance.status, "
//                + "attendance.note, attendance.userID, fullName from attendance join users on attendance.userID = users.userID "
//                + "where attendance.userID = ?");
//        stm.setInt(1, userID);
//        //Thực thi lệnh sql
//        ResultSet rs = stm.executeQuery();
//        list = new ArrayList<>();
//        while (rs.next()) {
//            Attendance attendance = new Attendance();
//            attendance.setAttendID(rs.getInt("attendID"));
//            attendance.setDate(rs.getDate("date"));
//            attendance.setCheckIn(rs.getTime("checkIn"));
//            attendance.setCheckOut(rs.getTime("checkOut"));
//            attendance.setLateTime(rs.getInt("lateTime"));
//            attendance.setOverTime(rs.getInt("overTime"));
//            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
//            attendance.setStatus(rs.getInt("status"));
//            attendance.setNote(rs.getString("note"));
//            attendance.setUserID(rs.getInt("userID"));
//            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));
//            attendance.setFullName(rs.getString("fullName"));
//            list.add(attendance);
//        }
//        con.close();
//        return list;
//    }
    
    public HashMap<Integer, Attendance> selectUserAttendance(int userID) throws SQLException {
    HashMap<Integer, Attendance> map = new HashMap<>();
    //Tạo connection để kết nối vào DBMS
    Connection con = DBContext.getConnection();
    //Tạo đối tượng statement
    PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, lateTime, overTime, attendance.status, "
            + "attendance.note, attendance.userID, fullName from attendance join users on attendance.userID = users.userID "
            + "where attendance.userID = ?");
    stm.setInt(1, userID);
    //Thực thi lệnh sql
    ResultSet rs = stm.executeQuery();
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
        map.put(attendance.getAttendID(), attendance);
    }
    con.close();
    return map;
}

    public void create(Attendance attendance) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Attendance values(?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, sdfDate.format(attendance.getDate()));
        stm.setString(2, sdfTime.format(attendance.getCheckIn()));
        stm.setString(3, sdfTime.format(attendance.getCheckOut()));
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
        stm.setString(1, sdfDate.format(attendance.getDate()));
        stm.setString(2, sdfTime.format(attendance.getCheckIn()));
        stm.setString(3, sdfTime.format(attendance.getCheckOut()));
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
