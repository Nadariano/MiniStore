<%-- 
    Document   : listOf
    Created on : Jun 6, 2023, 6:00:05 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out </title>
    </head>
    <body>
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">CHECK OUT LIST</h4>
                            <!--<a href="<c:url value="/checkOut/create.do"/>"><i class="bi bi-file-earmark-plus"></i>Create manually |</a>-->
                            <!--<a href="<c:url value="/checkOut/readExcel.do"/>"><i class="bi bi-file-earmark-plus"></i>Generate from Excel</a>-->
                            <form action="<c:url value="/checkOut/readExcel.do"/>" class="form-inline">
                                <div class="form-group mb-2">
                                    <div class="custom-file">
                                        <div class="input-group">
                                            <label class="input-group-btn">
                                                <span class="btn btn-info">
                                                    Browse… <input type="file" style="display: none;" id="fileName" multiple name="fileName" onchange="updateFileName()">
                                                </span>
                                            </label>
                                            <input type="text" class="form-control" id="inputBox" readonly name="fileName">
                                        </div>
                                    </div>
                                    <p></p>
                                    <button type="submit" class="btn btn-info btn-block mb-2 ml-2" name="op" value="readExcel">
                                        <i class="bi bi-file-earmark-spreadsheet"></i> Generate from Excel
                                    </button>
                                </div>
                                <br>
                                <i style="color: red">${message}</i>
                            </form>

                        </div>
                    </div>
                    <div class="white-box">
                        <table class="table table-bordered table-striped">
                            <tr>
                                <!--<th>No.</th>-->
                                <th>Check Out ID</th>
                                <th>Check Out Time</th>
                                <th>Full Name</th>
                                <!--<th>Operations</th>-->
                            </tr>
                            <c:forEach var="checkOut" items="${list}" varStatus="loop">
                                <tr>
                                    <!--<td>${loop.count}</td>-->
                                    <td>${checkOut.checkOutID}</td>
                                    <td>${checkOut.checkOutTime}</td>
                                    <td>${checkOut.fullName}</td>
<!--                                    <td>
                                        <a href="<c:url value="/checkOut/delete.do?checkOutID=${checkOut.checkOutID}" />" onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-googleplus btn-rounded" title="Delete">
                                            <i class="bi bi-trash"></i>
                                        </a>
                                    </td>-->

                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>
</html>
