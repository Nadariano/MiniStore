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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pc
 */
public class Utilities {
    private static final String fDate="yyyy-MM-dd";
    private static final String fTime="HH:mm:ss";
     private static final String fDateTime="yyyy-MM-dd HH:mm:ss";
   
    public static final SimpleDateFormat sdfDate = new SimpleDateFormat(fDate);
    public static final SimpleDateFormat sdfTime = new SimpleDateFormat(fTime);
    public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(fDateTime);

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
                statusText = "Unknown";
        }

        return statusText;
    }

    public static String getStatusText3(int status) {
        String statusText;

        switch (status) {
            case 0:
                statusText = "Done";
                break;
            case 1:
                statusText = "Not Done";
                break;
            default:
                statusText = "Unknown";
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
            default:
                statusText = "Unknown";
        }

        return statusText;
    }

    public static String getStatusTextOfCofirm(int status) {
        String confirm;

        switch (status) {
            case 0:
                confirm = "Denied";
                break;
            case 1:
                confirm = "Accepted";
                break;
            default:
                confirm = "No choice";
        }

        return confirm;
    }
}
