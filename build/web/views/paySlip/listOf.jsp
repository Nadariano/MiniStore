<%-- 
    Document   : listOF
    Created on : Jun 9, 2023, 5:09:16 PM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Pay Slip</title>
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
                            <h4 class="page-title">List of Pay Slip</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/paySlip/create.do"/>" class="btn btn-sm btn-success">Add a new user</a>
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
                                                <th>Pay Slip ID</th>
                                                <th>User ID</th>
                                                <th>Full Name</th>
                                                <th>Salary</th>
                                                <th>Bonus Money</th>
                                                <th>Minus Money</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="paySlip" items="${list}" varStatus="loop">
                                                <tr>
<!--                                                    <td>
                                                        <input disabled type="number" id="paySlipID"  value="${paySlip.paySlipID}">
                                                        <input type="hidden" name="paySlipID" value="${paySlip.paySlipID}">
                                                    </td>   
                                                    <td>
                                                        <input disabled type="number" id="userID"  value="${paySlip.userID}">
                                                        <input type="hidden" name="userID" value="${paySlip.userID}">
                                                    </td>
                                                    <td>
                                                        <input disabled type="text" id="fullName"  value="${paySlip.fullName}">
                                                        <input type="hidden" name="fullName" value="${paySlip.fullName}">
                                                    </td>
                                                    <td>
                                                        <input type="number" id="salary" name="salary" value="${paySlip.salary}"/>
                                                    </td>
                                                    <td>
                                                        <input type="number" id="bonus" name="bonus" value="${paySlip.bonus}"/>
                                                    </td>
                                                    <td>
                                                        <input type="number" id="minus" name="minus" value="${paySlip.minus}"/>
                                                    </td>
                                                    <td>
                                                        <input type="number" name="status" value="${paySlip.status}">
                                                    </td>
                                                    <td>
                                                        <input type="text" id="note" name="note" value="${paySlip.note}"/>
                                                    </td>
                                                    -->
                                                    <td>${paySlip.paySlipID}</td>
                                                    <td>${paySlip.userID}</td>
                                                    <td>${paySlip.fullName}</td>
                                                    <td>${paySlip.salary}</td>
                                                    <td>${paySlip.bonus}</td>
                                                    <td>${paySlip.minus}</td>
                                                    <td>${paySlip.statusText3}</td>
                                                    <td>${paySlip.note}</td>
                                                    <td>
                                                        <a href="<c:url value="/paySlip/update.do?paySlipID=${paySlip.paySlipID}&userID=${paySlip.userID}"/>" class="btn btn-sm btn-primary" ><i class="bi bi-pencil-square"></i>Update</a>
                                                        <p> </p>
                                                        <a href="<c:url value="/paySlip/delete.do?paySlipID=${paySlip.paySlipID}"/>" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-warning"><i class="bi bi-trash3"></i>Delete</a>
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
