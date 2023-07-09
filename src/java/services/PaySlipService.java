/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.DayOff;
import models.ShiftTime;
import models.UserShift;
import repositories.DayOffRepository;
import repositories.ShiftTimeRepository;
import repositories.UserShiftRepository;

/**
 *
 * @author DELL
 */
public class PaySlipService {

    public static UserShiftRepository usr = new UserShiftRepository();
    public static ShiftTimeRepository str = new ShiftTimeRepository();

    public static float salary(int shiftID, int userID, Date date, Date duration) throws SQLException, ParseException {
        float salary = 0;
        salary = salary + (wage(shiftID, userID, date) * duration(date, duration));
        return salary;
    }

    public static float wage(int shiftID, int userID, Date date) throws SQLException, ParseException {
        UserShiftRepository usr = new UserShiftRepository();

        UserShift us = usr.read(userID, shiftID, date);

        ShiftTime st = str.read(shiftID);
        
        
        float coeShift = st.getCoeShift();
        float coeBonus = 0;
        float wage = st.getWage();
        float salary = 0;
        if (st.getShiftName().equalsIgnoreCase("Day Shift")) {
            if (checkSunday(date)) {
                coeBonus = st.getCoeDayOff();
            }
            if (checkHoli(date) != null) {
                coeBonus = checkHoli(date).getCoefficient();
            } else {
                coeBonus = coeOT(us.isIsOT(), st.getCoeOT());
            }
            salary = ((wage * coeShift) + (wage * coeBonus));
        } else if (st.getShiftName().equalsIgnoreCase("Night Shift")) {
            if (checkSunday(date)) {
                coeBonus = st.getCoeDayOff();
            }
            if (checkHoli(date) != null) {
                coeBonus = checkHoli(date).getCoefficient();
            } else {
                coeBonus = coeOT(us.isIsOT(), st.getCoeOT());
            }
            salary = ((wage * coeShift) + (wage * coeBonus) + ((wage + (wage * coeBonus)) * 0.2f));
        } else {
            salary = 0;
        }
        return salary;
    }

    public static float coeOT(boolean isOT, float coeOT) {
        if (isOT) {
            return coeOT;
        } else {
            return 0;
        }
    }

    public static boolean checkSunday(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
//        cal.setTime(sdf.parse("2023-06-24 05:11:00"));
        cal.setTime(date);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek == Calendar.SUNDAY);
        if (dayOfWeek == Calendar.SUNDAY) {
            return true;
        }
        return false;
    }

    public static DayOff checkHoli(Date date) throws SQLException {
        DayOffRepository dor = new DayOffRepository();
        List<DayOff> list = dor.select();
        for (DayOff holiday : list) {
            if (date.compareTo(holiday.getDate()) == 0) {
                return holiday;
            }
        }

        return null;
    }

    public static float duration(Date date, Date duration) {

        long minute = 0;
        if (duration == null) {
            System.out.println("duration: null");
            return 0;
        }
        minute = duration.getTime() - date.getTime();
        System.out.println("min " + minute);
        if (minute >= 0) {
            float dur = (float) minute / 1000 / 60 / 60;
            System.out.println("duration: " + dur);
            return dur;
        } else {
            System.out.println("durationnn: " + 0);
            return 0;
        }
    }

    public static void main(String[] args) throws ParseException {

        Date date = Utilities.sdfDateTime.parse("2023-05-11 00:00:00");
        Date duration = Utilities.sdfDateTime.parse("2023-05-11 01:58:00");

        duration(date, duration);

    }
}
