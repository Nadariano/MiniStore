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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Record;
import models.Report;
import services.Utilities;

/**
 *
 * @author DELL
 */
public class RecordRepository {

    public List<Record> select() throws SQLException {
        List<Record> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select rc.recordID, rc.date, rc.inTime, rc.outTime, rc.userID, u.fullName, rc.shiftID\n"
                + "from Record as rc left join Users as u on rc.userID = u.userID");
        list = new ArrayList<>();
        while (rs.next()) {
            Record record = new Record();
            record.setRecordID(rs.getInt("recordID"));
            record.setDate(rs.getDate("date"));
            record.setInTime(rs.getTime("inTime"));
            record.setOutTime(rs.getTime("outTime"));
            record.setUserID(rs.getInt("userID"));
            record.setFullName(rs.getString("fullName"));
            record.setShiftID(rs.getInt("shiftID"));
            list.add(record);
        }
        con.close();
        return list;
    }

    public List<Record> select1() throws SQLException, ParseException {
        List<Record> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select rc.recordID, rc.date, rc.inTime, rc.outTime, rc.userID, u.fullName, rc.shiftID\n"
                + "from Record as rc left join Users as u on rc.userID = u.userID");
        list = new ArrayList<>();

        while (rs.next()) {
            System.out.println("asdhgj");
            int recordID = rs.getInt("recordID");
            
            Date date = rs.getDate("date");
            
 
            Date inTime = null;
            if (rs.getTime("inTime") != null || rs.getDate("inTime") != null) {
                String strInTime = Utilities.sdfTime.format(rs.getTime("inTime"));
                String strInDate = Utilities.sdfDate.format(rs.getDate("inTime"));
                inTime = Utilities.sdfDateTime.parse(strInDate + " " + strInTime);
            }
            System.out.println("REPOSITORY INTIME " + inTime);

            Date outTime = null;
            if (rs.getTime("outTime") != null || rs.getDate("outTime") != null) {
                String strOutTime = Utilities.sdfTime.format(rs.getTime("outTime"));
                String strOutDate = Utilities.sdfDate.format(rs.getDate("outTime"));
                outTime = Utilities.sdfDateTime.parse(strOutDate + " " + strOutTime);
            }
           

            int userID = rs.getInt("userID");
            String fullName = rs.getString("fullName");
            int shiftID = rs.getInt("shiftID");

            list.add(new Record(recordID, userID, date, inTime, outTime, shiftID, fullName));
        
        }
        con.close();
        return list;
    }

    public void create(Record record) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Record values(?,?,?,?,?)");

        stm.setString(1, Utilities.sdfDate.format(record.getDate()));
        stm.setInt(2, record.getUserID());
        stm.setInt(3, record.getShiftID());

        if (record.getInTime() == null) {
            stm.setString(4, null);
        } else {
            stm.setString(4, Utilities.sdfDateTime.format(record.getInTime()));
        }
        if (record.getOutTime() == null) {
            stm.setString(5, null);
        } else {
            stm.setString(5, Utilities.sdfDateTime.format(record.getOutTime()));
        }

        stm.executeUpdate();
        con.close();
    }

//    public void create1(int shiftID, int userID, Date date, Date inTime, Date outTime) throws SQLException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("insert into Record values(?,?,?,?,?)");
//        stm.setString(1, Utilities.sdfDate.format(date));
//        stm.setString(2, Utilities.sdfTime.format(inTime));
//        stm.setString(3, Utilities.sdfTime.format(outTime));
//        stm.setInt(4, userID);
//        stm.setInt(5, shiftID);
//        stm.executeUpdate();
//        con.close();
//    }
}
