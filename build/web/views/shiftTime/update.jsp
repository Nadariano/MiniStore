<%-- 
    Document   : update
    Created on : Jun 1, 2023, 11:00:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shift Time Updater</title>
</head>
<body>
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <h4 class="page-title">Shift Time Updater</h4>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form action="<c:url value="/shiftTime/update_handler.do"/>">
                    <div class="mb-3 mt-3">
                        <label for="shiftID" class="form-label">Shift:</label>
                        <input disabled type="number" class="form-control" id="shiftID" placeholder="Shift" value="${shiftTime.shiftID}">
                        <input type="hidden" name="shiftID" value="${shiftTime.shiftID}">
                    </div>
                    <div class="mb-3">
                        <label for="timeStart" class="form-label">Time Start:</label>
                        <input type="time" class="form-control" id="timeStart" placeholder="Time Start" name="timeStart" value="${shiftTime.timeStart}">
                    </div>
                    <div class="mb-3">
                        <label for="timeEnd" class="form-label">Time End:</label>
                        <input type="time" class="form-control" id="timeEnd" placeholder="Time End" name="timeEnd" value="${shiftTime.timeEnd}">
                    </div>
                    <div class="mb-3">
                        <label for="coeShift" class="form-label">Coefficient of Shift:</label>
                        <input type="number" step="0.1" class="form-control" id="coeShift" name="coeShift" value="${shiftTime.coeShift}">
                    </div>
                    <div class="mb-3">
                        <label for="coeOT" class="form-label">Coefficient of OverTime:</label>
                        <input type="number" step="0.1" class="form-control" id="coeOT" name="coeOT" value="${shiftTime.coeOT}">
                    </div>
                    <div class="mb-3">
                        <label for="wage" class="form-label">Wage:</label>
                        <input type="number" class="form-control" id="wage" name="wage" value="${shiftTime.wage}">
                    </div>
                    <div class="mb-3">
                        <label for="status" class="form-label">Status:</label>
                        <input type="number" class="form-control" id="status" placeholder="Status" name="status" value="${shiftTime.status}">
                    </div>
                    <div class="mb-3">
                        <label for="note" class="form-label">Note:</label>
                        <input type="text" class="form-control" id="note" placeholder="Note" name="note" value="${shiftTime.note}">
                    </div>
                    <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                </form>
            </div>
            <div class="col">
                <img width="500px" height="500px" src="<c:url value="/images/sasuke.gif"/>" alt="">
            </div>
        </div>
    </div>
</body>