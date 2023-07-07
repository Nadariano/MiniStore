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
import java.util.ArrayList;
import java.util.List;
import models.ShiftTime;

/**
 *
 * @author Dell
 */
public class ShiftTimeRepository {

    public static List<ShiftTime> select() throws SQLException {
        List<ShiftTime> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from ShiftTime");
        list = new ArrayList<>();
        while (rs.next()) {
            ShiftTime shiftTime = new ShiftTime();
            shiftTime.setShiftID(rs.getInt("shiftID"));
            shiftTime.setShiftName(rs.getString("shiftName"));
            shiftTime.setTimeStart(rs.getTime("timeStart"));
            shiftTime.setTimeEnd(rs.getTime("timeEnd"));
            shiftTime.setCoeShift(rs.getFloat("coeShift"));
            shiftTime.setCoeOT(rs.getFloat("coeOT"));
            shiftTime.setCoeDayOff(rs.getFloat("coeDayOff"));
            shiftTime.setWage(rs.getFloat("wage"));
            shiftTime.setStatus(rs.getInt("status"));
            shiftTime.setStatusText(Utilities.getStatusText(Utilities.getInt(rs, "status")));
            shiftTime.setNote(rs.getString("note"));
            list.add(shiftTime);
        }
        con.close();
        return list;
    }

    public ShiftTime read(int shiftID) throws SQLException {
        ShiftTime shiftTime = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from ShiftTime where shiftID = ?");
        stm.setInt(1, shiftID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            shiftTime = new ShiftTime();
            shiftTime.setShiftID(rs.getInt("shiftID"));
            shiftTime.setShiftName(rs.getString("shiftName"));
            shiftTime.setTimeStart(rs.getTime("timeStart"));
            shiftTime.setTimeEnd(rs.getTime("timeEnd"));
            shiftTime.setCoeShift(rs.getFloat("coeShift"));
            shiftTime.setCoeOT(rs.getFloat("coeOT"));
            shiftTime.setCoeDayOff(rs.getFloat("coeDayOff"));
            shiftTime.setWage(rs.getFloat("wage"));
            shiftTime.setStatus(rs.getInt("status"));
            shiftTime.setNote(rs.getString("note"));
        }
        con.close();
        return shiftTime;
    }

    public void create(ShiftTime shiftTime) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into ShiftTime values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        stm.setString(1, shiftTime.getShiftName());
        stm.setString(2, sdf.format(shiftTime.getTimeStart()));
        stm.setString(3, sdf.format(shiftTime.getTimeEnd()));
        stm.setFloat(4, shiftTime.getCoeShift());
        stm.setFloat(5, shiftTime.getCoeOT());
        stm.setFloat(6, shiftTime.getCoeDayOff());
        stm.setFloat(7, shiftTime.getWage());
        stm.setInt(8, shiftTime.getStatus());
        stm.setString(9, shiftTime.getNote());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(ShiftTime shiftTime) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update ShiftTime set shiftName=?, timeStart=?, timeEnd=?, coeShift=?, coeOT=?, coeDayOff=?, wage=?, status = ?, note = ? where shiftID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
         stm.setString(1, shiftTime.getShiftName());
        stm.setString(2, sdf.format(shiftTime.getTimeStart()));
        stm.setString(3, sdf.format(shiftTime.getTimeEnd()));
        stm.setFloat(4, shiftTime.getCoeShift());
        stm.setFloat(5, shiftTime.getCoeOT());
        stm.setFloat(6, shiftTime.getCoeDayOff());
        stm.setFloat(7, shiftTime.getWage());
        stm.setInt(8, shiftTime.getStatus());
        stm.setString(9, shiftTime.getNote());
        stm.setInt(10, shiftTime.getShiftID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int shiftID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from ShiftTime where shiftID = ? ");
        stm.setInt(1, shiftID);
        int count = stm.executeUpdate();
        con.close();
    }

}
