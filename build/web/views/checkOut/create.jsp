<%-- 
    Document   : create
    Created on : Jun 6, 2023, 6:37:13 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Check In Creation</h2>
<hr/>
<div class="row">
    <div class="col">
        <form action="<c:url value="/checkOut/create_handler.do"/>">
<!--            <div class="mb-3 mt-3">
                <label for="checkOutID" class="form-label">Shift ID:</label>
                <input disabled type="number" class="form-control" id="checkOutID" placeholder="Check In ID" value="${checkOut.checkOutID}">
                <input type="hidden" name="checkOutID" value="${checkOut.checkOutID}">
            </div>-->
            <div class="mb-3">
                <label for="checkOutTime" class="form-label">Check Out Time</label>
                <input type="datetime" class="form-control" id="checkOutTime" name="checkOutTime" value="${checkOut.checkOutTime}">
            </div>
            <div class="mb-3">
                <label for="userID" class="form-label">User ID:</label>
                <input type="number" class="form-control" id="userID" name="userID" value="${checkOut.userID}">
            </div>
            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
        </form>
        <i style="color:red">${message}</i>
    </div>
    <div class="col">
        <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
    </div>