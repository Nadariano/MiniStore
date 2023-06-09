<%-- 
    Document   : listUserReport
    Created on : May 31, 2023, 6:09:17 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Your Reports</title>
    </head>
    <body>
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">My Reports</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<c:url value="/report/create.do"/>" class="btn btn-sm btn-success">Create another report</a>
                </div>
            </div>
            <table class="table table-bordered">
                <tr>
                    <th>No.</th>
                    <th>Report Title</th>
                    <th>Create Date</th>
                    <!--<th>User ID</th>-->
                    <th>Author</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Note</th>
                </tr>
                <c:forEach var="report" items="${list}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${report.reportTitle}</td>
                        <td>${report.createDate}</td>
                        <!--<td>${report.userID}</td>-->
                        <td>${report.fullName}</td>
                        <td>${report.description}</td>
                        <c:if test="${report.statusText=='Rejected'}">
                            <td style="background-color: red; color: whitesmoke " >${report.statusText}</td>
                        </c:if>
                        <c:if test="${report.statusText=='Approved'}">
                            <td style="background-color: greenyellow; color: whitesmoke">${report.statusText}</td>
                        </c:if>
                        <c:if test="${report.statusText=='Processing'}">
                            <td style="background-color: grey; color: whitesmoke">${report.statusText}</td>
                        </c:if>    
                        <td>${report.note}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
