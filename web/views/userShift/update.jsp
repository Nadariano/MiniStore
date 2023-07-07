<%-- 
    Document   : update
    Created on : Jun 9, 2023, 10:28:09 AM
    Author     : Dell
--%>
<%@page import="java.time.LocalDate"%>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User Update</title>
    </head>

    <body>
        <%
            LocalDate minDate = LocalDate.now().plusDays(1);
        %>
        <c:set var="minDate" value="<%=minDate%>"/>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Update user's shift info</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">



                                <form action="<c:url value="/userShift/update_handler.do"/>" class="form-horizontal form-material">

                                    <div class="form-group">
                                        <label class="col-md-12">User ID</label>
                                        <div class="col-md-12">
                                            <input disabled type="number" placeholder="User ID" value="${userShift.userID}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="userID" value="${userShift.userID}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Shift</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Shift ID" name="shiftID" value="${oldShiftID}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="oldShiftID" value="${oldShiftID}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Date</label>
                                        <div class="col-md-12">
                                            <input type="date" placeholder="Date" name="date" value="${userShift.date}" min="${minDate}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="oldDate" value="${oldDate}">
                                        </div>
                                    </div>         
                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status"class="form-control form-control-line">
                                                <option value="0" ${userShift.status==0 ? "selected" : ""}>Available</option>
                                                <option value="1" ${userShift.status==1 ? "selected" : ""}>Not Available</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Note</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Note" name="note" value="${userShift.note}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Over Time</label>
                                        <div class="col-md-12">
                                            <select name="isOT" class="form-control form-control-line">
                                                <option value="true" ${userShift.isOT==true ? "selected" : ""}>Yes</option>
                                                <option value="false" ${userShift.isOT==false ? "selected" : ""}>No</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">

                                            <button type="submit" class="btn btn-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
                                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel<i class="bi bi-x-square"></i></button>

                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                        <div class="col-md-2 col-12"></div>
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