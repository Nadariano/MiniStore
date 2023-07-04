/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author User
 */
public class Attendance {
//    attendID int identity(1,1),
//	date date,
//	checkIn time,
//	checkOut time,
//	lateTime time,
//	overTime time,
//	status int,
//	note nvarchar(MAX),
//    add userID int foreign key references Users(userID)
    private int attendID;
    private Date date;
    private Date checkIn;
    private Date checkOut;
<<<<<<< HEAD
    private Date lateTime;
    private Date soonTime;
=======
    private Date soonTime;
    private Date lateTime;
>>>>>>> ChunHai
    private Date duration;
    private int status;
    private String note;
    private int userID;
    private int shiftID;
    private String fullName;
    private String confirm;
    private String statusText;
    

    public Attendance() {
    }

<<<<<<< HEAD
    public Attendance(int attendID, Date date, Date checkIn, Date checkOut, Date lateTime, Date soonTime, Date duration, int status, String note, int userID, int shiftID, String fullName, String confirm, String statusText) {
=======
    public Attendance(int attendID, Date date, Date checkIn, Date checkOut, Date soonTime, Date lateTime, Date duration, int status, String note, int userID, String fullName, String confirm, String statusText) {
>>>>>>> ChunHai
        this.attendID = attendID;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.soonTime = soonTime;
        this.lateTime = lateTime;
<<<<<<< HEAD
        this.soonTime = soonTime;
=======
>>>>>>> ChunHai
        this.duration = duration;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.shiftID = shiftID;
        this.fullName = fullName;
        this.confirm = confirm;
        this.statusText = statusText;
    }

    public Attendance(Date date, Date checkIn, Date checkOut, Date lateTime, Date soonTime, int userID) {
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.lateTime = lateTime;
        this.soonTime = soonTime;
        this.userID = userID;
    }

    public Attendance(int attendID, Date date, Date checkIn, Date checkOut, Date lateTime, Date soonTime, Date duration, int status, String note, int userID, int shiftID) {
        this.attendID = attendID;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.lateTime = lateTime;
        this.soonTime = soonTime;
        this.duration = duration;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.shiftID = shiftID;
    }

    public Attendance(Date date, Date checkIn, Date checkOut, Date lateTime, Date soonTime, Date duration, int status, String note, int userID, int shiftID) {
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.lateTime = lateTime;
        this.soonTime = soonTime;
        this.duration = duration;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.shiftID = shiftID;
    }
    
    

    public int getAttendID() {
        return attendID;
    }

    public void setAttendID(int attendID) {
        this.attendID = attendID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

<<<<<<< HEAD
=======
    public Date getSoonTime() {
        return soonTime;
    }

    public void setSoonTime(Date soonTime) {
        this.soonTime = soonTime;
    }

>>>>>>> ChunHai
    public Date getLateTime() {
        return lateTime;
    }

    public void setLateTime(Date lateTime) {
        this.lateTime = lateTime;
    }

<<<<<<< HEAD
    public Date getSoonTime() {
        return soonTime;
    }

    public void setSoonTime(Date soonTime) {
        this.soonTime = soonTime;
=======
    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
>>>>>>> ChunHai
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

<<<<<<< HEAD
    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }
    

    @Override
    public String toString() {
        return "Attendance{" + "attendID=" + attendID + ", date=" + date + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", lateTime=" + lateTime + ", soonTime=" + soonTime + ", duration=" + duration + ", status=" + status + ", note=" + note + ", userID=" + userID + ", fullName=" + fullName + ", confirm=" + confirm + ", statusText=" + statusText + '}';
    }
=======
>>>>>>> ChunHai
    
}
