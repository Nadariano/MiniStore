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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import models.Attendance;
import static services.Utilities.sdfDate;
import static services.Utilities.sdfDateTime;
import static services.Utilities.sdfTime;

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
        ResultSet rs = stm.executeQuery("select attendID, date, checkIn, checkOut, soonTime, lateTime, duration, attendance.status, "
                + "attendance.note, attendance.userID, users.fullName, attendance.shiftID from attendance join users on attendance.userID = users.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setStatus(rs.getInt("status"));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> select1() throws SQLException, ParseException {
        List<Attendance> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select a.attendID, a.date, a.checkIn, a.checkOut, a.duration, a.lateTime, a.soonTime,a.status, a.note, a.userID, u.fullName, a.shiftID\n"
                + "from Attendance as a left join Users as u on a.userID = u.userID");
        list = new ArrayList<>();
        while (rs.next()) {

            int id = rs.getInt("attendID");
            Date date = rs.getDate("date");

            Date inTime = null, outTime = null, duration = null, lateTime = null, soonTime = null;

            if (rs.getTime("checkIn") != null) {
                String strInDate = sdfDate.format(rs.getDate("checkIn"));
                String strInTime = sdfTime.format(rs.getTime("checkIn"));
                inTime = sdfDateTime.parse(strInDate + " " + strInTime);
            }
            if (rs.getTime("checkOut") != null) {
                String strOutDate = sdfDate.format(rs.getDate("checkOut"));
                String strOutTime = sdfTime.format(rs.getTime("checkOut"));
                outTime = sdfDateTime.parse(strOutDate + " " + strOutTime);
            }
            if (rs.getTime("duration") != null) {
                String strDurDate = sdfDate.format(rs.getDate("duration"));
                String strDurTime = sdfTime.format(rs.getTime("duration"));
                duration = sdfDateTime.parse(strDurDate + " " + strDurTime);
            }
            if (rs.getTime("lateTime") != null) {
                String strLateDate = sdfDate.format(rs.getDate("lateTime"));
                String strLateTime = sdfTime.format(rs.getTime("lateTime"));
                lateTime = sdfDateTime.parse(strLateDate + " " + strLateTime);
            }

            if (rs.getTime("soonTime") != null) {
                String strSoonDate = sdfDate.format(rs.getDate("soonTime"));
                String strSoonTime = sdfTime.format(rs.getTime("soonTime"));
                soonTime = sdfDateTime.parse(strSoonDate + " " + strSoonTime);
            }

            String note = rs.getString("note");
            int status = rs.getInt("status");
            int userID = rs.getInt("userID");
            int shiftID = rs.getInt("shiftID");

//            attendance.setAttendID(rs.getInt("attendID"));
//            attendance.setDate(rs.getDate("date"));
//            attendance.setCheckIn(rs.getDate("checkIn"));
//            attendance.setCheckOut(rs.getDate("checkOut"));
//            attendance.setDuration(rs.getDate("duration"));
//            attendance.setLateTime(rs.getDate("lateTime"));
//            attendance.setSoonTime(rs.getDate("soonTime"));
//            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
//            attendance.setStatus(rs.getInt("status"));
//            attendance.setNote(rs.getString("note"));
//            attendance.setUserID(rs.getInt("userID"));
//            attendance.setShiftID(rs.getInt("shiftID"));
//            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));
//            attendance.setFullName(rs.getString("fullName"));
            Attendance attendance = new Attendance(id, date, inTime, outTime, lateTime, soonTime, duration, status, note, userID, shiftID);
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
        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, soonTime, lateTime, duration, attendance.status, "
                + "attendance.note, attendance.userID, fullName, attendance.shiftID from attendance join users on attendance.userID = users.userID "
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
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setStatus(rs.getInt("status"));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            list.add(attendance);
        }
        con.close();
        return list;
    }

