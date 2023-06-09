<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Roles</title>
    </head>

    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('Manager')}">
                <!-- Preloader -->
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Roles</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/role/create.do"/>" class="btn btn-sm btn-success">Add a new role</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table" id="example">

                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>Role ID</th>
                                                <th>Role Name</th>
                                                <th>Status</th>
                                                <th>Description</th>
                                                <th>Operation</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="role" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${loop.count}</td>
                                                    <td>${role.roleID}</td>
                                                    <td>${role.roleName}</td>
                                                    <td>${role.statusText}</td>
                                                    <td>${role.description}</td>
                                                    <td>
                                                        <c:if test="${!role.roleName.equals('Manager')}">
                                                        <a href="<c:url value="/role/edit.do?roleID=${role.roleID}" />" class="btn btn-sm btn-primary">Edit</a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>