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
public class CheckOut {
    private int checkOutID;
    private Date checkOutTime;
    private int userID;
    private String fullName;

    public CheckOut() {
    }

    public CheckOut(int checkOutID, Date checkOutTime, int userID) {
        this.checkOutID = checkOutID;
        this.checkOutTime = checkOutTime;
        this.userID = userID;
    }

    public CheckOut(int checkOutID, Date checkOutTime, int userID, String fullName) {
        this.checkOutID = checkOutID;
        this.checkOutTime = checkOutTime;
        this.userID = userID;
        this.fullName = fullName;
    }

    public CheckOut(Date checkOutTime, int userID) {
        this.checkOutTime = checkOutTime;
        this.userID = userID;
    }

    public int getCheckOutID() {
        return checkOutID;
    }

    public void setCheckOutID(int checkOutID) {
        this.checkOutID = checkOutID;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
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
