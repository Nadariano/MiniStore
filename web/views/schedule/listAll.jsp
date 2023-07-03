<%@page import="java.time.LocalDate"%>
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
            LocalDate now = LocalDate.now();
        %>
        <c:set var="now" value="<%=now%>"/>
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h4 class="page-title">Schedule view of your employees</h4>
                </div>
            </div>
            <table class="table-striped schedule">
                <tr>
                    <th>
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle" name="subOp" type="button" data-toggle="dropdown">Select week:
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <c:forEach var="listItem" items="${weeks}" varStatus="loop">
                                    <li class="col-sm-12"><a href="<c:url value="/schedule/selectWeek.do?op=filter&week=${selectedWeek=listItem}"/>">${listItem}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>     

                        <p>${startEndDates[0]} - ${startEndDates[1]}</p>
                    </th>
                    <c:forEach var="i" begin="0" end="${fn:length(listDays) - 1}" step="1" >
                        <th class="<c:if test='${listLocalDates[i]==now}'>today</c:if>">
                            <h2>${listDays[i]}</h2>
                            <p>${listLocalDates[i]}</p>  
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
                                <div>
                                   <c:forEach var="userShift" items="${usersShiftList}" varStatus="loop">

                                    <c:if test="${userShift.shiftID == shift.shiftID}">

                                        <c:set var="userShiftt" value="${usersShiftList[loop.index]}"/>
                                        <c:set var="date" value="${listDates[i]}"/>
                                        <c:if test="${userShiftt.date == date}">
                                            <!--<p>Emp ${userShiftt.userID} - ${userShiftt.date} - ${userShiftt.shiftID}<p>-->
                                            <p class="tooltipp">
                                                <a href="#">Emp ${userShift.fullName}</a>
                                                <span class="tooltiptext">
                                                    UserID: ${userShiftt.userID} -
                                                    Date: ${userShiftt.date} -
                                                    ShiftID:${userShiftt.shiftID}</span>
                                            </p>

                                        </c:if>
                                    </c:if>
                                </c:forEach> 
                                </div>
                                
                                <button class="btn-primary"><i class="bi bi-person-fill-add"></i>Add</button>


                            </td>    
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>

</html>