<%-- 
    Document   : update
    Created on : Jun 5, 2023, 10:58:25 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<!-- Page Content -->

<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
            <h4 class="page-title">Attendance Updator</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="<c:url value="/attendance/update_handler.do"/>">
                <div class="mb-3">
                    <input type="hidden" class="form-control" id="attendID" placeholder="Attend ID"  name="attendID" value="${attendance.attendID}">
                </div>
                <div class="mb-3">
                    <label for="date" class="form-label">Date:</label>
                    <input disabled type="date" class="form-control" id="date" placeholder="Date" value="${attendance.date}">
                    <input type="hidden" name="date" value="${attendance.date}">
                </div>
                <div class="mb-3">
                    <label for="userID" class="form-label">User ID:</label>
                    <input disabled type="number" class="form-control" id="userID" placeholder="User ID" name="userID" value="${attendance.userID}"> 
                    <input type="hidden" name="userID" value="${attendance.userID}">
                </div>
                <div class="mb-3">
                    <label for=fullName class="form-label">Full Name:</label>
                    <input disabled type="text" class="form-control" id="fullName" placeholder="Full Name" value="${attendance.fullName}"> 
                    <input type="hidden" name="fullName" value="${attendance.fullName}">
                </div>
                <div class="mb-3">
                    <label for="checkIn" class="form-label">Check In:</label>
                    <input type="time" class="form-control" id="checkIn" placeholder="Check In(Example: 06:30:15_Hour:Minute:Second)"name="checkIn" value="${attendance.checkIn}">
                </div>
                <div class="mb-3">
                    <label for="checkOut" class="form-label">Check Out:</label>
                    <input type="time" class="form-control" id="checkOut" placeholder="Check Out(Example: 06:30:15_Hour:Minute:Second)"name="checkOut" value="${attendance.checkOut}">
                </div>
                <div class="mb-3">
                    <label for="lateTime" class="form-label">Late Time:</label>
                    <input type="time" class="form-control" id="lateTime" placeholder="Late Time(Example: 06:30:15_Hour:Minute:Second)"name="lateTime" value="${attendance.lateTime}">
                </div>
                <div class="mb-3">
                    <label for="overTime" class="form-label">Over Time:</label>
                    <input type="time" class="form-control" id="overTime" placeholder="Over Time(Example: 06:30:15_Hour:Minute:Second)"name="overTime" value="${attendance.overTime}">
                </div>

                <div class="mb-3">
                    <label for="statusText" class="form-label">Status:</label>
                    <select type="dropdown" id="statusText" name="statusText" value="${attendance.statusText}" >
                        <c:if test="${attendance.statusText.equals('Available')}">
                            <option>${attendance.statusText}</option>
                            <option> Not Available </option>
                        </c:if>
                        <c:if test="${attendance.statusText.equals('Not Available')}">
                            <option>${attendance.statusText}</option>
                            <option> Available </option>
                        </c:if>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="note" class="form-label">Note:</label>
                    <textarea  disabled maxlength="300" style="resize: vertical;width: 500px" placeholder="Note(Maximum: 300 characters)"  id="note" name="note">${attendance.note}</textarea>
                </div>
                <div class="mb-3">
                    <label for="confirm" class="form-label">Confirmation:</label>
                    <c:if test="${attendance.confirm.equals('Accepted')}">
                        <input disabled type="radio" name="confirm" id="confirm" value="Accepted" checked> 
                        <label for="confirm">Accepted</label> 

                        <input disabled type="radio" name="confirm" id="confirm" value="Denied"> 
                        <label for="confirm">Denied</label>
                    </c:if>

                    <c:if test="${attendance.confirm.equals('Denied')}">
                        <input disabled type="radio" name="confirm" id="confirm" value="Accepted"> 
                        <label for="confirm">Accepted</label> 

                        <input disabled type="radio" name="confirm" id="confirm" value="Denied" checked> 
                        <label for="confirm">Denied</label>
                    </c:if>
                </div>

                <button type="submit" class="btn btn-outline-success" name="op" value="update">Update<i class="bi bi-check-square"></i></button>
                <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
            </form>
        </div>
    </div>
</div>