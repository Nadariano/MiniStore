<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>REPORT LIST </title>
    </head>

    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('Manager')}">
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
                                                <th>Create Date</th>
                                                <th>User ID</th>
                                                <th>Author</th>
                                                <th>Description</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="report" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${loop.count}</td>
                                                    <td>${report.reportTitle}</td>
                                                    <td>${report.createDate}</td>
                                                    <td>${report.userID}</td>
                                                    <td>${report.fullName}</td>
                                                    <td>${report.description}</td>
                                                    <c:if test="${report.statusText=='Rejected'}">
                                                        <td style="background-color:  #ac2925; color: whitesmoke " >${report.statusText}</td>
                                                    </c:if>
                                                    <c:if test="${report.statusText=='Approved'}">
                                                        <td style="background-color: #398439; color: whitesmoke">${report.statusText}</td>
                                                    </c:if>
                                                    <c:if test="${report.statusText=='Processing'}">
                                                        <td style="background-color: grey; color: whitesmoke">${report.statusText}</td>
                                                    </c:if>    
                                                    <td>${report.note}</td>

                                                    <td>
                                                        <a href="<c:url value="/report/update.do?reportID=${report.reportID}"  />" class="btn btn-sm btn-primary">Update</a>
                                                        <a href="<c:url value="/report/delete.do?reportID=${report.reportID}" /> " onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-danger">Delete</a>
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
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>