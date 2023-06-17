<%-- 
    Document   : listOf
    Created on : Jun 12, 2023, 9:02:14 AM
    Author     : Dell
--%>


<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Bonus List</title>
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
                            <h4 class="page-title">Bonus List</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/bonus/create.do"/>" class="btn btn-sm btn-success"><i class="bi bi-file-earmark-plus"></i>Add a new Bonus</a>
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
                                                <th>Bonus ID</th>
                                                <th>Full Name</th>
                                                <th>Bonus Money</th>
                                                <th>Description</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Operations</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="bonus1" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${bonus1.bonusID}</td>
                                                    <td>${bonus1.fullName}</td>
                                                    <td>${bonus1.bonus}</td>
                                                    <td>${bonus1.description}</td>
                                                    <td>${bonus1.status}</td>
                                                    <td>${bonus1.note}</td>
                                                    <td>
                                                        <c:if test="${!role.roleName.equals('MANAGER')}">
                                                            <a href="<c:url value="/bonus/update.do?bonusID=${bonus1.bonusID}" />" class="btn btn-sm btn-primary"><i class="bi bi-pencil-square"></i>Update</a> <br/>
                                                            <p> </p>
                                                            <a href="<c:url value="/bonus/delete.do?bonusID=${bonus1.bonusID}" />" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-warning"><i class="bi bi-trash3"></i>Delete</a>
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

