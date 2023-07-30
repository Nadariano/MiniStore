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
            <c:when test="${Account.roleName.equals('MANAGER')}">
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
                            <a href="<c:url value="/shiftTime/create.do"/>" class="btn btn-lg btn-success btn-rounded" title="Create a new shift">
                                <i class="bi bi-calendar2-plus"></i> 
                            </a>
                        </div>






                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table table-responsive table-striped " id="example">
                                        <thead>
                                            <tr >
                                                <!--<th>No.</th>-->
                                                <th>Shift</th>
                                                <th>Shift Name</th>
                                                <th>Time Start</th>
                                                <th>Time End</th>
                                                <th  style="text-align: center">Coefficient Of Shift</th>
                                                <th  style="text-align: center">Coefficient Of Overtime</th>
                                                <th  style="text-align: center">Coefficient Of Day Off</th>
                                                <th>Wage</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                    <c:if test="${Account.roleName.equals('MANAGER')}">
                                                    <th>Operations</th>
                                                    </c:if>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="shiftTime" items="${list}" varStatus="loop">
                                                <tr >
                                                  <!--<td>${loop.count}</td>-->
                                                    <td>${shiftTime.shiftID}</td>
                                                    <td>${shiftTime.shiftName}</td>
                                                    <td>${shiftTime.timeStart}</td>
                                                    <td>${shiftTime.timeEnd}</td>
                                                    <td style="text-align: center">${shiftTime.coeShift}</td>
                                                    <td style="text-align: center">${shiftTime.coeOT}</td>
                                                    <td style="text-align: center">${shiftTime.coeDayOff}</td>
                                                    <td>${shiftTime.wage}</td>
                                                    <td>${shiftTime.statusText}</td>
                                                    <!--<td>
                                                      <a data-toggle="collapse" href="#note-${shiftTime.shiftID}" role="button" aria-expanded="false" aria-controls="note-${shiftTime.shiftID}" class="btn btn-sm btn-circle btn-info">
                                                        <i class="bi bi-eye"></i>
                                                      </a>
                                                      <div class="collapse mt-2" id="note-${shiftTime.shiftID}">
                                                        <div class="card card-body bg-light w-50 h-50 text-wrap">
                                                    ${shiftTime.note}
                                                  </div>
                                                </div>
                                              </td>-->
                                                    <td>
                                                        <button tabindex="0" class="${empty shiftTime.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${shiftTime.note}" 
                                                                data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                                <div class="arrow">
                                                                </div>
                                                                <div class="popover-body text-white p-3">
                                                                <span class="d-block">${shiftTime.note}
                                                                </span>
                                                                </div>
                                                                </div>' ${empty shiftTime.note ? 'disabled' : ''}>
                                                        <!--        <i class="${empty shiftTime.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                        </button>
                                                    </td>

                                                    <td>
                                                        <c:if test="${!role.roleName.equals('MANAGER')}">
                                                            <a href="<c:url value="/shiftTime/update.do?shiftID=${shiftTime.shiftID}" />" class="btn btn-sm btn-github btn-rounded" title="Update">
                                                                <i class="bi bi-pencil-square"></i>
                                                            </a>
                                                            <a href="<c:url value="/shiftTime/delete.do?shiftID=${shiftTime.shiftID}" />" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-googleplus btn-rounded" title="Delete">
                                                                <i class="bi bi-trash"></i>
                                                            </a>
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
