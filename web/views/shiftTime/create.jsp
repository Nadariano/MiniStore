<%-- 
    Document   : create
    Created on : Jun 1, 2023, 11:48:20 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shift Time Creator</title>
</head>
<body>
    <c:choose>
        <c:when test="${Account.roleName.equals('Manager')}">
            <div class="preloader">
                <div class="cssload-speeding-wheel"></div>
            </div>
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Create new shift</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form action="<c:url value="/shiftTime/create_handler.do"/>">
                            <div class="mb-3">
                                <label for="timeStart" class="form-label">Time Start:</label>
                                <input type="time" class="form-control" id="timeStart" name="timeStart" value="${shiftTime.timeStart}">
                            </div>
                            <div class="mb-3">
                                <label for="timeEnd" class="form-label">Time End:</label>
                                <input type="time" class="form-control" id="timeEnd" name="timeEnd" value="${shiftTime.timeEnd}">
                            </div>
                            <div class="mb-3">
                                <label for="coeShift" class="form-label">Coefficient of Shift:</label>
                                <input type="number" step="0.1" class="form-control" id="coeShift"  name="coeShift" value="${shiftTime.coeShift}">
                            </div>
                            <div class="mb-3">
                                <label for="coeOT" class="form-label">Coefficient of Overtime:</label>
                                <input type="number" step="0.1" class="form-control" id="coeOT" name="coeOT" value="${shiftTime.coeOT}">
                            </div>
                            <div class="mb-3">
                                <label for="wage" class="form-label">Wage:</label>
                                <input type="number"  step="0.1" class="form-control" id="wage" placeholder="Wage" name="wage" value="${shiftTime.wage}}">
                            </div>

                            <div class="mb-3">
                                <label for="status" class="form-label">Status:</label>
                                <!--<input type="number" class="form-control" id="status" placeholder="Status" name="status" value="${shiftTime.status}">-->
                                <select name="status" class="form-control">
                                    <option value="0">Available</option>
                                    <option value="2">Not Available</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="note" class="form-label">Note:</label>
                                <input type="text" class="form-control" id="note" placeholder="Note" name="note" value="${shiftTime.note}">
                            </div>
                            <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
                            <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                        </form>
                        <i style="color:red">${message}</i>
                    </div>
                    <div class="col">
                        <img src="<c:url value="/images/pokemon1.gif"/>" alt="">
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
        <jsp:forward page="/error/error.do" />
    </c:otherwise>
</c:choose>

</body>