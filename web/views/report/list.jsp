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

<!--                    <form action="<c:url value='/report/search.do'/>" class="form-inline " style="display: flex; align-items: center; justify-content: center;">
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
    </form>-->




                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box badge  center-block">
                                <div class="table-responsive">
                                    <table class="table  table-striped " id="reportTable">

                                        <thead>
                                            <tr>
                                                <th class="text-center ">No.</th>
                                                <th class="text-center ">Report Title</th>
                                                <th class="text-center ">Type</th>
                                                <th class="text-center ">Create Date</th>
                                                <th class="text-center ">User ID</th>
                                                <th class="text-center ">Author</th>
                                                <th class="text-center ">Description</th>
                                                <th class="text-center ">Planned Date</th>
                                                <th class="text-center ">Request Soon Time</th>
                                                <th class="text-center ">Request Late Time</th>
                                                <th class="text-center ">Shift ID</th>
                                                <th class="text-center ">Status</th>
                                                <th class="text-center ">Note</th>
                                                <th class="text-center ">Operations</th>
                                            </tr>
                                            <tr>
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <th>
                                                    <input type="text" class="form-control form-control-sm btn-rounded input-sm " placeholder="Report Title" id="search1">
                                                </th>
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 

                                                <th>
                                                    <input type="date" class="form-control form-control-sm btn-rounded input-sm " placeholder="date" id="search2">
                                                </th>
                                                <th>
                                                    <input type="text" class="form-control form-control-sm btn-rounded input-sm " placeholder="userid" id="search3">
                                                </th>
                                                <th>
                                                    <input type="text" class="form-control form-control-sm btn-rounded input-sm " placeholder="author" id="search4">
                                                </th>
                                                <th>
                                                    <input type="text" class="form-control form-control-sm btn-rounded input-sm " placeholder="desc" id="search5">
                                                </th>
                                                <th> 
                                                    <input type="date" class="form-control form-control-sm btn-rounded input-sm " placeholder="date" id="search6">
                                                </th> 
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td>  
                                                <th>
                                                    <input type=“text” class="form-control form-control-sm btn-rounded input-sm " placeholder="Shift ID" id="search9"> 
                                                </th> 
                                                <th> 
                                                    <input type=“text” class="form-control form-control-sm btn-rounded input-sm " placeholder="Status" id="search10"> 
                                                </th> 

                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
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
                                                        <button tabindex="0" class="${empty report.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${report.note}" 
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