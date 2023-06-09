<%-- 
    Document   : create
    Created on : May 31, 2023, 9:57:30 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users Shift Creator</title>
</head>
<body>
    <c:choose>
        <c:when test="${Account.roleName.equals('Manager')}">
            <div class="preloader">
                <div class="cssload-speeding-wheel"></div>
            </div>
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Users Shift Creator</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form action="<c:url value="/userShift/create_handler.do"/>">
                            <div class="mb-3 mt-3">
                                <label for="userID" class="form-label">User ID:</label>
                                <input  type="number" class="form-control" id="userID" placeholder="User ID" name="userID" value="${userShift.userID}">
                            </div>
                            <div class="mb-3">
                                <label for="shiftID" class="form-label">Shift:</label>
                                <input type="number" class="form-control" id="shiftID" placeholder="Shift ID" name="shiftID" value="${userShift.shiftID}">
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
                <!--                <input type="text" class="form-control" id="isOT" placeholder="Over Time" name="isOT" value="${userShift.isOT}">-->
                                <select name="isOT" class="form-control">
                                    <option value="true">Yes</option>
                                    <option value="false">No</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                        </form>
                        <i style="color:red">${message}</i>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <jsp:forward page="/error/error.do" />
        </c:otherwise>
    </c:choose>
</body>
