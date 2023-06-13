<%-- 
    Document   : myPaySlip
    Created on : Jun 10, 2023, 9:16:28 PM
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
            <c:when test="${Account.roleName.equals('Sale')|| Account.roleName.equals('Guard')}">
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
                    <!--                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                                                <a href="<c:url value="/paySlip/create.do"/>" class="btn btn-sm btn-success">Add a new user</a>
                                            </div>-->
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
                                            <!--<th>No.</th>-->
                                            <th>Pay Slip ID</th>
                                            <th>User ID</th>
                                            <th>Full Name</th>
                                            <th>Salary</th>
                                            <th>Bonus Money</th>
                                            <th>Minus Money</th>
                                            <th>Status</th>
                                            <th>Confirmation</th>
                                            <th>Note</th>
                                            <th>Operations</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="paySlip" items="${list}" varStatus="loop">
                                        <form action="<c:url value="/paySlip/updateMyPaySlip.do"  />">
                                            <tr>
                                                <!--<td>${loop.count}</td>-->
                                                <td>
                                                    <input disabled type="number" id="paySlipID"  value="${paySlip.paySlipID}">
                                                    <input type="hidden" name="paySlipID" value="${paySlip.paySlipID}">
                                                </td>   
                                                <td>
                                                    <input disabled type="number" id="userID"  value="${paySlip.userID}">
                                                    <input type="hidden" name="userID" value="${paySlip.userID}">
                                                </td>
                                                <td>
                                                    <input type="text" id="fullName" name="fullName" value="${paySlip.fullName}"/>
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
                                                    <input type="hidden" name="status" value="${paySlip.status}">
                                                    <input disabled type="text" id="statusText"  value="${paySlip.statusText3}">
                                                    <input type="hidden" name="statusText3" value="${paySlip.statusText3}">

                                                </td>
                                                <td>
                                                    <c:if test="${paySlip.status==0}">
                                                        <input type="radio" id="confirm" name="confirm" value="Agree" >Agree
                                                        <p> </p>
                                                        <input type="radio"  id="confirm" name="confirm" value="Disagree"checked>Disagree
                                                    </c:if>

                                                    <c:if test="${paySlip.status==1}">
                                                        <input type="radio" id="confirm" name="confirm" value="Agree" checked >Agree
                                                        <p> </p>
                                                        <input type="radio"  id="confirm" name="confirm" value="Disagree">Disagree
                                                    </c:if>
                                                    <!--                            <input type="radio" id="confirm" name="confirm" value="Agree" >Agree
                                                                                <p> </p>
                                                                                <input type="radio"  id="confirm" name="confirm" value="Disagree">Disagree-->
                                                </td>
                                                <td>
                                                    <input type="text" id="note" name="note" value="${paySlip.note}"/>
                                                </td>
                                                <td>
                                                    <c:if test="${paySlip.status == 0}">
                                                        <button type="submit" class="btn btn-outline-success" name="op" value="updateMyPaySlip">Send<i class="bi bi-check-square"></i></button>
                                                        </c:if>
                                                </td>             
                                            </tr>
                                        </form>
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
