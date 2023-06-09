/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Pc
 */
public class DayOff {

    private int dayOffID;
    private Date date;
    private float coefficient;
    private String description;
    private int status;
    private String statusText;
    private String note;

    public DayOff() {
    }

    public DayOff(Date date, float coefficent, String description, int status, String note) {

        this.date = date;
        this.coefficient = coefficent;
        this.description = description;
        this.status = status;
        this.note = note;
    }

    public DayOff(int dayOffID, Date date, float coefficient, String description, int status, String note) {
        this.dayOffID = dayOffID;
        this.date = date;
        this.coefficient = coefficient;
        this.description = description;
        this.status = status;
        this.note = note;
    }

    public DayOff(Date date, float coefficent, String description, String statusText, String note) {

        this.date = date;
        this.coefficient = coefficent;
        this.description = description;
        this.statusText = statusText;
        this.note = note;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getDayOffID() {
        return dayOffID;
    }

    public void setDayOffID(int dayOffID) {
        this.dayOffID = dayOffID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
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

}
