<%-- 
    Document   : listOf
    Created on : Jun 6, 2023, 6:00:05 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check In </title>
    </head>
    <body>
        <h2>CHECK IN LIST</h2>
        <hr/>
        <a href="<c:url value="/checkIn/create.do"/>"><i class="bi bi-file-earmark-plus"></i>Create</a>
        <a href="<c:url value="/checkIn/readExcel1.do"/>"><i class="bi bi-file-earmark-plus"></i>Excel</a>
        <table class="table table-bordered">
            <tr>
                <!--<th>No.</th>-->
                <th>Check In ID</th>
                <th>Check In Time</th>
                <th>Full Name</th>
                <th>Operations</th>
            </tr>
            <c:forEach var="checkIn" items="${list}" varStatus="loop">
                <tr>
                    <!--<td>${loop.count}</td>-->
                    <td>${checkIn.checkInID}</td>
                    <td>${checkIn.checkInTime}</td>
                    <td>${checkIn.fullName}</td>
                    <td>
                        <a href="<c:url value="/checkIn/delete.do?checkInID=${checkIn.checkInID}" />" onclick="return confirm('Do you really want to remove it?');"><i class="bi bi-trash3"></i>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
