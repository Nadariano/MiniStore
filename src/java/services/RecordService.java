/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.CheckIn;
import models.CheckOut;
import models.Record;
import models.Report;
import models.ShiftTime;
import models.UserShift;
import repositories.CheckInRepository;
import repositories.ReportRepository;
import repositories.ShiftTimeRepository;
import repositories.UserShiftRepository;

/**
 *
 * @author DELL
 */
public class RecordService {

    public static Record createRecord(int userID, int shiftID, Date date) throws ParseException, SQLException {
        CheckInService cis = new CheckInService();
        CheckOutService cos = new CheckOutService();
        ShiftTimeRepository str = new ShiftTimeRepository();
        ShiftTime st = str.read(shiftID);
        System.out.println("checkIn");
        CheckIn ci = cis.inTime(userID, shiftID, date);
        System.out.println("906090");
        CheckOut co = cos.outTime(userID, shiftID, date);
        System.out.println("checkOut");
        if (ci.getCheckInTime() == null || co.getCheckOutTime() == null) {
            return new Record(userID, date, ci.getCheckInTime(), co.getCheckOutTime(), shiftID);
        } else {
            long check = co.getCheckOutTime().getTime() - ci.getCheckInTime().getTime();
            if (check > 0) {

                return new Record(userID, date, ci.getCheckInTime(), co.getCheckOutTime(), shiftID);
            } else {
                return new Record(userID, date, null, null, shiftID);
            }
        }
    }

//    public static Record inTime1(UserShift us, ShiftTime st, Report report, int userID) throws ParseException, SQLException {
//        Date correctTime = Utilities.sdfTime.parse("00:00:00");
////        Date limit30 = Utilities.sdfTime.parse("00:30:00");
//        Date d = Utilities.sdfDateTime.parse("2023-02-11 03:00:00");
//        System.out.println("d" + d);
////        Date limit1h = Utilities.sdfTime.parse("01:00:00");
//
//        long requestTime = report.getRequestSoonTime().getTime() - correctTime.getTime();
//
//        long limit30m = Utilities.sdfTime.parse("00:30:00").getTime() - correctTime.getTime();
//        System.out.println("limit30: " + limit30m);
//
//        long limit1h = Utilities.sdfTime.parse("01:00:00").getTime() - correctTime.getTime();
//        System.out.println("limit1h: " + limit1h);
//
//        String strDate = Utilities.sdfDate.format(us.getDate());
//        System.out.println("strDate: " + strDate);
//
//        String strStartTime = Utilities.sdfTime.format(st.getTimeStart());
////        String strEndTime = timeFormat.format(us.getTimeEnd());
//        System.out.println("strTime: " + strStartTime);// + " - strEndTime: " + strEndTime
//
//        Date startTime = Utilities.sdfDateTime.parse(strDate + " " + strStartTime);
////        Date endTime = Utilities.sdfDateTime.parse(strDate + " " + strEndTime);
//        System.out.println("startTime: " + startTime);//"+  - endTime" + endTime
//
//        long min = startTime.getTime() - limit30m;
//
//        Date minTime = new Date(min);
//        String strMinTime = Utilities.sdfDateTime.format(minTime);
//
//        long max = startTime.getTime() + requestTime + limit1h;
//        Date maxTime = new Date(max);
//        String strMaxTime = Utilities.sdfDateTime.format(maxTime);
//        System.out.println("minTime: " + minTime + " - maxTime: " + maxTime);
//
//        CheckInRepository cir = new CheckInRepository();
//        List<CheckIn> list = cir.search(minTime, maxTime, userID);
//        for (CheckIn ci : list) {
//            System.out.println(ci.toString());
//        }
//        Record r = new Record();
//
//        return r;
//    }
//
//    public static Record outTime(UserShift us, ShiftTime st, Report report, int userID) throws ParseException, SQLException {
//
//        Date correctTime = Utilities.sdfTime.parse("00:00:00");
//
//        long requestTime = report.getRequestSoonTime().getTime() - correctTime.getTime();
//
//        long limit30m = Utilities.sdfTime.parse("00:30:00").getTime() - correctTime.getTime();
//        System.out.println("limit30: " + limit30m);
//
//        long limit1h = Utilities.sdfTime.parse("01:00:00").getTime() - correctTime.getTime();
//        System.out.println("limit1h: " + limit1h);
//
//        String strDate = Utilities.sdfDate.format(us.getDate());
//        System.out.println("strDate: " + strDate);
//
//        String strStartTime = Utilities.sdfTime.format(st.getTimeStart());
//        String strEndTime = Utilities.sdfTime.format(st.getTimeEnd());
//        System.out.println("strStartTime: " + strStartTime + " - strEndTime: " + strEndTime); //
//
//        Date startTime = Utilities.sdfDateTime.parse(strDate + " " + strStartTime);
//        Date endTime = Utilities.sdfDateTime.parse(strDate + " " + strEndTime);
//        System.out.println("startTime: " + startTime + " - endTime" + endTime);  //
//
//        long min = endTime.getTime() - requestTime - limit1h;
//        Date minTime = new Date(min);
//        long max = endTime.getTime() + limit30m;
//        Date maxTime = new Date(max);
//        System.out.println("minTime: " + minTime + " - maxTime: " + maxTime);
//
//        CheckInRepository cir = new CheckInRepository();
//        List<CheckIn> list = cir.search(minTime, maxTime, userID);
//
//        Record r = new Record();
//
//        return r;
//    }
}
