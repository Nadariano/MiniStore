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
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="userIDDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            User ID <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="userIDDropdown">
                                                            <input type="text" class="form-control form-control-sm btn-rounded" placeholder="Search User ID" id="searchUserID">


                                                            <!-- Add sorting functionality here -->




                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="userNameDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            User Name <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="userNameDropdown">
                                                            <input type="text" class="form-control form-control-sm btn-rounded" placeholder="Search User Name" id="searchUserName">


                                                            <!-- Add sorting functionality here -->



                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="fullNameDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Full Name <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="fullNameDropdown">
                                                            <input type="text" class="form-control form-control-sm btn-rounded" placeholder="Search Full Name" id="searchFullName">


                                                            <!-- Add sorting functionality here -->




                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="avatarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Avatar <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="avatarDropdown">
                                                            <!-- Add sorting functionality here -->
                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="addressDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Address <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="addressDropdown">
                                                            <input type="text" class="form-control form-control-sm btn-rounded" placeholder="Search Address" id="searchAddress">


                                                            <!-- Add sorting functionality here -->



                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="phoneDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Phone <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="phoneDropdown">
                                                            <input type="text" class="form-control form-control-sm btn-rounded" placeholder="Search Phone" id="searchPhone">

                                                            <!-- Add sorting functionality here -->




                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="emailDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Email <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="emailDropdown">
                                                            <input type="text" class="form-control form-control-sm btn-rounded" placeholder="Search Email" id="searchEmail">



                                                            <!-- Add sorting functionality here -->

                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <!--                                                    <div class="btn-group">
                                                                                                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                                                Right-aligned menu
                                                                                                            </button>
                                                                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                                                                <button class="dropdown-item" type="button">Action</button>
                                                                                                                <button class="dropdown-item" type="button">Another action</button>
                                                                                                                <button class="dropdown-item" type="button">Something else here</button>
                                                                                                            </div>
                                                                                                        </div>-->
                                                    <div class="btn-group">

                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded " type="button" id="roleDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Role <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left  p-2 btn-rounded " aria-labelledby="roleDropdown" >
                                                            <input type="text" class="form-control form-control-sm btn-rounded " placeholder="Search Role" id="searchRole">

                                                            <!-- Add sorting functionality here -->


                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="statusDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Status <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="statusDropdown">
                                                            <!-- Add sorting functionality here -->



                                                        </div>
                                                    </div>
                                                </th>

                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="noteDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Note <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="noteDropdown">
                                                            <!-- Add sorting functionality here -->



                                                        </div>
                                                    </div>
                                                </th>
                                                <th>
                                                    <div class="btn-group">
                                                        <button class="btn btn-instagram dropdown-toggle btn-rounded" type="button" id="operationsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            Operations <i class="bi bi-caret-down-fill"></i>
                                                        </button>
                                                        <div class="dropdown-menu dropdown-menu-left p-2 btn-rounded" aria-labelledby="operationsDropdown">
                                                            <!-- Add sorting functionality here -->



                                                        </div>
                                                    </div>
                                                </th>

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
