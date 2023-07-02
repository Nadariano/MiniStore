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
                    <a href="<c:url value="/report/create.do"/>" class="btn btn-sm btn-success">Create another report</a>
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
                                            <c:if test="${report.statusText=='Rejected'}">
                                                <td style="background-color: #ac2925; color: whitesmoke " >${report.statusText}</td>
                                            </c:if>
                                            <c:if test="${report.statusText=='Approved'}">
                                                <td style="background-color: #398439; color: whitesmoke">${report.statusText}</td>
                                            </c:if>
                                            <c:if test="${report.statusText=='Processing'}">
                                                <td style="background-color: grey; color: whitesmoke">${report.statusText}</td>
                                            </c:if>    
                                            <td>${report.note}</td>
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