<%-- 
    Document   : create
    Created on : Jun 10, 2023, 9:04:39 PM
    Author     : Dell
--%>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Pay Slip Creation</title>
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
                            <h4 class="page-title">Create a pay slip</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">

                                <form action="<c:url value="/paySlip/create_handler.do"/>" class="form-horizontal form-material">
                                    <div class="form-group">
                                        <label class="col-md-12">User ID</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="User ID" name="userID" value="${paySlip.userID}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Salary</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Salary" name="salary"
                                                   class="form-control form-control-line" id="salaryInput"
                                                   value="<fmt:formatNumber value='${paySlip.salary}' type='currency' currencySymbol='₫' maxFractionDigits='0' />" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Bonus Money</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Bonus Money" name="bonus"
                                                   class="form-control form-control-line" id="bonusInput"
                                                   value="<fmt:formatNumber value='${paySlip.bonus}' type='currency' currencySymbol='₫' maxFractionDigits='0' />" />
                                        </div>
                                    </div>         

                                    <div class="form-group">
                                        <label class="col-md-12">Minus Money</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Minus Money" name="minus"
                                                   class="form-control form-control-line" id="minusInput"
                                                   value="<fmt:formatNumber value='${paySlip.minus}' type='currency' currencySymbol='₫' maxFractionDigits='0' />" />
                                        </div>
                                    </div>   

                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status"class="form-control form-control-line">
                                                <option value="0">Done</option>
                                                <option value="1">Not Done</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Note</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Note" name="note" value="${paySlip.note}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
                                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Back <i class="bi bi-x-square"></i></button>
                                        </div>
                                    </div>
                                </form>
                                <i style="color:red">${message}</i>
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