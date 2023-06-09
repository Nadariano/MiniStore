<%-- 
    Document   : report-list
    Created on : May 30, 2023, 5:49:00 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List All Reports</title>
</head>
<body>
    <c:choose>
        <c:when test="${Account.roleName.equals('Manager')}">
            <div class="preloader">
                <div class="cssload-speeding-wheel"></div>
            </div>

            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">REPORTS LIST</h4>
                    </div>
                </div>
                <table class="table table-bordered">
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
                    <c:forEach var="report" items="${list}" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${report.reportTitle}</td>
                            <td>${report.createDate}</td>
                            <td>${report.userID}</td>
                            <td>${report.fullName}</td>
                            <td>${report.description}</td>
                            <c:if test="${report.statusText=='Rejected'}">
                                <td style="background-color: #ac2925; color: whitesmoke " >${report.statusText}</td>
                            </c:if>
                            <c:if test="${report.statusText=='Approved'}">
                                <td style="background-color: #398439 ; color: whitesmoke">${report.statusText}</td>
                            </c:if>
                            <c:if test="${report.statusText=='Processing'}">
                                <td style="background-color: grey; color: whitesmoke">${report.statusText}</td>
                            </c:if>    
                            <td>${report.note}</td>

                            <td>
                                <a href="<c:url value="/report/update.do?reportID=${report.reportID}" />"><i class="bi bi-pencil-square"></i>Update</a> <br/>
                                <a href="<c:url value="/report/delete.do?reportID=${report.reportID}" />" onclick="return confirm('Do you really want to remove it?');"><i class="bi bi-trash3"></i>Delete</a>
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
