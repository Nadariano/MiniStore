/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import models.Report;
import models.ShiftTime;
import repositories.ShiftTimeRepository;

/**
 *
 * @author DELL
 */
public class AttendanceService {

    public static Date duration(Date inTime, Date outTime, Date date) {

        if (inTime == null || outTime == null) {
            return null;
        } else {
            Date duration = null;
            long difference = outTime.getTime() - inTime.getTime() + date.getTime();

            if (difference > date.getTime()) {
                duration = new Date(difference);

                return duration;
            } else {
                duration = date;
                return duration;
            }

        }
    }

    public static Date lateTime(Date date, Date inTime, int userID, int shiftID) throws SQLException, ParseException {
        ShiftTimeRepository str = new ShiftTimeRepository();
        ShiftTime st = str.read(shiftID);
        //lateTime = thời gian checkIn - (startTime + requestLateTime)
        Date lateTime = null;

        Report report = Utilities.requestTime(date, userID, shiftID);
        long requestLate = 0;
        if (report != null) {
            if (report.getRequestLateTime() != null) {
                requestLate = report.getRequestLateTime().getTime() - Utilities.correctTime().getTime();
            }

        }

        String strTime = Utilities.sdfTime.format(st.getTimeStart());
        String strDate = Utilities.sdfDate.format(date);
        Date startTime = Utilities.sdfDateTime.parse(strDate + " " + strTime);

        long late = date.getTime();
        if (inTime != null) {
            late = inTime.getTime() - (startTime.getTime() + Utilities.limit5m() + requestLate) + date.getTime();
            if (late <= date.getTime()) {
                late = date.getTime();
            }
            lateTime = new Date(late);
            return lateTime;

        } else {
            return lateTime;
        }
    }

    public static Date soonTime(Date date, Date outTime, int userID, int shiftID) throws SQLException, ParseException {
        //soonTime =(endTime -requestSoonTime) - thời gian 
        ShiftTimeRepository str = new ShiftTimeRepository();
        ShiftTime st = str.read(shiftID);
        Date soonTime = null;

        Report report = Utilities.requestTime(date, userID, shiftID);
        long requestSoon = 0;
        if (report != null) {
            if (report.getRequestSoonTime() != null) {
                requestSoon = report.getRequestSoonTime().getTime() - Utilities.correctTime().getTime();
            }

        }

        String strTime = Utilities.sdfTime.format(st.getTimeEnd());
        String strDate = Utilities.sdfDate.format(date);
        Date endTime = Utilities.sdfDateTime.parse(strDate + " " + strTime);

        long soon = date.getTime();
        if (outTime != null) {
            soon = (endTime.getTime() - requestSoon) - outTime.getTime() + date.getTime();
            if (soon <= date.getTime()) {
                soon = date.getTime();
            }
            soonTime = new Date(soon);
            return soonTime;
        } else {
            return soonTime;
        }
    }

    public static void main(String[] args) throws ParseException, SQLException {

        Date date = Utilities.sdfDate.parse("2023-10-10");
        Date a = date;

        long dif = a.getTime();
        System.out.println("a = " + dif);
        System.out.println(a);

        dif = a.getTime() + 0;
        System.out.println("a1 = " + dif);
        Date b = new Date(dif);
        System.out.println("a1:" + b);
        System.out.println(a + "b");

    }

}
