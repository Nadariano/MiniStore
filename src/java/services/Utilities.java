/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static java.util.stream.Collectors.toList;
import models.Report;
import repositories.ReportRepository;

/**
 *
 * @author Pc
 */
public class Utilities {

    private static final String fDate = "yyyy-MM-dd";
    private static final String fTime = "HH:mm:ss";
    private static final String fDateTime = "yyyy-MM-dd HH:mm:ss";

    //Convert Date into String
    public static final SimpleDateFormat sdfDate = new SimpleDateFormat(fDate);
    public static final SimpleDateFormat sdfTime = new SimpleDateFormat(fTime);
    public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(fDateTime);

    public static final Date correctTime() throws ParseException {
        Date correctTime = sdfTime.parse("00:00:00");
        return correctTime;
    }

    public static final long limit5m() throws ParseException {
        long limit5m = Utilities.sdfTime.parse("00:05:00").getTime() - correctTime().getTime();
        return limit5m;
    }

    public static final long limit30m() throws ParseException {
        long limit30m = Utilities.sdfTime.parse("00:30:00").getTime() - correctTime().getTime();
        return limit30m;
    }

    public static final long limit1h() throws ParseException {
        long limit1h = Utilities.sdfTime.parse("01:00:00").getTime() - correctTime().getTime();
        return limit1h;
    }

    public static final long limit24h() throws ParseException {
        long nextDay = Utilities.sdfTime.parse("23:59:59").getTime() - correctTime().getTime();
        return nextDay;
    }

    public static Report requestTime(Date date, int userID, int shiftID) throws SQLException {
        ReportRepository rr = new ReportRepository();
        Report report = null;
        if (rr.readDate(date, userID, shiftID) != null) {
            report = rr.readDate(date, userID, shiftID);
        }
        return report;
    }

    //Convert String into Date
    public static final DateTimeFormatter stringToDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");//ten thuat bam
        byte[] hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    public static String getString(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return (value == null || value.trim().isEmpty()) ? "N/A" : value;
    }

    public static int getInt(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return (rs.wasNull() || value < 0) ? -1 : value;
    }

    public static double getDouble(ResultSet rs, String columnName) throws SQLException {
        double value = rs.getDouble(columnName);
        return (rs.wasNull() || value < 0) ? -1 : value;
    }

    public static Date getDate(ResultSet rs, String columnName) throws SQLException {
        Date value = rs.getDate(columnName);
        return (rs.wasNull()) ? null : value;
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "N/A";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static float getFloat(ResultSet rs, String columnName) throws SQLException {
        float value = rs.getFloat(columnName);
        return (rs.wasNull() || value < 0) ? -1 : value;
    }

    public static String formatFloat(float number) {
        if (number < 0) {
            return "N/A";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(number);
    }

    public static String formatInt(int number) {
        if (number < 0) {
            return "N/A";
        }
        return String.valueOf(number);
    }

    public static String formatDouble(double number) {
        if (number < 0) {
            return "N/A";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(number);
    }

    public static boolean getBoolean(ResultSet rs, String columnName) throws SQLException {
        boolean value = rs.getBoolean(columnName);
        return (rs.wasNull()) ? null : value;
    }
//    public static String getStatusText(int status) {
//        String statusText;
//
//        switch (status) {
//            case 1:
//                statusText = "Available";
//                break;
//            case 2:
//                statusText = "Processing";
//                break;
//            case 3:
//                statusText = "Not Available";
//                break;
//            default:
//                statusText = "Unknown";
//        }
//
//        return statusText;
//    }

    public static String getStatusTextOfReport(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Approved";
                break;
            case 1:
                statusText = "Processing";
                break;
            case 2:
                statusText = "Rejected";
                break;
            default:
                statusText = "Unknown";
        }

        return statusText;
    }

    public static String getStatusText1(int status) {
        String statusText1;

        switch (status) {
            case 0:
                statusText1 = "Inactive";
                break;
            case 1:
                statusText1 = "Active ";
                break;
            case 2:
                statusText1 = "Banned";
            default:
                statusText1 = "Unknown";
        }

        return statusText1;
    }

    public static String getStatusText(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Available";
                break;
            case 1:
                statusText = "Processing";
                break;
            case 2:
                statusText = "Not Available";
                break;
            default:
                statusText = "Unknown";
        }

        return statusText;
    }

    public static String getStatusTextForDayOff(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Active";
                break;
            case 1:
                statusText = "Inactive";
                break;
            default:
                statusText = "Unknown";
                break;
        }

        return statusText;
    }

