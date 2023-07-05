/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Attendance;
import services.Utilities;
import static services.Utilities.sdfDate;
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
                + "attendance.note, attendance.userID, users.fullName from attendance join users on attendance.userID = users.userID");
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
        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, soonTime, lateTime, duration, attendance.status, "
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
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
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

//    public HashMap<Integer, Attendance> selectUserAttendance(int userID) throws SQLException {
//    HashMap<Integer, Attendance> map = new HashMap<>();
//    //Tạo connection để kết nối vào DBMS
//    Connection con = DBContext.getConnection();
//    //Tạo đối tượng statement
//    PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, lateTime, overTime, attendance.status, "
//            + "attendance.note, attendance.userID, fullName from attendance join users on attendance.userID = users.userID "
//            + "where attendance.userID = ?");
//    stm.setInt(1, userID);
//    //Thực thi lệnh sql
//    ResultSet rs = stm.executeQuery();
//    while (rs.next()) {
//        Attendance attendance = new Attendance();
//        attendance.setAttendID(rs.getInt("attendID"));
//        attendance.setDate(rs.getDate("date"));
//        attendance.setCheckIn(rs.getTime("checkIn"));
//        attendance.setCheckOut(rs.getTime("checkOut"));
//        attendance.setLateTime(rs.getInt("lateTime"));
//        attendance.setOverTime(rs.getInt("overTime"));
//        attendance.setStatusText(Utilities.getStatusTextOfAttendance(rs.getInt("status")));
//        attendance.setStatus(rs.getInt("status"));
//        attendance.setNote(rs.getString("note"));
//        attendance.setUserID(rs.getInt("userID"));
//        attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));
//        attendance.setFullName(rs.getString("fullName"));
//        map.put(attendance.getAttendID(), attendance);
//    }
//    con.close();
//    return map;
//}
    public void create(Attendance attendance) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Attendance values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, sdfDate.format(attendance.getDate()));
        stm.setString(2, sdfTime.format(attendance.getCheckIn()));
        stm.setString(3, sdfTime.format(attendance.getCheckOut()));
        stm.setString(4, sdfTime.format(attendance.getSoonTime()));
        stm.setString(5, sdfTime.format(attendance.getLateTime()));
        stm.setString(6, sdfTime.format(attendance.getDuration()));
        stm.setInt(7, attendance.getStatus());
        stm.setString(8, attendance.getNote());
        stm.setInt(9, attendance.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }

    public Attendance read(int attendID) throws SQLException {
        Attendance attendance = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select attendID, date, checkIn, checkOut, soonTime, lateTime, duration, attendance.status, "
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
            attendance.setSoonTime(rs.getTime("soonTime"));
            attendance.setLateTime(rs.getTime("lateTime"));
            attendance.setDuration(rs.getTime("duration"));
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
        PreparedStatement stm = con.prepareStatement("update attendance set date = ?, checkIn = ?, checkOut = ?, soonTime = ?, lateTime = ?, duration = ?, status = ?, note = ?, userID = ? from attendance join users on attendance.userID = users.userID where attendID = ?");
        stm.setString(1, sdfDate.format(attendance.getDate()));
        stm.setString(2, sdfTime.format(attendance.getCheckIn()));
        stm.setString(3, sdfTime.format(attendance.getCheckOut()));
        stm.setString(4, sdfTime.format(attendance.getSoonTime()));
        stm.setString(5, sdfTime.format(attendance.getLateTime()));
        stm.setString(6, sdfTime.format(attendance.getDuration()));
        stm.setInt(7, attendance.getStatus());
        stm.setString(8, attendance.getNote());
        stm.setInt(9, attendance.getUserID());
        stm.setInt(10, attendance.getAttendID());

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void updateOfUsers(int attendID, int status, String note) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement

        PreparedStatement stm = con.prepareStatement("update attendance set status = ?, note = ? from attendance join users on attendance.userID = users.userID where attendID = ?");
        stm.setInt(1, status);
        stm.setString(2, note);
        stm.setInt(3, attendID);

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

    public Attendance readDate(Date date, int userID) throws SQLException {
        Attendance attendance = null;
        // Create connection to DBMS
        Connection con = DBContext.getConnection();
        // Create PreparedStatement object
        PreparedStatement stm = con.prepareStatement("SELECT attendID, date, checkIn, checkOut, soonTime, lateTime, duration, status, note "
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

            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

        }
        // Close connection
        con.close();
        return attendance;
    }

    public List<Attendance> search(String date) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName "
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

           attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByDayAndMonth(String day, String month) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE DAY(Attendance.date) = ? AND MONTH(Attendance.date) = ?");
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

           attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByDayAndYear(String day, String year) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE DAY(Attendance.date) = ? AND YEAR(Attendance.date) = ?");
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

           attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByMonthAndYear(String month, String year) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE MONTH(Attendance.date) = ? AND YEAR(Attendance.date) = ?");
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

           attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByDay(String day) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE DAY(Attendance.date) = ?");
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

            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByMonth(String month) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE MONTH(Attendance.date) = ?");
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

          attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByYear(String year) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName FROM Attendance JOIN Users ON Attendance.userID = Users.userID WHERE YEAR(Attendance.date) = ?");
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

            attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

    public List<Attendance> searchByName(String fullName) throws SQLException, ClassNotFoundException {
        List<Attendance> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT attendID, Attendance.date, checkIn, checkOut, soonTime, lateTime, duration, Attendance.status, Attendance.note, Attendance.userID, fullName "
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

           attendance.setConfirm(Utilities.getStatusTextOfCofirm(rs.getInt("status")));

            list.add(attendance);
        }
        con.close();
        return list;
    }

}
