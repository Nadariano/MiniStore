<%-- 
    Document   : list
    Created on : Jun 1, 2023, 1:07:20 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATTENDANCES LIST</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('Manager')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">List of attendances</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/attendance/create.do"/>" class="btn btn-sm btn-success">Create</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <table class="table table-bordered">
                        <tr>
                            <th>No.</th>
                            <th>Date</th>
                            <th>User ID</th>
                            <th>Author</th>
                            <th>Check In</th>
                            <th>Check Out</th>
                            <th>Late Time</th>
                            <th>Over Time</th>
                            <th>Status</th>
                            <th>Note</th>
                            <th>Confirmation</th>
                            <th>Operation</th>
                        </tr>
                        <c:forEach var="attendance" items="${list}" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${attendance.date}</td>
                                <td>${attendance.userID}</td>
                                <td>${attendance.fullName}</td>
                                <td>${attendance.checkIn}</td>
                                <td>${attendance.checkOut}</td>
                                <td>${attendance.lateTime}</td>
                                <td>${attendance.overTime}</td>
                                <td>${attendance.statusText}</td>
                                <td>${attendance.note}</td>
                                <td>${attendance.confirm}</td>
                                <td>
                                    <a href="<c:url value="/attendance/update.do?attendID=${attendance.attendID}" />"><i class="bi bi-pencil-square"></i>Update</a> <br/>
                                    <a href="<c:url value="/attendance/delete.do?attendID=${attendance.attendID}" />" onclick="return confirm('Do you really want to remove it?');"><i class="bi bi-trash3"></i>Delete</a>
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


