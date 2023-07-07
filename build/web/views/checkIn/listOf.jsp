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
        
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">CHECK IN LIST</h4>
                            <!--<a href="<c:url value="/checkIn/create.do"/>"><i class="bi bi-file-earmark-plus"></i>Create manually | </a>-->
                            <!--<a href="<c:url value="/checkIn/readExcel.do"/>"><i class="bi bi-file-earmark-plus"></i>Generate from Excel</a>-->
                            <br>
                            <form action="<c:url value="/checkIn/readExcel.do"/>">
                                <input type="file" name="fileName">
                                <button type="submit" name="op" value="readExcel">Generate from Excel</button>
                                <br>
                                <i style="color: red">${message}</i>
                            </form>
                        </div>
                    </div>
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
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>
</html>
