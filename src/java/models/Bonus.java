/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Dell
 */
public class Bonus {
    private int bonusID;
    private float bonus;
    private int status;
    private String note;
    private String description;
    private int userID;
    private String fullName;

    public Bonus() {
    }

    public Bonus(int bonusID, float bonus, int status, String note, String description, int userID) {
        this.bonusID = bonusID;
        this.bonus = bonus;
        this.status = status;
        this.note = note;
        this.description = description;
        this.userID = userID;
    }

    public Bonus(float bonus, int status, String note, String description, int userID) {
        this.bonus = bonus;
        this.status = status;
        this.note = note;
        this.description = description;
        this.userID = userID;
    }

    public Bonus(int bonusID, float bonus, int status, String note, String description, int userID, String fullName) {
        this.bonusID = bonusID;
        this.bonus = bonus;
        this.status = status;
        this.note = note;
        this.description = description;
        this.userID = userID;
        this.fullName = fullName;
    }

    public int getBonusID() {
        return bonusID;
    }

    public void setBonusID(int bonusID) {
        this.bonusID = bonusID;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
