<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Role add</title>
    </head>

    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('ADMIN')||Account.roleName.equals('MANAGER')}">
                <!-- Preloader -->
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Day-off add</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">



                                <form action="<c:url value="/dayOff/create_handler.do"/>" class="form-horizontal form-material">



                                    <div class="form-group">
                                        <label class="col-md-12">Date</label>
                                        <div class="col-md-12">
                                            <input type="date" placeholder="Select Date" name="date"   value="<fmt:formatDate value="${dayOff.date}" pattern="yyyy-MM-dd"/>"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Coefficient</label>
                                        <div class="col-md-12">
                                            <input type="number" step="0.5" placeholder="Enter coefficient" name="coefficient" value="${dayOff.coefficient}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Description</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Enter Description" name="description" value="${dayOff.description}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status"class="form-control form-control-line">
                                                <option value="0">Active</option>
                                                <option value="1">Inactive</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Note</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Enter note (if any)" name="note" value="${dayOff.note}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <!--                                    <button type="submit" class="btn btn-success">Add Role</button>-->
                                            <button type="submit" class="btn btn-success" name="op" value="create">Add<i class="bi bi-check-square"></i></button>
                                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Quay lại <i class="bi bi-x-square"></i></button>
                                        </div>
                                    </div>
                                </form>

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