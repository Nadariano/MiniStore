<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>ATTENDANCE</title>
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
                            <h4 class="page-title">ATTENDANCE LIST</h4>
                        </div>
                        <!--                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                                                    <a href="<c:url value="/attendance/create.do"/>" class="btn btn-sm btn-success">Create</a>
                                                </div>-->
                        <!-- /.col-lg-12 -->
                    </div>
                    <form action="<c:url value='/attendance/search.do'/>" class=" form-inline ">
                        <!--                        <div class="" style="display: flex;align-items: center; justify-content: center;">
                        
                                                    <div class="form-group badge bg-info text-uppercase text-white" >
                                                        <label class="text-uppercase" for="searchType">Search By:</label>
                                                        <select id="searchType" name="searchType" onchange="changeSearchType()" class="form-control btn-rounded " >
                                                            <option value="date">Date</option>
                                                            <option value="name">Name</option>
                                                        </select>
                                                    </div>
                        
                                                    <div id="dateInputs" class="form-group  badge bg-info text-uppercase text-white ">
                                                        <label class="text-uppercase"for="day">Day:</label>
                                                        <select name="day" class="form-control btn-rounded ">
                                                            <option value="">Day</option>
                        <% for (int i = 1; i <= 31; i++) {%>
                        <option value="<%= i%>"><%= i%></option>
                        <% } %>
                    </select>

                    <label class="text-uppercase"for="month">Month:</label>
                    <select name="month" class="form-control btn-rounded">
                        <option value="">Month</option>
                        <% for (int i = 1; i <= 12; i++) {%>
                        <option value="<%= i%>"><%= i%></option>
                        <% } %>
                    </select>

                    <label class="text-uppercase"for="year">Year:</label>
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
            </div>-->
                    </form>



                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12 ">
                            <div class="white-box badge center-block ">
                                <div class="table-responsive">
                                    <table class=" table table-striped  " id="attendanceTable">

                                        <thead>
                                            <tr >
                                                <th class="text-center ">NO.</th>
                                                <th class="text-center ">DATE</th>
                                                <th class="text-center ">USER ID</th>
                                                <th class="text-center ">Employee's Name</th>
                                                <th class="text-center ">SHIFT ID</th>
                                                <th class="text-center ">CHECK IN</th>
                                                <th class="text-center ">CHECK OUT</th>
                                                <th class="text-center ">SOON TIME</th>
                                                <th class="text-center ">LATE TIME</th>
                                                <th class="text-center ">DURATION</th>
                                                <th class="text-center ">STATUS</th>
                                                <th class="text-center ">NOTE</th>
                                                <th class="text-center ">CONFIRMATION</th>
                                                <th class="text-center ">OPERATION</th>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div>
                                                </td>
                                                <td><input type="date" class="form-control form-control-sm btn-rounded input-sm " placeholder="DATE" id="search1"></td>
                                                <td><input type="text" class="form-control form-control-sm btn-rounded input-sm " placeholder="USER ID"  id="search2"></td>
                                                <td><input type="text" class="form-control form-control-sm btn-rounded input-sm" placeholder="EMPLOYEE'S NAME" id="search3"></td>
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td><div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td><input type=“text” class="form-control form-control-sm btn-rounded input-sm" placeholder="STATUS" id="search10"></td> 
                                                <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 
                                                 <td> <div type="text" disabled="true" class="form-control form-control-sm btn-rounded input-sm hover-disabled"><i class="bi bi-dash-circle"></i></div></td> 

<!--                                                 <th>No.</th>
                                                <th style="text-align: center">Date</th>
                                                <th>User ID</th>
                                                <th style="text-align: center">Author</th>
                                                <th>Shift ID</th>
                                                <th>Check In</th>
                                                <th>Check Out</th>
                                                <th>Soon Time</th>
                                                <th>Late Time</th>
                                                <th>Duration</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Confirmation</th>
                                                <th>Operation</th> -->

                                            </tr>
                                        </thead>
                                        <tbody >
                                            <c:forEach var="attendance" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td class="helvetica">${loop.count}</td>
                                                    <td class="helvetica">${attendance.date}</td>
                                                    <td class="helvetica">${attendance.userID}</td>
                                                    <td class="helvetica">${attendance.fullName}</td>
                                                    <td class="helvetica">${attendance.shiftID}</td>
                                                    <td class="helvetica">${attendance.checkIn}</td>
                                                    <td class="helvetica">${attendance.checkOut}</td>
                                                    <td class="helvetica">${attendance.soonTime}</td>
                                                    <td class="helvetica">${attendance.lateTime}</td>
                                                    <td class="helvetica">${attendance.duration}</td>
                                                    <td class="helvetica">${attendance.statusText}</td>
                                                    <td class="helvetica">
                                                        <button tabindex="0" class="${empty attendance.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${attendance.note}" 
                                                                data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                                <div class="arrow">
                                                                </div>
                                                                <div class="popover-body text-white p-3" style="padding: 5%">
                                                                <span class="d-block">${attendance.note}
                                                                </span>
                                                                </div>
                                                                </div>' ${empty attendance.note ? 'disabled' : ''}>
                                                        <!--        <i class="${empty users.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                        </button>
                                                    </td>

                                                    <c:choose>
                                                        <c:when test="${attendance.confirm=='Denied'}">
                                                            <td><span class="badge bg-danger fs-6 px-1 py-0">${attendance.confirm}</span></td>
                                                            </c:when>
                                                            <c:when test="${attendance.confirm=='Accepted'}">
                                                            <td><span class="badge bg-success fs-6 px-1 py-0">${attendance.confirm}</span></td>
                                                            </c:when>

                                                    </c:choose>

                                                    <c:if test="${attendance.status != 2}">
                                                        <td>
                                                            <a href="<c:url value="/attendance/update.do?attendID=${attendance.attendID}"  />" class="btn btn-sm btn-github btn-rounded" title="Update">
                                                                <i class="bi bi-pencil-square"></i>
                                                            </a>
                                                            <a href="<c:url value="/attendance/delete.do?attendID=${attendance.attendID}" /> " onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-googleplus btn-rounded" title="Delete">
                                                                <i class="bi bi-trash"></i>
                                                            </a>
                                                        </td>

                                                    </c:if>
                                                    <c:if test="${attendance.status == 2}">
                                                        <td class="badge badge-info ">Finished <i class="bi bi-cloud-check"></i></td>
                                                        </c:if>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <%--<c:if test="${attendance.status == 2}">--%>
                                    <a style="float: right" href="<c:url value="/attendance/done.do"/>"  onclick="return confirm('Do you really want to finish?');" class="btn btn-dropbox btn-rounded">
                                        Done <i class="bi bi-check-circle"></i>
                                    </a>
                                    <%--</c:if>--%>

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