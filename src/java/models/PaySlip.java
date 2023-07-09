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
public class PaySlip {

    private int paySlipID;
    private int userID;
    private String fullName;
    private float salary;
    private float bonus;
    private float minus;
    private Date createDate;
    private int status;
    private String statusText3;
    private String confirm;
    private String note;
    public PaySlip() {
    }

    public PaySlip(int userID, float salary, float bonus, float minus, int status, String note) {
        this.userID = userID;
        this.salary = salary;
        this.bonus = bonus;
        this.minus = minus;
        this.status = status;
        this.note = note;
    }

    
    public PaySlip(int paySlipID, int userID, float salary, float bonus, float minus, int status, String note) {
        this.paySlipID = paySlipID;
        this.userID = userID;
        this.salary = salary;
        this.bonus = bonus;
        this.minus = minus;
        this.status = status;
        this.note = note;
    }

    public PaySlip(int paySlipID, int userID, String fullName, float salary, float bonus, float minus, int status, String statusText3, String note) {
        this.paySlipID = paySlipID;
        this.userID = userID;
        this.fullName = fullName;
        this.salary = salary;
        this.bonus = bonus;
        this.minus = minus;
        this.status = status;
        this.statusText3 = statusText3;
        this.note = note;
    }

    public PaySlip(int userID, float salary, float bonus, float minus, Date createDate, int status, String note) {
        this.userID = userID;
        this.salary = salary;
        this.bonus = bonus;
        this.minus = minus;
        this.createDate = createDate;
        this.status = status;
        this.note = note;
    }



    public PaySlip(int paySlipID, int userID, String fullName, float salary, float bonus, float minus, int status, String statusText3, String confirm, String note) {
        this.paySlipID = paySlipID;
        this.userID = userID;
        this.fullName = fullName;
        this.salary = salary;
        this.bonus = bonus;
        this.minus = minus;
        this.status = status;
        this.statusText3 = statusText3;
        this.confirm = confirm;
        this.note = note;
    }

   


    public int getPaySlipID() {
        return paySlipID;
    }

    public void setPaySlipID(int paySlipID) {
        this.paySlipID = paySlipID;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getMinus() {
        return minus;
    }

    public void setMinus(float minus) {
        this.minus = minus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText3() {
        return statusText3;
    }

    public void setStatusText3(String statusText3) {
        this.statusText3 = statusText3;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "PaySlip{" + "paySlipID=" + paySlipID + ", userID=" + userID + ", fullName=" + fullName + ", salary=" + salary + ", bonus=" + bonus + ", minus=" + minus + ", createDate=" + createDate + ", status=" + status + ", statusText3=" + statusText3 + ", confirm=" + confirm + ", note=" + note + '}';
    }


 
    
}
