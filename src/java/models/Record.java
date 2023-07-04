/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Record {
    private int recordID;
    private int userID;
    private Date date;
    private Date inTime;
    private Date outTime;
    private int shiftID;
    private String fullName;

    public Record() {
    }

    public Record(int userID, Date date, Date inTime, Date outTime, int shiftID) {
        this.recordID = recordID;
        this.userID = userID;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.shiftID = shiftID;
    }

    public Record(int recordID, int userID, Date date, Date inTime, Date outTime, int shiftID, String fullName) {
        this.recordID = recordID;
        this.userID = userID;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.shiftID = shiftID;
        this.fullName = fullName;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Record{" + "recordID=" + recordID + ", userID=" + userID + ", date=" + date + ", inTime=" + inTime + ", outTime=" + outTime + ", shiftID=" + shiftID + ", fullName=" + fullName + '}';
    }

   


    
}
