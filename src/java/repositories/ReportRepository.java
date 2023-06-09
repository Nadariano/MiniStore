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
import java.util.List;
import models.Report;

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
        ResultSet rs = stm.executeQuery("select reportID, reportTitle, createDate, description, report.status, report.note, "
                + "report.userID, fullName "
                + "from report join users on report.userID = users.userID ");
        list = new ArrayList<>();
        while (rs.next()) {
            Report report = new Report();
            report.setReportID(rs.getInt("reportID"));
            report.setReportTitle(rs.getString("reportTitle"));
            report.setCreateDate(rs.getDate("createDate"));
            report.setDescription(rs.getString("description"));
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
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
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, report.status, report.note, report.userID, fullName from report join users on report.userID = users.userID where report.userID = ?");
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
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
            list.add(report);
        }
        con.close();
        return list;
    }
    public void create(String reportTitle, String description, int status, String note, int userID) throws SQLException {
        LocalDate curDate = LocalDate.now();
        String date= curDate.toString();
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("insert into report values(?, ?, ?, ?, ?, ?)");
        stm.setString(1, reportTitle);
        stm.setString(2, date);
        stm.setString(3, description);
        stm.setInt(4, status);
        stm.setString(5, note);
        stm.setInt(6, userID);
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
        PreparedStatement stm = con.prepareStatement("select reportID, reportTitle, createDate, description, report.status, "
                + "report.note, report.userID, fullName from report join users on report.userID = users.userID where reportID = ?");
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
            report.setStatusText(Utilities.getStatusTextOfReport(rs.getInt("status")));
            report.setNote(rs.getString("note"));
            report.setUserID(rs.getInt("userID"));
            report.setFullName(rs.getString("fullName"));
        }
        //Đóng kết nối
        con.close();
        return report;
    }

   

    public void update(Report report) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("update report set reportTitle = ?, createDate = ?, description = ?, status = ?, "
                + "note = ?, userID = ? from report join users on report.userID = users.userID   where reportID = ?");
        stm.setString(1, report.getReportTitle());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, sdf.format(report.getCreateDate()));
        stm.setString(3, report.getDescription());
        stm.setInt(4, report.getStatus());
        stm.setString(5, report.getNote());
        stm.setInt(6, report.getUserID());
        stm.setInt(7, report.getReportID());

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

}
