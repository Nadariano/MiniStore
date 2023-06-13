<%-- 
    Document   : listOf
    Created on : Jun 9, 2023, 4:14:06 PM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Shift Time</title>
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
                            <h4 class="page-title">Shift Time</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/shiftTime/create.do"/>" class="btn btn-sm btn-success">Create a new shift</a>
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
                                                <th>Shift</th>
                                                <th>Time Start</th>
                                                <th>Time End</th>
                                                <th>Coefficient Of Shift</th>
                                                <th>Coefficient Of Overtime</th>
                                                <th>Wage</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                    <c:if test="${Account.roleName.equals('Manager')}">
                                                    <th>Operations</th>
                                                    </c:if>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="shiftTime" items="${list}" varStatus="loop">
                                                <tr>
                                                    <!--<td>${loop.count}</td>-->
                                                    <td>${shiftTime.shiftID}</td>
                                                    <td>${shiftTime.timeStart}</td>
                                                    <td>${shiftTime.timeEnd}</td>
                                                    <td style="text-align: center">${shiftTime.coeShift}</td>
                                                    <td style="text-align: center">${shiftTime.coeOT}</td>
                                                    <td>${shiftTime.wage}</td>
                                                    <td>${shiftTime.statusText}</td>
                                                    <td>${shiftTime.note}</td>
                                                    <td>
                                                        <c:if test="${!role.roleName.equals('Manager')}">
                                                            <a href="<c:url value="/shiftTime/update.do?shiftID=${shiftTime.shiftID}" />" class="btn btn-sm btn-primary"><i class="bi bi-pencil-square"></i>Update</a>
                                                            <a href="<c:url value="/shiftTime/delete.do?shiftID=${shiftTime.shiftID}" />" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-warning"><i class="bi bi-trash3"></i>Delete</a>
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
