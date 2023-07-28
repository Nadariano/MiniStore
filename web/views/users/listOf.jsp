<%-- 
    Document   : listOf1
    Created on : Jun 8, 2023, 6:44:13 PM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Users</title>
    </head>

    <body>

        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')||Account.roleName.equals('ADMIN')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Users</h4>
                        </div>
                        <c:if test="${Account.roleName.equals('ADMIN')}">
                            <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                                <a href="<c:url value="/users/create.do"/>" class="btn btn-sm btn-success btn-rounded ">Add a new user</a>
                            </div>
                        </c:if>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table table-striped " id="example">

                                        <thead>
                                            <tr>
                                                <!--<th>No.</th>-->
                                                <th>User ID</th>
                                                <th>User Name</th>
                                                <!--<th>Password</th>-->
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
                                        </thead>
                                        <tbody>
                                            <c:forEach var="users" items="${list}" varStatus="loop">
                                                <tr >
                                                    <!--<td>${loop.count}</td>-->
                                                    <c:if test="${!users.roleName.equals('ADMIN')||Account.roleName.equals('ADMIN')}">
                                                        <td>${users.userID}</td>
                                                        <td>${users.userName}</td>
                                                        <!--<td>${users.password}</td>-->
                                                        <td>${users.fullName}</td>
                                                        <td><img width="100px" height="100px" src="<c:url value="${users.avatar}" />"/></td>
                                                        <td>${users.address}</td>
                                                        <td>${users.phone}</td>
                                                        <td>${users.email}</td>
                                                        <td>${users.roleName}</td>
                                                        <td>${users.statusText1}</td>
                                                        <td>
                                                            <button tabindex="0" class="${empty users.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${users.note}" 
                                                                    data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                                    <div class="arrow">
                                                                    </div>
                                                                    <div class="popover-body text-white p-3">
                                                                    <span class="d-block">${users.note}
                                                                    </span>
                                                                    </div>
                                                                    </div>' ${empty users.note ? 'disabled' : ''}>
                                                            <!--        <i class="${empty users.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                            </button>
                                                        </td>





                                                        <td>
                                                            <c:if test="${!users.roleName.equals('ADMIN')&&(!users.roleName.equals('MANAGER')||Account.roleName.equals('ADMIN'))}">
                                                                <a href="<c:url value="/users/update.do?userID=${users.userID}" />" class="btn btn-sm btn-github btn-rounded" title="Update">
                                                                    <i class="bi bi-pencil-square"></i>
                                                                </a>
                                                            </c:if>
                                                        </td>
                                                    </c:if>
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
