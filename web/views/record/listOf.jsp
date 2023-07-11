<%-- 
    Document   : listOf
    Created on : Jun 30, 2023, 1:16:58 AM
    Author     : DELL
--%>

<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Record</title>
    </head>

    <body>
        <!--<a href="<c:url value="/record/create.do"/>">Create</a>-->

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
                            <h4 class="page-title">Record</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/record/create.do"/>" class="btn btn-lg btn-success btn-rounded" title="Create a new record">
                                <i class="bi bi-card-text"></i> 
                            </a>

                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table table-striped" id="example">

                                        <thead>
                                            <tr >
                                                <!--<th>No.</th>-->
                                                <th>Record ID</th>
                                                <th>User ID</th>
                                                <th>Fullname</th>
                                                <th>Date</th>
                                                <th>Check In</th>
                                                <th>Check Out</th>
                                                <th>Shift ID</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="rc" items="${list}" varStatus="loop">
                                                <tr>
                                                    <!--<td>${loop.count}</td>-->
                                                    <td>${rc.recordID}</td>
                                                    <td>${rc.userID}</td>
                                                    <td>${rc.fullName}</td>
                                                    <td>${rc.date}</td>
                                                    <td>${rc.inTime}</td>
                                                    <td>${rc.outTime}</td>
                                                    <td>${rc.shiftID}</td>
                                                    <td style="text-align: center">
                                                        <%--<c:if test="${!role.roleName.equals('MANAGER')}">--%>
                                                            <!--<a href="<c:url value="/shiftTime/update.do?shiftID=${shiftTime.shiftID}" />" class="btn btn-sm btn-primary" ><i class="bi bi-pencil-square"></i>Update</a>-->
                                                            <!--<a href="<c:url value="/shiftTime/delete.do?shiftID=${shiftTime.shiftID}" />" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-warning" ><i class="bi bi-trash3"></i>Delete</a>-->
                                                        <%--</c:if>--%>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <i style="color: red">${message}</i>
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
