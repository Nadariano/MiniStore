<%-- 
    Document   : listOf
    Created on : Jun 9, 2023, 10:10:40 AM
    Author     : Dell
--%>

<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User Shift</title>
    </head>

    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('Manager')}">
                <!-- Preloader -->
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Users'Shift</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/userShift/create.do"/>" class="btn btn-sm btn-success"><i class="bi bi-file-earmark-plus"></i>Add a new User Shift</a>
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
                                                <!--<th>No.</th>-->
                                                <th>User ID</th>
                                                <th>Full Name</th>
                                                <th>Shift</th>
                                                <th>Date</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Over Time</th>
                                                <th>Operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="userShift" items="${list}" varStatus="loop">
                                                <tr>
                                                    <!--<td>${loop.count}</td>-->
                                                    <td>${userShift.userID}</td>
                                                    <td>${userShift.fullName}</td>
                                                    <td>${userShift.shiftID}</td>
                                                    <td>${userShift.date}</td>
                                                    <td>${userShift.statusText2}</td>
                                                    <td>${userShift.note}</td>
                                                    <td>${userShift.otText}</td>
                                                    <td>
                                                        <c:if test="${!role.roleName.equals('Manager')}">
                                                            <a href="<c:url value="/userShift/update.do?userID=${userShift.userID}&shiftID=${userShift.shiftID}&date=${userShift.date}"/>" class="btn btn-sm btn-primary" ><i class="bi bi-pencil-square"></i>Update</a>
                                                            <a href="<c:url value="/userShift/delete.do?userID=${userShift.userID}&shiftID=${userShift.shiftID}&date=${userShift.date} "/>" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-warning"><i class="bi bi-trash3"></i>Delete</a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>
