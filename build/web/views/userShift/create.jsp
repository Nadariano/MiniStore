<%-- 
    Document   : create
    Created on : Jun 9, 2023, 3:51:31 PM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User Shift Creation</title>
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
                            <h4 class="page-title">Create an user shift</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">


                                <form action="<c:url value="/userShift/create_handler.do"/>" class="form-horizontal form-material">
                                    <div class="form-group">
                                        <label class="col-md-12">Select an employee</label>
                                        <!--                                        <div class="col-md-12">
                                                                                    <input type="number" placeholder="User ID" name="userID" value="${userShift.userID}"
                                                                                           class="form-control form-control-line" />
                                                                                </div>-->
                                        <div class="col-md-12">
                                            <select name="userID" class="form-control">
                                                <c:forEach var="user" items="${usl}" varStatus="loop">
                                                    <c:if test="${!user.roleName.equals('MANAGER') && !user.roleName.equals('ADMIN')}">
                                                        <option name="userID" value="${user.userID}">${user.fullName} (${user.roleName})</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>


                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Shift</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Shift ID" name="shiftID" value="${shiftID}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Date</label>
                                        <div class="col-md-12">
                                            <input type="date" placeholder="Date" name="date" value="${date}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>         
                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status"class="form-control form-control-line">
                                                <option value="0">Available</option>
                                                <option value="1">Not Available</option>
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
                                            <select name="isOT"class="form-control form-control-line">
                                                <option value="true">Yes</option>
                                                <option value="false">No</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
                                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Back <i class="bi bi-x-square"></i></button>
                                        </div>
                                    </div>
                                </form>
                                <h2 style=" color: red">${message}</h2>
                            </div>
                        </div>
                        <div class="col-md-2 col-12"></div>
                    </div>
                    <!-- /.row -->
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>