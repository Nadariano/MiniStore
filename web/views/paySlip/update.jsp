<%-- 
    Document   : update
    Created on : Jun 12, 2023, 8:02:59 AM
    Author     : Dell
--%>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>PaySlip Update</title>
    </head>

    <body>
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
                            <h4 class="page-title">Update a paySlip</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">



                                <form action="<c:url value="/paySlip/update_handler.do"/>" class="form-horizontal form-material">

                                    <div class="form-group">
                                        <label class="col-md-12">PaySlip ID</label>
                                        <div class="col-md-12">
                                            <input disabled type="number" placeholder="PaySlip ID" value="${paySlip.userID}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="paySlipID" value="${paySlip.paySlipID}">
                                        </div>
                                    </div>   

                                    <div class="form-group">
                                        <label class="col-md-12">User ID</label>
                                        <div class="col-md-12">
                                            <input disabled type="number" placeholder="User ID" value="${paySlip.userID}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="userID" value="${paySlip.userID}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Salary</label>
                                        <div class="col-md-12">
                                            <input  disabled type="number" step="0.1" placeholder="Salary" value="${paySlip.salary}"
class="form-control form-control-line" />
                                             <input type="hidden" name="salary" value="${paySlip.salary}">
                                        </div>
                                    </div>       

                                    <div class="form-group">
                                        <label class="col-md-12">Bonus</label>
                                        <div class="col-md-12">
                                            <input  type="number" step="0.1" placeholder="Bonus" name="bonus" value="${paySlip.bonus}"
                                                    class="form-control form-control-line" />
                                        </div>
                                    </div>           

                                    <div class="form-group">
                                        <label class="col-md-12">Minus</label>
                                        <div class="col-md-12">
                                            <input  disabled type="number" step="0.1" placeholder="Minus" value="${paySlip.minus}"
                                                    class="form-control form-control-line" />
                                            <input type="hidden" name="minus" value="${paySlip.minus}">
                                        </div>
                                    </div>           

                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status"class="form-control form-control-line">
                                                <option value="0">Not Done</option>
                                                <option value="1">Done</option>
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