<%-- 
    Document   : listOf
    Created on : Jun 4, 2023, 12:07:04 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay Slip</title>
    </head>
    <body>
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">List of payslips</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="<c:url value="/paySlip/create.do"/>" class="btn btn-sm btn-success">Create</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <table class="table table-bordered">
                <tr>
                    <!--<th>No.</th>-->
                    <th>PaySlip ID</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Salary</th>
                    <th>Bonus Money</th>
                    <th>Minus Money</th>
                    <th>Status</th>
                    <th>Note</th>
                    <th>Operations</th>
                </tr>
                <c:forEach var="paySlip" items="${list}" varStatus="loop">
                    <form action="<c:url value="/paySlip/update_delete.do"  />">
                        <tr>
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
                                <input type="number" name="status" value="${paySlip.status}">
                            </td>
                            <td>
                                <input type="text" id="note" name="note" value="${paySlip.note}"/>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-outline-success" name="op" value="update">Update<i class="bi bi-check-square"></i></button>
                                <p> </p>
                                <button type="submit" class="btn btn-danger" name="op" value="delete" onclick="return confirm('Do you really want to remove it?');">Delete<i class="bi bi-x-circle"></i></i></button>
                            </td>       
                        </tr>
                    </form>

                </c:forEach>
            </table>
        </div>
    </body>
</html>
