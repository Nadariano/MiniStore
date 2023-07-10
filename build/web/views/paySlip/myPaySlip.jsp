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
            <c:when test="${Account.roleName.equals('SALE')|| Account.roleName.equals('GUARD')}">
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
                                    <table class="table table-striped " id="example">

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
                                                <th>Total</th>
                                                <th>Operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="paySlip" items="${list}" varStatus="loop">
                                            <form action="<c:url value="/paySlip/updateMyPaySlip.do"  />">
                                                <tr>
                                                    <!--<td>${loop.count}</td>-->
                                                    <td>
                                                        <input disabled type="number" id="paySlipID" class="form-control" value="${paySlip.paySlipID}">
                                                        <input type="hidden" name="paySlipID" value="${paySlip.paySlipID}">
                                                    </td>   
                                                    <td>
                                                        <input disabled type="number" id="userID" class="form-control" value="${paySlip.userID}">
                                                        <input type="hidden" name="userID" value="${paySlip.userID}">
                                                    </td>
                                                    <td>
                                                        <input type="text" id="fullName" name="fullName" class="form-control" value="${paySlip.fullName}"/>
                                                    </td>
                                                    <td>
                                                        <input type="number" id="salary" name="salary" class="form-control" value="${paySlip.salary}"/>
                                                    </td>
                                                    <td>
                                                        <input type="number" id="bonus" name="bonus" class="form-control" value="${paySlip.bonus}"/>
                                                    </td>
                                                    <td>
                                                        <input type="number" id="minus" name="minus" class="form-control" value="${paySlip.minus}"/>
                                                    </td>
                                                    <td>
                                                        <input type="hidden" name="status" value="${paySlip.status}">
                                                        <input disabled type="text" id="statusText" class="form-control" value="${paySlip.statusText3}">
                                                        <input type="hidden" name="statusText3" value="${paySlip.statusText3}">
                                                    </td>
                                                    <td>
                                                        <c:if test="${paySlip.status==0}">
                                                            <div class="form-check">
                                                                <input type="radio" id="confirm1" name="confirm" value="Agree">
                                                                <label for="confirm1">Agree</label>
                                                            </div>
                                                            <div class="form-check">
                                                                <input type="radio" id="confirm2" name="confirm" value="Disagree">
                                                                <label for= "confirm2">Disagree</label>
                                                            </div>
                                                        </c:if>

                                                        <c:if test="${paySlip.status==1}">
                                                            <div class= "form-check">
                                                                <input type= "radio"id= "confirm1"name= "confirm"value= "Agree">
                                                                <label for= "confirm1">Agree</label>
                                                            </div>
                                                            <div class= "form-check">
                                                                <input type= "radio"id= "confirm2"name= "confirm"value= "Disagree">
                                                                <label for= "confirm2">Disagree</label>
                                                            </div> 
                                                        </c:if> 
                                                    </td> 
                                                    <td> 
                                                        <input type= "text"id= "note"name= "note"class= "form-control"value= "${paySlip.note}"/> 
                                                    </td> 
                                                    <td>
                                                        <input  type ="text" class= "form-control" value ="${paySlip.salary + paySlip.bonus - paySlip.minus}">
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
