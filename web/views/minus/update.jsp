<%-- 
    Document   : update
    Created on : Jun 12, 2023, 11:00:09 AM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Minus Update</title>
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
                            <h4 class="page-title">Update minus</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">



                                <form action="<c:url value="/minus/update_handler.do"/>" class="form-horizontal form-material">

                                    <div class="form-group">
                                        <label class="col-md-12">Minus ID</label>
                                        <div class="col-md-12">
                                            <input disabled type="number" placeholder="Minus ID" value="${minus.minusID}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="minusID" value="${minus.minusID}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">User ID</label>
                                        <div class="col-md-12">
                                            <input disabled type="number" placeholder="User ID" value="${minus.userID}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="userID" value="${minus.userID}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Late Time</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Late Time" name="lateTime" value="${minus.lateTime}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Reduction</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Reduction" name="reduction" value="${minus.reduction}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>   

                                    <div class="form-group">
                                        <label class="col-md-12">Fine</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Fine" name="fine" value="${minus.fine}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Description</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Description" name="description" value="${minus.description}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Status" name="status" value="${minus.status}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Note</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Note" name="note" value="${minus.note}"
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