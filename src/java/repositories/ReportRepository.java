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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Report;
import static services.Utilities.sdfDate;
import static services.Utilities.sdfTime;

/**
 *
 * @author User
 */
public class ReportRepository {

    public List<Report> select() throws SQLException {
        List<Report> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, fullName, reportType.typeName, report.shiftID\n"
                + "from report join users on report.userID = users.userID \n"
                + "join reportType on report.typeID = reportType.typeID order by reportID DESC");
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            report.setShiftID(rs.getInt("shiftID"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> selectUserReport(int userID) throws SQLException {
        List<Report> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, fullName, reportType.typeName, report.shiftID\n"
                + "from report join users on report.userID = users.userID \n"
                + "join reportType on report.typeID = reportType.typeID\n"
                + "where report.userID = ? order by reportID DESC");
        stm.setInt(1, userID);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            report.setShiftID(rs.getInt("shiftID"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public void create(String reportTitle, String description, String plannedDate, String requestSoonTime, String requestLateTime, int status, String note, int userID, int typeID, int shiftID) throws SQLException {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("insert into report values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, reportTitle);
        stm.setString(2, date);
        stm.setString(3, description);
        stm.setString(4, sdfDate.format(plannedDate));
        stm.setString(5, sdfTime.format(requestSoonTime));
        stm.setString(6, sdfTime.format(requestLateTime));
        stm.setInt(7, status);
        stm.setString(8, note);
        stm.setInt(9, userID);
        stm.setInt(10, typeID);
        stm.setInt(11, shiftID);
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public Report read(int reportID) throws SQLException {
        Report report = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, fullName, reportType.typeName, report.shiftID\n"
                + "from report join users on report.userID = users.userID \n"
                + "join reportType on report.typeID = reportType.typeID "
                + "where reportID = ?");
        stm.setInt(1, reportID);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        if (rs.next()) {
            report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            report.setShiftID(rs.getInt("shiftID"));
        }
        //Đóng kết nối
        con.close();
        return report;
    }

    public Report readDate(Date date, int userID) throws SQLException {
        Report report = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, report.status, "
                + "report.note, report.userID, users.fullName, report.shiftID "
                + "from report join users on report.userID = users.userID "
                + "where plannedDate = ? and report.status = 0 and report.userID = ?");
        stm.setString(1, Utilities.sdfDateTime.format(date));
        stm.setInt(2, userID);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        if (rs.next()) {
            report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setShiftID(rs.getInt("shiftID"));
        }
        //Đóng kết nối
        con.close();
        return report;
    }

    public void update(Report report) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
//        PreparedStatement stm = con.prepareStatement("update report set reportTitle = ?, createDate = ?, description = ?, status = ?, "
//                + "note = ?, userID = ? from report join users on report.userID = users.userID   where reportID = ?");
        PreparedStatement stm = con.prepareStatement("update report set status = ?, "
                + "note = ? from report where reportID = ?");
//        stm.setString(1, report.getReportTitle());
//        stm.setString(2, sdfDate.format(report.getCreateDate()));
//        stm.setString(3, report.getDescription());
        stm.setInt(1, report.getStatus());
        stm.setString(2, report.getNote());
//        stm.setInt(6, report.getUserID());
        stm.setInt(3, report.getReportID());

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void delete(int reportID) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("delete from report where reportID = ?");
        stm.setInt(1, reportID);
        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        con.close();
    }

    public List<Report> search(String createDate) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where createDate = ?");
        stm.setString(1, createDate);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByDayAndMonth(String day, String month) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where DAY(createDate) = ? and MONTH(createDate) = ?");
        stm.setString(1, day);
        stm.setString(2, month);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByDayAndYear(String day, String year) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where DAY(createDate) = ? and YEAR(createDate) = ?");
        stm.setString(1, day);
        stm.setString(2, year);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByMonthAndYear(String month, String year) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where MONTH(createDate) = ? and YEAR(createDate) = ?");
        stm.setString(1, month);
        stm.setString(2, year);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByDay(String day) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where DAY(createDate) = ? ");
        stm.setString(1, day);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByMonth(String month) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where MONTH(createDate) = ?");
        stm.setString(1, month);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByYear(String month) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, report.userID, "
                + "fullName, reportType.typeName from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where YEAR(createDate) = ?");
        stm.setString(1, month);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

    public List<Report> searchByName(String fullName) throws SQLException, ClassNotFoundException {
        List<Report> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, plannedDate, requestSoonTime, requestLateTime, report.status, report.note, "
                + "report.userID, fullName, reportType.typeName "
                + "from report join users on report.userID = users.userID join reportType on report.typeID = reportType.typeID "
                + "where fullName like ?");
        stm.setString(1, "%" + fullName + "%");
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setPlannedDate(rs.getDate("plannedDate"));
            report.setRequestSoonTime(rs.getTime("requestSoonTime"));
            report.setRequestLateTime(rs.getTime("requestLateTime"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            report.setTypeName(rs.getString("typeName"));
            list.add(report);
        }
        con.close();
        return list;
    }

}
