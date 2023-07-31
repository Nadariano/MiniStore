<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>REPORT</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">REPORT LIST</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<c:url value="/report/create.do"/>" class="btn btn-lg btn-success btn-rounded" title="Create another report">
                        <i class="bi bi-credit-card-2-front"></i>
                    </a>

                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box center-block  border-rounded">
                        <div class="table-responsive">
                            <table class="table  table-striped " id="example">

                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Report Title</th>
                                        <th>Type</th>
                                        <th>Create Date</th>
                                        <th>User ID</th>
                                        <th>Author</th>
                                        <th>Description</th>
                                        <th>Planned Date</th>
                                        <th>Request Soon Time</th>
                                        <th>Request Late Time</th>
                                        <th>Shift ID</th>
                                        <th>Status</th>
                                        <th>Note</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="report" items="${list}" varStatus="loop">
                                        <tr>
                                            <td>${loop.count}</td>
                                            <td>${report.reportTitle}</td>
                                            <td>${report.typeName}</td>
                                            <td>${report.createDate}</td>
                                            <td>${report.userID}</td>
                                            <td>${report.fullName}</td>
                                            <td>${report.description}</td>
                                            <td>${report.plannedDate}</td>
                                            <td>${report.requestSoonTime}</td>
                                            <td>${report.requestLateTime}</td>
                                            <td>${report.shiftID}</td>
                                            <c:choose>
                                                <c:when test="${report.statusText=='Rejected'}">
                                                    <td><span class="badge bg-danger fs-6 px-1 py-0">${report.statusText}</span></td>
                                                    </c:when>
                                                    <c:when test="${report.statusText=='Approved'}">
                                                    <td><span class="badge bg-success fs-6 px-1 py-0">${report.statusText}</span></td>
                                                    </c:when>
                                                    <c:when test="${report.statusText=='Processing'}">
                                                    <td><span class="badge bg-warning text-dark fs-6 px-1 py-0">${report.statusText}</span></td>
                                                    </c:when>
                                                </c:choose>
                                            <td>
                                                <button tabindex="0" class="${empty report.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${users.note}" 
                                                        data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                        <div class="arrow">
                                                        </div>
                                                        <div class="popover-body text-white p-3" style="padding: 5%">
                                                        <span class="d-block">${report.note}
                                                        </span>
                                                        </div>
                                                        </div>' ${empty report.note ? 'disabled' : ''}>
                                                <!--        <i class="${empty report.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

        <!-- /#page-wrapper -->
    </body>

</html>