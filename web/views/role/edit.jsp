<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Role Editor</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Add a new role</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/role/edit_handler.do"/>" class="form-horizontal form-material">
                            <div class="form-group  ">
                                <label class="col-md-12">Role ID</label>
                                <div class="col-md-12">
                                    <input type="hidden" name="roleID" value="${roles.roleID}" class="text-muted"/>
                                    <input type="text" placeholder="Role ID" name="roleID" value="${roles.roleID}" disabled
                                           class="text-muted form-control"  />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Role Name</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Role Name" name="roleName" value="${roles.roleName}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Status</label>
                                <div class="col-md-12">
                                    <select name="roleStatus"class="form-control form-control-line">
                                        <option value="1">Available</option>
                                        <option value="2">Processing</option>
                                        <option value="3">Not Available</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Description</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Description" name="description" value="${roles.description}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">

                                    <button type="submit" class="btn btn-success" name="op" value="edit">Update <i class="bi bi-check-square"></i></button>
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

    </body>

</html>