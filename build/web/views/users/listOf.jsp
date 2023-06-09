<%-- 
    Document   : listOf
    Created on : May 28, 2023, 10:59:35 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users List</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('Manager')}">
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Users List</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/users/create.do"/>" class="btn btn-sm btn-success">Create</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>

                    <table class="table table-bordered">
                        <tr>
                            <th>No.</th>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Password</th>
                            <th>Full Name</th>
                            <th>Avatar</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Status</th>
                            <th>Note</th>
                            <th>Operations</th>
                        </tr>
                        <c:forEach var="users" items="${list}" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${users.userID}</td>
                                <td>${users.userName}</td>
                                <td>${users.password}</td>
                                <td>${users.fullName}</td>
                                <td><img width="100px" height="100px" src="<c:url value="${users.avatar}" />"/></td>
                                <td>${users.address}</td>
                                <td>${users.phone}</td>
                                <td>${users.email}</td>
                                <td>${users.roleName}</td>
                                <td>${users.statusText1}</td>
                                <td>${users.note}</td>
                                <td>
                                    <a href="<c:url value="/users/update.do?userID=${users.userID}" />"><i class="bi bi-pencil-square"></i>Update</a> <br/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>

    </body>
</html>
