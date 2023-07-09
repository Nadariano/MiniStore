<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Day-Off</title>
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
                    <h4 class="page-title">Day-off list</h4>
                </div>


                <c:if test="${Account.roleName.equals('ADMIN')||Account.roleName.equals('MANAGER')}">
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="<c:url value="/dayOff/create.do"/>" class="btn btn-lg btn-success btn-rounded" title="Add another day-off">
                            <i class="bi bi-calendar-event"></i>
                        </a>
                    </div>

                </c:if>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table table-striped " id="example">

                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Day-Off ID</th>
                                        <th>Date</th>
                                        <th>Coefficient</th>
                                        <th>Description</th>
                                        <th>Status</th>
                                        <th>Note</th>
                                            <c:if test="${Account.roleName.equals('ADMIN')}">
                                            <th>Operation</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dayOff" items="${list}" varStatus="loop">
                                        <tr>
                                            <td>${loop.count}</td>
                                            <td>${dayOff.dayOffID}</td>                                       
                                            <td>${dayOff.date}</td>
                                            <td>${dayOff.coefficient}</td>
                                            <td>${dayOff.description}</td>
                                            <td>${dayOff.statusText}</td>
                                            <td>
                                                <a tabindex="0" class="btn btn-sm btn-circle btn-info" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${dayOff.note}" data-template='
                                                   <div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                   <div class="arrow">
                                                   </div>
                                                   <div class="popover-body text-white p-3">
                                                   <span class="d-block">${dayOff.note}</span>
                                                   </div>
                                                   </div>'>
                                                    <i class="bi bi-eye"></i>
                                                </a>
                                            </td>
                                            <c:if test="${Account.roleName.equals('ADMIN')||Account.roleName.equals('MANAGER')}">
                                                <td>
                                                    <a href="<c:url value="/dayOff/edit.do?dayOffID=${dayOff.dayOffID}" />" class="btn btn-sm btn-github btn-rounded" title="Edit">
                                                        <i class="bi bi-pencil-square"></i>
                                                    </a>
                                                    <a href="<c:url value="/dayOff/delete.do?dayOffID=${dayOff.dayOffID}" /> " onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-googleplus btn-rounded" title="Delete">
                                                        <i class="bi bi-trash"></i>
                                                    </a>
                                                </td>

                                            </c:if>
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