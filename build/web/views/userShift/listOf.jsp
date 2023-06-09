<%-- 
    Document   : listOf
    Created on : May 31, 2023, 7:50:37 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Shift</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('Manager')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">USERS SHIFT</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/userShift/create.do"/>" class="btn btn-sm btn-success">Create</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>

                    <table class="table table-bordered">
                        <tr>
                            <th>No.</th>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Shift</th>
                            <th>Date</th>
                            <th>Status</th>
                            <th>Note</th>
                            <th>Over Time</th>
                            <th>Operations</th>
                        </tr>
                        <c:forEach var="userShift" items="${list}" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${userShift.userID}</td>
                                <td>${userShift.fullName}</td>
                                <td>${userShift.shiftID}</td>
                                <td>${userShift.date}</td>
                                <td>${userShift.statusText2}</td>
                                <td>${userShift.note}</td>
                                <td>${userShift.otText}</td>
                                <td>
                                    <a href="<c:url value="/userShift/update.do?userID=${userShift.userID}"/>"><i class="bi bi-pencil-square"></i>Update</a> <br/>
                                    <a href="<c:url value="/userShift/delete.do?userID=${userShift.userID}&shiftID=${userShift.shiftID}&date=${userShift.date} "/>" onclick="return confirm('Do you really want to remove it?');"><i class="bi bi-trash3"></i>Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>
</html>