/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class UserShift {
    private int userID;
    private int shiftID;
    private Date date;
    private String statusText2;
    private int status;
    private String note;
    private boolean isOT;
    private String otText;
    private String fullName;
    public UserShift() {
    }

    public UserShift(int userID, int shiftID, Date date, String statusText2, int status, String note, boolean isOT, String otText, String fullName) {
        this.userID = userID;
        this.shiftID = shiftID;
        this.date = date;
        this.statusText2 = statusText2;
        this.status = status;
        this.note = note;
        this.isOT = isOT;
        this.otText = otText;
        this.fullName = fullName;
    }
    

    public UserShift(int userID, int shiftID, Date date, int status, String note, boolean isOT, String otText, String fullName) {
        this.userID = userID;
        this.shiftID = shiftID;
        this.date = date;
        this.status = status;
        this.note = note;
        this.isOT = isOT;
        this.otText = otText;
        this.fullName = fullName;
    }

    
    public UserShift(int userID, int shiftID, Date date, int status, String note, boolean isOT, String fullName) {
        this.userID = userID;
        this.shiftID = shiftID;
        this.date = date;
        this.status = status;
        this.note = note;
        this.isOT = isOT;
        this.fullName = fullName;
    }

   
    

    public UserShift(int userID, int shiftID, Date date, int status, String note, boolean isOT) {
        this.userID = userID;
        this.shiftID = shiftID;
        this.date = date;
        this.status = status;
        this.note = note;
        this.isOT = isOT;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText2() {
        return statusText2;
    }

    public void setStatusText2(String statusText2) {
        this.statusText2 = statusText2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIsOT() {
        return isOT;
    }

    public void setIsOT(boolean isOT) {
        this.isOT = isOT;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOtText() {
        return otText;
    }

    public void setOtText(String otText) {
        this.otText = otText;
    }

    @Override
    public String toString() {
        return "UserShift{" + "userID=" + userID + ", shiftID=" + shiftID + ", date=" + date + ", statusText2=" + statusText2 + ", status=" + status + ", note=" + note + ", isOT=" + isOT + ", otText=" + otText + ", fullName=" + fullName + '}';
    }

    
    
}
