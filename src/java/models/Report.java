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
    private Date plannedDate;
    private Date requestSoonTime;
    private Date requestLateTime;
    private int status;
    private String statusText;
    private String note;
    private int userID;
    private String fullName;
    private int typeID;
    private String typeName;
    private int shiftID;

    public Report() {
    }

    public Report(int reportID, int status, String note) {
        this.reportID = reportID;
        this.status = status;
        this.note = note;
    }

    public Report(int reportID, String reportTitle, Date createDate, String description, Date plannedDate, Date requestSoonTime, Date requestLateTime, int status, String statusText, String note, int userID, String fullName, int typeID, String typeName, int shiftID) {
        this.reportID = reportID;
        this.reportTitle = reportTitle;
        this.createDate = createDate;
        this.description = description;
        this.plannedDate = plannedDate;
        this.requestSoonTime = requestSoonTime;
        this.requestLateTime = requestLateTime;
        this.status = status;
        this.statusText = statusText;
        this.note = note;
        this.userID = userID;
        this.fullName = fullName;
        this.typeID = typeID;
        this.typeName = typeName;
        this.shiftID = shiftID;
    }

    public Report(int reportID, String reportTitle, Date createDate, String description, Date plannedDate, Date requestSoonTime, Date requestLateTime, int status, String note, int userID, int typeID, int shiftID) {
        this.reportID = reportID;
        this.reportTitle = reportTitle;
        this.createDate = createDate;
        this.description = description;
        this.plannedDate = plannedDate;
        this.requestSoonTime = requestSoonTime;
        this.requestLateTime = requestLateTime;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.typeID = typeID;
        this.shiftID = shiftID;
    }

    public Report(String reportTitle, Date createDate, String description, Date plannedDate, Date requestSoonTime, Date requestLateTime, int status, String note, int userID, int typeID, int shiftID) {
        this.reportTitle = reportTitle;
        this.createDate = createDate;
        this.description = description;
        this.plannedDate = plannedDate;
        this.requestSoonTime = requestSoonTime;
        this.requestLateTime = requestLateTime;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.typeID = typeID;
        this.shiftID = shiftID;
    }

    
    
    public Report(String reportTitle, Date plannedDate, Date requestSoonTime, Date requestLateTime, int status, String note, int userID, int typeID) {
        this.reportTitle = reportTitle;
        this.plannedDate = plannedDate;
        this.requestSoonTime = requestSoonTime;
        this.requestLateTime = requestLateTime;
        this.status = status;
        this.note = note;
        this.userID = userID;
        this.typeID = typeID;
    }
    

    public Report(int reportID, String reportTitle, Date createDate, String description, Date plannedDate, Date requestSoonTime, Date requestLateTime, int status, String statusText, String note, int userID, String fullName, int typeID, String typeName) {
        this.reportID = reportID;
        this.reportTitle = reportTitle;
        this.createDate = createDate;
        this.description = description;
        this.plannedDate = plannedDate;
        this.requestSoonTime = requestSoonTime;
        this.requestLateTime = requestLateTime;
        this.status = status;
        this.statusText = statusText;
        this.note = note;
        this.userID = userID;
        this.fullName = fullName;
        this.typeID = typeID;
        this.typeName = typeName;
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

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Date getRequestSoonTime() {
        return requestSoonTime;
    }

    public void setRequestSoonTime(Date requestSoonTime) {
        this.requestSoonTime = requestSoonTime;
    }

    public Date getRequestLateTime() {
        return requestLateTime;
    }

    public void setRequestLateTime(Date requestLateTime) {
        this.requestLateTime = requestLateTime;
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

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    
}
