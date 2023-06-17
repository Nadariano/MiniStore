<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User Creation</title>
    </head>

    <body>

        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('ADMIN')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Create a new user</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">



                                <form action="<c:url value="/users/create_handler.do"/>" class="form-horizontal form-material">

                                    <div class="form-group">
                                        <label class="col-md-12">User Name</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="User Name" name="userName" value="${users.userName}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Password</label>
                                        <div class="col-md-12">
                                            <input type="password" placeholder="Password" name="password"  value="${users.password}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>         
                                    <div class="form-group">
                                        <label class="col-md-12">Full Name</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Full Name" name="fullName" value="${users.fullName}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12"> Avatar </label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Avatar" name="avatar" value="${users.avatar}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Address</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Address" name="address" value="${users.address}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Phone Number</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="phone" name="phone" value="${users.phone}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Email</label>
                                        <div class="col-md-12">
                                            <input type="email" placeholder="email" name="email" value="${users.email}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status"class="form-control form-control-line">
                                                <option value="0">Inactive</option>
                                                <option value="1">Active</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Note</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Note" name="note" value="${users.note}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Role</label>
                                        <div class="col-md-12">
                                            <select name="roleID"class="form-control form-control-line">
                                                <option value="1">Manager</option>
                                                <option value="2">Sale</option>
                                                <option value="3">Guard</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">

                                            <button type="submit" class="btn btn-success" name="op" value="create">Create<i class="bi bi-check-square"></i></button>
                                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Back <i class="bi bi-x-square"></i></button>
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