    public static String getStatusText2(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Available";
                break;
            case 1:
                statusText = "Not Available";
                break;
            default:
                statusText = "Done";
        }

        return statusText;
    }

    public static String getStatusText3(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Not Done";
                break;
            case 1:
                statusText = "Done";
                break;
            default:
                statusText = "Done";
        }

        return statusText;
    }

    public static String getOtText(boolean isOT) {
        String otText;
        if (isOT == true) {
            otText = "Yes";
        } else {
            otText = "No";
        }
        return otText;
    }

    public static String getStatusTextOfAttendance(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Not Available";
                break;
            case 1:
                statusText = "Available";
                break;
            case 2:
                statusText = "Available";
                break;
            default:
                statusText = "Unknown";
        }

        return statusText;
    }

    public static String getStatusTextOfConfirm(int status) {
        String confirm;

        switch (status) {
            case 0:
                confirm = "Denied";
                break;
            case 1:
                confirm = "Accepted";
                break;
            case 2:
                confirm = "Accepted";
                break;
            default:
                confirm = "No choice";
        }

        return confirm;
    }

    //Convert String into Date
    public static LocalDate dateString(String stringDate) {
        LocalDate convertedString = LocalDate.parse(stringDate, stringToDate);
        return convertedString;
    }

    public static List<String> listDaysInWeek() {
        List<String> listDays = new ArrayList<>();
        listDays.add("Mon");
        listDays.add("Tue");
        listDays.add("Wed");
        listDays.add("Thu");
        listDays.add("Fri");
        listDays.add("Sat");
        listDays.add("Sun");
        return listDays;
    }

    public static List<LocalDate> listDatesInWeek(LocalDate selectedStartDate) {
//        LocalDate now = LocalDate.now();
//        LocalDate selectedDate= now.plusDays(i*7);
        List<LocalDate> collect = Arrays.asList(DayOfWeek.values()).stream().map(selectedStartDate::with).collect(toList());
        return collect;
    }

    public static Date localDateIntoDate(LocalDate lc) {
        Date date = Date.from(lc.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        return date;
    }

    public static List<Date> listDate(List<LocalDate> localDatexs) {
        List<Date> datexs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Date date = localDateIntoDate(localDatexs.get(i));
            datexs.add(date);
        }
        return datexs;
    }

    public static List<LocalDate> startEndDates(LocalDate selectedDate) {
//        LocalDate now = LocalDate.now();
//        LocalDate selectedDate= now.plusDays(i*7);
        List<LocalDate> collect = Arrays.asList(DayOfWeek.values()).stream().map(selectedDate::with).collect(toList());
        LocalDate startDate = collect.get(0);
        LocalDate endDate = collect.get(6);
        List<LocalDate> startEndDates = Arrays.asList(startDate, endDate);
        return startEndDates;
    }

    //List StartDates of the next 5 weeks
    public static List<String> listStartEndDates() {
        List<String> listStartEndDates = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (int i = -5; i < 5; i++) {
            List<LocalDate> startEndDates = startEndDates(now.plusDays(i * 7));
            LocalDate lst = startEndDates.get(0);
            LocalDate led = startEndDates.get(1);
            Date st = Utilities.localDateIntoDate(lst);
            Date ed = Utilities.localDateIntoDate(led);
            String startDate = sdfDate.format(st);
            String endDate = sdfDate.format(ed);
            String sed = startDate + " - " + endDate;
            listStartEndDates.add(sed);
        }
        return listStartEndDates;
    }

    public static int getLastMonth() {
        LocalDate now = LocalDate.now();
        Month lastMonth = now.minusMonths(1).getMonth();
        int lastMonthNum = lastMonth.getValue();
        return lastMonthNum;
    }
}
