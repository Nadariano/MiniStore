<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>schedule</title>
    </head>

    <body>
        <%
            Date now = new Date();
        %>
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h4 class="page-title">Schedule view of your employees</h4>
                </div>
            </div>
            <table class="schedule">
                <tr>
                    <th>
                        <form action="<c:url value="/schedule/selectWeek.do"/>">
                            <!--<input class="form-control form-control-line" type="number" name="week" value="${weekNo}" placeholder="Select i">-->
                            <select class="form-control form-control-line" name="week">
                                <c:forEach var="i" begin="0" end="10" step="1">
                                    <option type="number" value="${weekNo=i}">${i}</option>
                                </c:forEach>
                            </select>
                            <button type="submit" class="btn btn-success" name="op" value="filter">Filter <i class="bi bi-check-square"></i></button>
                        </form>

                        <p>${startEndDates[0]} - ${startEndDates[1]}</p>
                    </th>
                    <c:forEach var="i" begin="0" end="${fn:length(listDays) - 1}" step="1" >
                        <th>
                            <h2>${listDays[i]}</h2>
                            <p>${listDates[i]}</p>
                        </th>
                    </c:forEach>
                </tr>

                <c:forEach var="shift" items="${shifts}" varStatus="loop">
                    <tr class="shift">
                        <td>
                            <h3>
                                Shift ${shift.shiftID}
                            </h3>
                            <p>
                                (${shift.timeStart} - ${shift.timeEnd})
                            </p>
                        </td>
                        <c:forEach var="i" begin="0" end="${fn:length(listDays) - 1}" step="1" >
                                <td> 
                            <c:forEach var="userShift" items="${usersShiftList}" varStatus="loop">
                                <c:if test="${userShift.shiftID==shift.shiftID}">
                                    <p>Emp ${userShift.userID}<p>
                                </c:if>
                            </c:forEach>
                                </td>    
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>

</html>