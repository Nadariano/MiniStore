/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author acer
 */
public class Item {
    private Attendance attendance;
    private String confirm;

    public Item() {
    }

    public Item(Attendance attendance, String confirm) {
        this.attendance = attendance;
        this.confirm = confirm;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }  
}