//    public void create(Attendance attendance) throws SQLException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("insert into Attendance values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//        stm.setString(1, sdfDate.format(attendance.getDate()));
//        stm.setString(2, sdfTime.format(attendance.getCheckIn()));
//        stm.setString(3, sdfTime.format(attendance.getCheckOut()));
//        stm.setString(4, sdfTime.format(attendance.getSoonTime()));
//        stm.setString(5, sdfTime.format(attendance.getLateTime()));
//        stm.setString(6, sdfTime.format(attendance.getDuration()));
//        stm.setInt(7, attendance.getStatus());
//        stm.setString(8, attendance.getNote());
//        stm.setInt(9, attendance.getUserID());
//        int count = stm.executeUpdate();
//        con.close();
//    }
    public void create(Attendance a) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Attendance values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        stm.setString(1, sdfDate.format(a.getDate()));

        if (a.getCheckIn() == null) {
            stm.setString(2, null);
        } else {
            stm.setString(2, sdfDateTime.format(a.getCheckIn()));
        }

        if (a.getCheckOut() == null) {
            stm.setString(3, null);
        } else {
            stm.setString(3, sdfDateTime.format(a.getCheckOut()));
        }

        if (a.getSoonTime() == null) {
            stm.setString(4, null);
        } else {
            stm.setString(4, sdfDateTime.format(a.getSoonTime()));
        }

        if (a.getLateTime() == null) {
            stm.setString(5, null);
        } else {
            stm.setString(5, sdfDateTime.format(a.getLateTime()));
        }
        if (a.getDuration() == null) {
            stm.setString(6, null);
        } else {
            stm.setString(6, sdfDateTime.format(a.getDuration()));
        }

        stm.setInt(7, a.getStatus());
        stm.setString(8, a.getNote());
        stm.setInt(9, a.getUserID());
        stm.setInt(10, a.getShiftID());

        stm.executeUpdate();

        con.close();
    }

    public Attendance read(int attendID) throws SQLException {
        Attendance attendance = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, soonTime, lateTime, duration, attendance.status, "
                + "attendance.note, attendance.userID, fullName, attendance.shiftID from attendance join users on attendance.userID = users.userID where attendID = ?");
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
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setStatus(rs.getInt("status"));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
        }
        //Đóng kết nối
        con.close();
        return attendance;
    }

    public void update(Attendance attendance) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("update attendance set date = ?, checkIn = ?, checkOut = ?, soonTime = ?, lateTime = ?, duration = ?, status = ?, note = ?, userID = ?, shiftID = ? from attendance join users on attendance.userID = users.userID where attendID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        stm.setString(1, sdfDate.format(attendance.getDate()));

        if (attendance.getCheckIn() == null) {
            stm.setString(2, null);
        } else {
            stm.setString(2, sdf.format(attendance.getCheckIn()));
        }

        if (attendance.getCheckOut() == null) {
            stm.setString(3, null);
        } else {
            stm.setString(3, sdf.format(attendance.getCheckOut()));
        }

        if (attendance.getSoonTime() == null) {
            stm.setString(4, null);
        } else {
            stm.setString(4, sdfTime.format(attendance.getSoonTime()));
        }

        if (attendance.getLateTime() == null) {
            stm.setString(5, null);
        } else {
            stm.setString(5, sdfTime.format(attendance.getLateTime()));
        }
        
        if (attendance.getDuration() == null) {
            stm.setString(6, null);
        } else {
            stm.setString(6, sdfTime.format(attendance.getDuration()));
        }

       
        stm.setInt(7, attendance.getStatus());
        stm.setString(8, attendance.getNote());
        stm.setInt(9, attendance.getUserID());
        stm.setInt(10, attendance.getShiftID());
        stm.setInt(11, attendance.getAttendID());

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void updateOfUsers(String attendID, String status, String note) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement

        PreparedStatement stm = con.prepareStatement("update attendance set status = ?, note = ? from attendance join users on attendance.userID = users.userID where attendID = ?");
        stm.setString(1, status);
        stm.setString(2, note);
        stm.setString(3, attendID);

        //Thực thi lệnh sql
        int count = stm.executeUpdate();

        //Đóng kết nối
        con.close();
    }

    public void done(int status) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement

        PreparedStatement stm = con.prepareStatement("update attendance set status = ? from attendance join users on attendance.userID = users.userID");
        stm.setInt(1, status);

        //Thực thi lệnh sql
        int count = stm.executeUpdate();

        //Đóng kết nối
        con.close();
    }

    public Attendance readDate(Date date, int userID) throws SQLException {
        Attendance attendance = null;
        // Create connection to DBMS
        Connection con = DBContext.getConnection();
        // Create PreparedStatement object
        PreparedStatement stm = con.prepareStatement("SELECT attendID, date, checkIn, checkOut, soonTime, lateTime, duration, status, note, shiftID "
                + "FROM Attendance "
                + "WHERE date = ? AND status = 0 AND userID = ?");
        stm.setString(1, Utilities.sdfDateTime.format(date));
        stm.setInt(2, userID);
        // Execute SQL statement
        ResultSet rs = stm.executeQuery();
        // Load data into Attendance object if available
        if (rs.next()) {
            attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setShiftID(rs.getInt("shiftID"));
        }
        // Close connection
        con.close();
        return attendance;
    }

    public List<Attendance> search(String date) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, Attedance.shiftID "
                + "FROM Attendance JOIN Users ON Attendance.userID = Users.userID "
                + "WHERE Attendance.date = ?");
        stm.setString(1, date);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setShiftID(rs.getInt("shiftID"));
            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByDayAndMonth(String day, String month) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, shiftID FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE DAY(Attendance.date) = ? AND MONTH(Attendance.date) = ?");
        stm.setString(1, day);
        stm.setString(2, month);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setShiftID(rs.getInt("shiftID"));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByDayAndYear(String day, String year) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, shiftID FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE DAY(Attendance.date) = ? AND YEAR(Attendance.date) = ?");
        stm.setString(1, day);
        stm.setString(2, year);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));
            attendance.setShiftID(rs.getInt("shiftID"));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByMonthAndYear(String month, String year) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, shiftID FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE MONTH(Attendance.date) = ? AND YEAR(Attendance.date) = ?");
        stm.setString(1, month);
        stm.setString(2, year);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByDay(String day) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, Attendance.shiftID FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE DAY(Attendance.date) = ?");
        stm.setString(1, day);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByMonth(String month) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, Attendance.shiftID FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE MONTH(Attendance.date) = ?");
        stm.setString(1, month);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByYear(String year) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, Attendance.shiftID FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE YEAR(Attendance.date) = ?");
        stm.setString(1, year);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByName(String fullName) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName, Attendance.shiftID "
                + "FROM Attendance "
                + "JOIN Users ON Attendance.userID = Users.userID "
                + "WHERE fullName LIKE ?");
        stm.setString(1, "%" + fullName + "%");
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Attendance attendance = new Attendance();
            attendance.setAttendID(rs.getInt("attendID"));
            attendance.setDate(rs.getDate("date"));
            attendance.setCheckIn(rs.getTime("checkIn"));
            attendance.setCheckOut(rs.getTime("checkOut"));
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
            attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
            attendance.setNote(rs.getString("note"));
            attendance.setUserID(rs.getInt("userID"));
            attendance.setFullName(rs.getString("fullName"));
            attendance.setShiftID(rs.getInt("shiftID"));
            attendance.setConfirm(Utilities.getStatusTextOfConfirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
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
