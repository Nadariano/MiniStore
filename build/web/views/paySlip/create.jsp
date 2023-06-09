<%-- 
    Document   : create
    Created on : Jun 4, 2023, 6:46:20 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pay Slip Creator</title>
</head>
<body>


    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <h4 class="page-title">Pay Slip Creation</h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="row">
            <div class="col">
                <form action="<c:url value="/paySlip/create_handler.do"/>">
                    <!--            <div class="mb-3 mt-3">
                                    <label for="paySlipID" class="form-label">Pay Slip ID:</label>
                                    <input disabled type="number" class="form-control" id="paySlipID" value="${paySlip.paySlipID}">
                                    <input type="hidden" name="paySlipID" value="${paySlip.paySlipID}">
                                </div>-->
                    <div class="mb-3">
                        <label for="userID" class="form-label">User ID:</label>
                        <input type="number" class="form-control" id="userID" name="userID" value="${paySlip.userID}">
                    </div>
                    <div class="mb-3">
                        <label for="salary" class="form-label">Salary:</label>
                        <input type="number" step="0.1" class="form-control" id="salary" name="salary" value="${paySlip.salary}">
                    </div>
                    <div class="mb-3">
                        <label for="bonus" class="form-label">Bonus Money:</label>
                        <input type="number" step="0.1" class="form-control" id="bonus"  name="bonus" value="${paySlip.bonus}">
                    </div>
                    <div class="mb-3">
                        <label for="minus" class="form-label">Minus Money:</label>
                        <input type="number" step="0.1" class="form-control" id="minus" name="minus" value="${paySlip.minus}">
                    </div>

                    <div class="mb-3">
                        <label for="status" class="form-label">Status:</label>
                        <!--<input type="number" class="form-control" id="status" placeholder="Status" name="status" value="${paySlip.status}">-->
                        <select name="status" class="form-control">
                            <option value="0">Done</option>
                            <option value="1">Not Done</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="note" class="form-label">Note:</label>
                        <input type="text" class="form-control" id="note" placeholder="Note" name="note" value="${paySlip.note}">
                    </div>
                    <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                </form>
                <i style="color:red">${message}</i>
            </div>
            <div class="col">
                <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
            </div>
            </body>
