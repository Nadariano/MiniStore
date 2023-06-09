<%-- 
    Document   : listOf
    Created on : Jun 1, 2023, 6:41:08 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Time List</title>
    </head>
    <body>

        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Shift Time</h4>
                </div>
                <c:if test="${Account.roleName.equals('Manager')}">
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<c:url value="/shiftTime/create.do"/>" class="btn btn-sm btn-success">Create</a>
                </div>
                </c:if>
                <!-- /.col-lg-12 -->
            </div>
            <table class="table table-bordered">
                <tr>
                    <th>No.</th>
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
                <c:forEach var="shiftTime" items="${list}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${shiftTime.shiftID}</td>
                        <td>${shiftTime.timeStart}</td>
                        <td>${shiftTime.timeEnd}</td>
                        <td>${shiftTime.coeShift}</td>
                        <td>${shiftTime.coeOT}</td>
                        <td>${shiftTime.wage}</td>
                        <td>${shiftTime.statusText}</td>
                        <td>${shiftTime.note}</td>
                        <c:if test="${Account.roleName.equals('Manager')}">
                        <td>
                            <a href="<c:url value="/shiftTime/update.do?shiftID=${shiftTime.shiftID}" />"><i class="bi bi-pencil-square"></i>Update</a> <br/>
                            <a href="<c:url value="/shiftTime/delete.do?shiftID=${shiftTime.shiftID}" />" onclick="return confirm('Do you really want to remove it?');"><i class="bi bi-trash3"></i>Delete</a>
                        </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

