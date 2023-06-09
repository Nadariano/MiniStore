<%-- 
    Document   : create
    Created on : Jun 3, 2023, 1:31:44 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>ATTENDANCE CREATION</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/attendance/create_handler.do"/>">
            <div class="mb-3">
                <label for="date" class="form-label">Date:</label>
                <input type="date" class="form-control" id="date" placeholder="Date(Example: 2023-03-23)"name="date" value="${attendance.date}">
            </div>
            <div class="mb-3">
                <label for="userID" class="form-label">User ID:</label>
                <input type="number" class="form-control" id="userID" placeholder="User ID" name="userID" value="${Account.userID}">           
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
            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
    </div>
    <div class="col">
        <img src="<c:url value="/images/hit.gif"/>" alt="">
    </div>
