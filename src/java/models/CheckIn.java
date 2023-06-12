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
public class CheckIn {
    private int checkInID;
    private Date checkInTime;
    private int userID;
    private String fullName;

    public CheckIn() {
    }

    public CheckIn(int checkInID, Date checkInTime, int userID) {
        this.checkInID = checkInID;
        this.checkInTime = checkInTime;
        this.userID = userID;
    }

    public CheckIn(int checkInID, Date checkInTime, int userID, String fullName) {
        this.checkInID = checkInID;
        this.checkInTime = checkInTime;
        this.userID = userID;
        this.fullName = fullName;
    }

    public CheckIn(Date checkInTime, int userID) {
        this.checkInTime = checkInTime;
        this.userID = userID;
    }

    public int getCheckInID() {
        return checkInID;
    }

    public void setCheckInID(int checkInID) {
        this.checkInID = checkInID;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
