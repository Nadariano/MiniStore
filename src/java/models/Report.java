/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;



/**
 *
 * @author User
 */
public class Report {
//    reportID int identity(1,1),
//    reportTitle nvarchar(MAX),
//	createDate DATE,
//	description nvarchar(MAX),
//	status int,
//	note nvarchar(MAX),
    private int reportID;
    private String reportTitle;
    private Date createDate;
    private String description;
    private int status;
    private String statusText;
    private String note;
    private int userID;
    private String fullName;

    public Report() {
    }

    public Report(int reportID, String reportTitle, Date createDate, String description, int status, String statusText, String note, int userID, String fullName) {
        this.reportID = reportID;
        this.reportTitle = reportTitle;
        this.createDate = createDate;
        this.description = description;
        this.status = status;
        this.statusText = statusText;
        this.note = note;
        this.userID = userID;
        this.fullName = fullName;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
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
