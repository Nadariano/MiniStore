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
public class ShiftTime {
    private int shiftID;
   private Date timeStart;
   private Date timeEnd;
    private float coeShift;
    private float coeOT;
    private float coeDayOff;
    private float wage;
    private int status;
    private String statusText;
    private String note;
    private String shiftName;

    public ShiftTime() {
    }

    public ShiftTime(int shiftID, Date timeStart, Date timeEnd, float coeShift, float coeOT, float coeDayOff, float wage, int status, String note, String shiftName) {
        this.shiftID = shiftID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.coeShift = coeShift;
        this.coeOT = coeOT;
        this.coeDayOff = coeDayOff;
        this.wage = wage;
        this.status = status;
        this.note = note;
        this.shiftName = shiftName;
    }

   
    public ShiftTime(Date timeStart, Date timeEnd, float coeShift, float coeOT, float coeDayOff, float wage, int status, String statusText, String note, String shiftName) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.coeShift = coeShift;
        this.coeOT = coeOT;
        this.coeDayOff = coeDayOff;
        this.wage = wage;
        this.status = status;
        this.statusText = statusText;
        this.note = note;
        this.shiftName = shiftName;
    }
    
    
    
    

    public ShiftTime(int shiftID, Date timeStart, Date timeEnd, float coeShift, float coeOT, float wage, int status, String statusText, String note) {
        this.shiftID = shiftID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.coeShift = coeShift;
        this.coeOT = coeOT;
        this.wage = wage;
        this.status = status;
        this.statusText = statusText;
        this.note = note;
    }

    public ShiftTime(int shiftID, Date timeStart, Date timeEnd, float coeShift, float coeOT, float wage, int status, String note) {
        this.shiftID = shiftID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.coeShift = coeShift;
        this.coeOT = coeOT;
        this.wage = wage;
        this.status = status;
        this.note = note;
    }

    public ShiftTime(Date timeStart, Date timeEnd, float coeShift, float coeOT, float wage, int status, String note) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.coeShift = coeShift;
        this.coeOT = coeOT;
        this.wage = wage;
        this.status = status;
        this.note = note;
    }

    public ShiftTime(int shiftID, Date timeStart, Date timeEnd, float coeShift, float coeOT, float coeDayOff, float wage, int status, String statusText, String note, String shiftName) {
        this.shiftID = shiftID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.coeShift = coeShift;
        this.coeOT = coeOT;
        this.coeDayOff = coeDayOff;
        this.wage = wage;
        this.status = status;
        this.statusText = statusText;
        this.note = note;
        this.shiftName = shiftName;
    }
    
    

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public float getCoeShift() {
        return coeShift;
    }

    public void setCoeShift(float coeShift) {
        this.coeShift = coeShift;
    }

    public float getCoeOT() {
        return coeOT;
    }

    public void setCoeOT(float coeOT) {
        this.coeOT = coeOT;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
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

    public float getCoeDayOff() {
        return coeDayOff;
    }

    public void setCoeDayOff(float coeDayOff) {
        this.coeDayOff = coeDayOff;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
    
    
  
    
}