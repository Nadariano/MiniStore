<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>ATTENDANCE</title>
    </head>

    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <!-- Preloader -->
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">ATTENDANCE LIST</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/attendance/create.do"/>" class="btn btn-sm btn-success">Create</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table" id="example">

                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>Date</th>
                                                <th>User ID</th>
                                                <th>Author</th>
                                                <th>Check In</th>
                                                <th>Check Out</th>
                                                <th>Soon Time</th>
                                                <th>Late Time</th>
                                                <th>Duration</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Confirmation</th>
                                                <th>Operation</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="attendance" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${loop.count}</td>
                                                    <td>${attendance.date}</td>
                                                    <td>${attendance.userID}</td>
                                                    <td>${attendance.fullName}</td>
                                                    <td>${attendance.checkIn}</td>
                                                    <td>${attendance.checkOut}</td>
                                                    <td>${attendance.soonTime}</td>
                                                    <td>${attendance.lateTime}</td>
                                                    <td>${attendance.duration}</td>
                                                    <td>${attendance.statusText}</td>
                                                    <td>${attendance.note}</td>
                                                    <td>${attendance.confirm}</td>
                                                    <td>
                                                        <a href="<c:url value="/attendance/update.do?attendID=${attendance.attendID}"  />" class="btn btn-sm btn-primary">Update</a>
                                                        <p></p>
                                                        <a href="<c:url value="/attendance/delete.do?attendID=${attendance.attendID}" /> " onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-danger">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->

                <!-- /#page-wrapper -->
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>