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

                    <form action="<c:url value="/report/searchByDate.do"/>">
                        <div style="display: flex; align-items: center; justify-content: center;">
                            <select name="day" style="margin-right: 8px;">
                                <option value="">Day</option>
                                <% for (int i = 1; i <= 31; i++) {%>
                                <option value="<%= i%>"><%= i%></option>
                                <% } %>
                            </select>

                            <select name="month" style="margin-right: 8px;">
                                <option value="">Month</option>
                                <% for (int i = 1; i <= 12; i++) {%>
                                <option value="<%= i%>"><%= i%></option>
                                <% } %>
                            </select>

                            <select name="year" style="margin-right: 8px;">
                                <option value="">Year</option>
                                <% for (int i = 1900; i <= 2023; i++) {%>
                                <option value="<%= i%>"><%= i%></option>
                                <% }%>
                            </select>

                            <button type="submit" class="btn btn-primary" name="op" value="search" style="margin-right: 8px;">Search By Date</button>
                        </div>
                    </form>

                    <form action="<c:url value="/report/searchByName.do"/>">
                        <div style="display: flex; align-items: center; justify-content: center;">
                            <label for="fullName" style="margin-right: 8px;">Name:</label>
                            <input type="text" id="fullName" name="fullName" style="margin-right: 8px;">
                            <button type="submit" class="btn btn-primary" name="op" value="search" style="margin-right: 8px;">Search By Name</button>
                        </div>
                    </form>
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
                                                    <th>${report.typeName}</th>
                                                    <td>${report.createDate}</td>
                                                    <td>${report.userID}</td>
                                                    <td>${report.fullName}</td>
                                                    <td>${report.description}</td>
                                                    <td>${report.plannedDate}</td>
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
                                            <h5 style="color:red">${message}</h5>
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