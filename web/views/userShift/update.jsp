<%-- 
    Document   : update
    Created on : May 31, 2023, 9:07:50 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Shift Updater</title>
    </head>
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
            <h4 class="page-title">Users Shift Update</h4>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <form action="<c:url value="/userShift/update_handler.do"/>">
                <div class="mb-3 mt-3">
                    <label for="userID" class="form-label">User ID:</label>
                    <input disabled type="number" class="form-control" id="userID" placeholder="User ID" value="${userShift.userID}">
                    <input type="hidden" name="userID" value="${userShift.userID}">
                </div>
                <div class="mb-3">
                    <label for="shiftID" class="form-label">Shift:</label>
                    <input  disabled type="number" class="form-control" id="shiftID" placeholder="Shift ID" value="${userShift.shiftID}">
                    <input type="hidden" name="shiftID" value="${userShift.shiftID}">
                </div>
                <div class="mb-3">
                    <label for="date" class="form-label">Date:</label>
                    <input type="date" class="form-control" id="date" placeholder="Date" name="date" value="${userShift.date}">
                </div>
                <div class="mb-3">
                    <label for="status" class="form-label">Status:</label>
                    <!--<input type="number" class="form-control" id="status" placeholder="Status" name="status" value="${userShift.status}">-->
                    <select name="status" class="form-control">
                        <option value="0">Available</option>
                        <option value="1">Not Available</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="note" class="form-label">Note:</label>
                    <input type="text" class="form-control" id="note" placeholder="Note" name="note" value="${userShift.note}">
                </div>
                <div class="mb-3">
                    <label for="isOT" class="form-label">Over Time:</label>
                    <select name="isOT" class="form-control">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
                <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
            </form>
        </div>
    </div>
</div>