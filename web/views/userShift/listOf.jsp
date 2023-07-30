<%-- 
    Document   : listOf
    Created on : Jun 9, 2023, 10:10:40 AM
    Author     : Dell
--%>

<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User Shift</title>
    </head>

    <body>
        <%
            LocalDate nowLocalDate = LocalDate.now();
            Date nowDate = new Date();
        %>
        <c:set var="nowLocalDate" value="<%=nowLocalDate%>"/>
        <c:set var="nowDate" value="<%=nowDate%>"/>
        <%--        
                <c:choose>
                    <c:when test="${Account.roleName.equals('MANAGER')}">
        --%>
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

                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class=" row ">
                <div id="myTab" class="pull-left badge bg-white">
                    <a class="btn btn-rounded btn-flickr" href="#listView" data-toggle="tab">List View </a>
                    <a class="btn btn-rounded btn-linkedin" href="#blockView" data-toggle="tab">Block View</a>
                </div>
            </div>
            <div class="tab-content">
                <div class="tab-pane" id="listView">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <c:if test="${Account.roleName.equals('MANAGER')}">
                                    <a href="<c:url value="/userShift/create.do"/>" class="btn btn-lg btn-success btn-rounded" title="Add a new User Shift">
                                        <i class="bi bi-file-earmark-plus"></i> 
                                    </a>
                                </c:if>
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
                                                    <c:if test="${Account.roleName.equals('MANAGER')}">
                                                    <th>Operations</th>
                                                    </c:if>
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
                                                  
                                                     <td>
                                                            <button tabindex="0" class="${empty userShift.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${userShift.note}" 
                                                                    data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                                    <div class="arrow">
                                                                    </div>
                                                                    <div class="popover-body text-white p-3">
                                                                    <span class="d-block">${userShift.note}
                                                                    </span>
                                                                    </div>
                                                                    </div>' ${empty userShift.note ? 'disabled' : ''}>
                                                            <!--        <i class="${empty userShift.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                            </button>
                                                        </td>
                                                    
                                                    
                                                    
                                                    <td>${userShift.otText}</td>
                                                    <c:if test="${Account.roleName.equals('MANAGER') && userShift.status != 2 && (userShift.date>nowDate)}">
                                                        <td>
                                                            <a href="<c:url value="/userShift/update.do?userID=${userShift.userID}&oldShiftID=${userShift.shiftID}&oldDate=${userShift.date}"/>" class="btn btn-sm btn-github btn-rounded" title="Update">
                                                                <i class="bi bi-pencil-square"></i>
                                                            </a>
                                                            <a href="<c:url value="/userShift/delete.do?userID=${userShift.userID}&shiftID=${userShift.shiftID}&date=${userShift.date} "/>" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-googleplus btn-rounded" title="Delete">
                                                                <i class="bi bi-trash"></i>
                                                            </a>
                                                        </td>

                                                    </c:if>
                                                    <c:if test="${userShift.status == 2}">
                                                        <td class="badge badge-info">Finished <i class="bi bi-cloud-check"></i></td>
                                                        </c:if>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <c:if test="${Account.roleName.equals('MANAGER')}">
                                          <a href="<c:url value="/userShift/done.do"/>" onclick="return confirm('Do you really want to finish?');" class="btn btn-dropbox btn-rounded"><i class="bi bi-check-circle"></i> Done</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="tab-pane active" id="blockView">
                    <div class="white-box ">
                        <div class="row ">
                            <div class="col-sm-12 ">
                                <div class="table-responsive  center-block overlay-box overflow">
                                    <table class="table-striped schedule  font-bold">

                                        <tr>
                                            <th>
                                                <div class="dropdown">
                                                    <button class="btn btn-tumblr dropdown-toggle" name="subOp" type="button" data-toggle="dropdown">Select week:
                                                        <span class="caret"></span></button>
                                                    <ul class="dropdown-menu text-uppercase">
                                                        <c:forEach var="listItem" items="${weeks}" varStatus="loop" >
                                                            <li class="col-sm-12  ${listItem==weeks[5] ? 'currWeek':''}"><a href="<c:url value="/userShift/selectWeek.do?op=filter&week=${listItem}"/>" ${listItem==weeks[5] ? 'selected':''}>${listItem}</a></li>
                                                            </c:forEach>
                                                    </ul>
                                                </div>     

                                                <p>${startEndDates[0]} - ${startEndDates[1]}</p>
                                            </th>
                                            <c:forEach var="i" begin="0" end="${fn:length(listDays) - 1}" step="1" >
                                                <th class="<c:if test='${listLocalDates[i]==nowLocalDate}'>today</c:if>">
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
                                                    <%
                                                        int count = 0;
                                                    %>
                                                    <td> 
                                                        <div>
                                                            <c:forEach var="userShift" items="${list}" varStatus="loop">

                                                                <c:if test="${userShift.shiftID == shift.shiftID}">

                                                                    <c:set var="userShiftt" value="${userShift}"/>
                                                                    <c:set var="date" value="${listDates[i]}"/>
                                                                    <c:if test="${userShiftt.date == date}">
                                                                        <!--<p>Emp ${userShiftt.userID} - ${userShiftt.date} - ${userShiftt.shiftID}<p>-->
                                                                        <div class="tooltipp">
                                                                            <c:if test="${Account.roleName.equals('MANAGER') && (listLocalDates[i]>nowLocalDate)}">
                                                                                <a href="<c:url value="/userShift/delete.do?userID=${userShift.userID}&shiftID=${userShift.shiftID}&date=${userShift.date} "/>" onclick="return confirm('Do you really want to remove this employee from the current shift?');" class="btn btn-circle btn-sm btn-warning">
                                                                                    <i class="bi bi-person-dash-fill"></i>
                                                                                </a>
                                                                            </c:if>
                                                                            <a href="<c:url value="/userShift/update.do?userID=${userShift.userID}&oldShiftID=${userShift.shiftID}&oldDate=${userShift.date}"/>" ${((listLocalDates[i]<=nowLocalDate) || !Account.roleName.equals('MANAGER')) ? "style='pointer-events: none'" : ""}>${userShift.fullName}</a>
                                                                            <span class="tooltiptext">
                                                                                UserID: ${userShiftt.userID} -
                                                                                Date: ${userShiftt.date} <br/>
                                                                                ShiftID:${userShiftt.shiftID} -
                                                                                Is overTime? ${userShift.isOT}</span>
                                                                        </div><br/>
                                                                        <% count = count + 1;%>
                                                                    </c:if>
                                                                </c:if>
                                                            </c:forEach> 
                                                            <c:set var = "count" value="<%=count%>"/>
                                                        </div>
                                                        <!--The day to add shift must be AFTER today-->
                                                        <c:if test="${Account.roleName.equals('MANAGER') && (count<3) && (listLocalDates[i]>nowLocalDate)}">
                                                            <button class="btn btn-sm btn-success">
                                                                <a href="<c:url value="/userShift/create.do?shiftID=${shift.shiftID}&date=${listLocalDates[i]}"/>">
                                                                    <i class="bi bi-person-fill-add"></i>Add
                                                                </a>
                                                            </button>
                                                        </c:if>

                                                    </td>    
                                                </c:forEach>
                                            </tr>
                                        </c:forEach>

                                    </table>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
            <%--
                        </c:when>
                        <c:otherwise>
                            <jsp:forward page="/error/error.do" />
                        </c:otherwise>
                    </c:choose>
            --%>
    </body>

</html>
