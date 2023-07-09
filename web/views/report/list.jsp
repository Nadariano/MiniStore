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
            <c:when test="${Account.roleName.equals('MANAGER')}">
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

                    <form action="<c:url value='/report/search.do'/>" class="form-inline " style="display: flex; align-items: center; justify-content: center;">
                        <div class="" style="display: flex;align-items: center; justify-content: center;">
                            <div class="form-group badge bg-info text-uppercase text-white">
                                <label class="text-uppercase" for="searchType">Search By:</label>
                                <select id="searchType" name="searchType" onchange="changeSearchType()" class="form-control btn-rounded ">
                                    <option value="date">Date</option>
                                    <option value="name">Name</option>
                                </select>
                            </div>

                            <div id="dateInputs" class="form-group  badge bg-info text-uppercase text-white ">
                                <label class="text-uppercase" for="day">Day:</label>
                                <select name="day" class="form-control btn-rounded ">
                                    <option value="">Day</option>
                                    <% for (int i = 1; i <= 31; i++) {%>
                                    <option value="<%= i%>"><%= i%></option>
                                    <% } %>
                                </select>

                                <label class="text-uppercase" for="month">Month:</label>
                                <select name="month" class="form-control btn-rounded">
                                    <option value="">Month</option>
                                    <% for (int i = 1; i <= 12; i++) {%>
                                    <option value="<%= i%>"><%= i%></option>
                                    <% } %>
                                </select>

                                <label class="text-uppercase" for="year">Year:</label>
                                <select name="year" class="form-control btn-rounded">
                                    <option value="">Year</option>
                                    <% for (int i = 1900; i <= 2023; i++) {%>
                                    <option value="<%= i%>"><%= i%></option>
                                    <% }%>
                                </select>
                            </div>

                            <div id="nameInputs" style="display: none;" class="form-group badge bg-info text-uppercase text-white ">
                                <label class="text-uppercase" for="fullName">Name:</label>
                                <input type="text" id="fullName" name="fullName" class="form-control btn-rounded">
                            </div>

                            <div class="badge bg-info">
                                <button type="submit" class="form-control btn btn-rounded " name="op" value="search" title="Search">
                                    <i class="bi bi-search text-dark text-uppercase"></i>
                                </button>
                            </div>
                        </div>
                    </form>




                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box  center-block">
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
                                                        <a tabindex="0" class="btn btn-sm btn-circle btn-info" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${report.note}" data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip"><div class="arrow"></div><div class="popover-body text-white p-3"><span class="d-block">${report.note}</span></div></div>'>
                                                            <i class="bi bi-eye"></i>
                                                        </a>
                                                    </td>

                                                    <td>
                                                        <a href="<c:url value="/report/update.do?reportID=${report.reportID}"  />" class="btn btn-sm btn-github btn-rounded" title="Update">
                                                            <i class="bi bi-pencil-square"></i>
                                                        </a>
                                                        <a href="<c:url value="/report/delete.do?reportID=${report.reportID}" /> " onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-googleplus btn-rounded" title="Delete">
                                                            <i class="bi bi-trash"></i>
                                                        </a>
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