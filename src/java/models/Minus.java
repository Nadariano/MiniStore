/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Dell
 */
public class Minus {
    private int minusID;
    private int lateTime;
    private float reduction;
    private float fine;
    private String description;
    private int status;
    private String note;
    private int userID;
    private String fullName;

    public Minus() {
    }

    public Minus(int lateTime, float reduction, float fine, String description, int status, String note, int userID) {
        this.lateTime = lateTime;
        this.reduction = reduction;
        this.fine = fine;
        this.description = description;
        this.status = status;
        this.note = note;
        this.userID = userID;
    }

    public Minus(int minusID, int lateTime, float reduction, float fine, String description, int status, String note, int userID) {
        this.minusID = minusID;
        this.lateTime = lateTime;
        this.reduction = reduction;
        this.fine = fine;
        this.description = description;
        this.status = status;
        this.note = note;
        this.userID = userID;
    }

    public Minus(int minusID, int lateTime, float reduction, float fine, String description, int status, String note, int userID, String fullName) {
        this.minusID = minusID;
        this.lateTime = lateTime;
        this.reduction = reduction;
        this.fine = fine;
        this.description = description;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.fullName = fullName;
    }

    public int getMinusID() {
        return minusID;
    }

    public void setMinusID(int minusID) {
        this.minusID = minusID;
    }

    public int getLateTime() {
        return lateTime;
    }

    public void setLateTime(int lateTime) {
        this.lateTime = lateTime;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
}
