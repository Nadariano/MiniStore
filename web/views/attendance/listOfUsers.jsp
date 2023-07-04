<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>ATTENDANCE</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
<<<<<<< HEAD
        <c:choose>
            <c:when test="${!Account.roleName.equals('ADMIN')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">ATTENDANCE LIST</h4>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table" id="example">
=======

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">ATTENDANCE LIST</h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <form action="<c:url value="/attendance/updateOfUsers.do"/>">
                                <table class="table" id="example">

                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Date</th>
                                            <th>User ID</th>
                                            <th>Author</th>
                                            <th>Check In</th>
                                            <th>Check Out</th>
                                            <th>Soon Time</th>
                                            <th>Late Time</th>
                                            <th>Duration</th>
                                            <th>Status</th>
                                            <th>Note</th>
                                            <th>Confirmation</th>
                                            <!--                                        <th>Operation</th>-->
                                        </tr>
                                    </thead>
>>>>>>> ChunHai

                                    <tbody>
                                        <c:forEach var="attendance" items="${list}" varStatus="loop">
                                            <tr>
                                                <td>${loop.count}</td>
                                        <input type="hidden" name="attendID" id="attendID"  placeholder="Attend ID" value="${attendance.attendID}">
                                        <input type="hidden" name="status" id="status"  placeholder="status" value="${attendance.status}">

                                        <td>
                                            <input disabled type="date" id="date" placeholder="Date" value="${attendance.date}">
                                            <input type="hidden" name="date" value="${attendance.date}">
                                        </td>

                                        <td>
                                            <input disabled type="number" id="userID" placeholder="User ID" value="${attendance.userID}">
                                            <input type="hidden" name="userID" value="${attendance.userID}">
                                        </td>

                                        <td>
                                            <input disabled type="text" id="fullName" placeholder="Full Name" value="${attendance.fullName}">
                                            <input type="hidden" name="fullName" value="${attendance.fullName}">
                                        </td>

                                        <td>
                                            <input disabled type="text" id="checkIn" placeholder="Check In" value="${attendance.checkIn}">
                                            <input type="hidden" name="checkIn" value="${attendance.checkIn}">
                                        </td>

                                        <td>
                                            <input disabled type="text" id="checkOut" placeholder="Check Out" value="${attendance.checkOut}">
                                            <input type="hidden" name="checkOut" value="${attendance.checkOut}">
                                        </td>

                                        <td>
                                            <input disabled type="text" id="soonTime" placeholder="Soon Time" value="${attendance.soonTime}">
                                            <input type="hidden" name="soonTime" value="${attendance.soonTime}">
                                        </td>

                                        <td>
                                            <input disabled type="text" id="lateTime" placeholder="Late Time" value="${attendance.lateTime}">
                                            <input type="hidden" name="lateTime" value="${attendance.lateTime}">
                                        </td>

                                        <td>
                                            <input disabled type="text" id="duration" placeholder="Duration" value="${attendance.duration}">
                                            <input type="hidden" name="duration" value="${attendance.duration}">
                                        </td>
                                        <td>
                                            <input disabled type="text" id="statusText" placeholder="Status Text" value="${attendance.statusText}">
                                            <input type="hidden" name="statusText" value="${attendance.statusText}">
                                        </td>

                                        <td>
                                            <input name="note" style="width: 100px; height: 100px;" placeholder="Note" id="note" size="100" type="text" value="${attendance.note}"/>
                                        </td>

                                        <td>
                                            <select type="dropdown" id="confirm" name="confirm" value="${attendance.confirm}" >


                                                <c:if test="${attendance.confirm.equals('Accepted')}">
                                                    <option>${attendance.confirm}</option>
                                                    <option>Denied</option>
                                                    <!--                                                <input type="radio" name="confirm" id="confirm1" value="Accepted" checked> 
                                                                                                    <label for="confirm1">Accepted</label> 
                                                    
                                                                                                    <input type="radio" name="confirm" id="confirm2" value="Denied"> 
                                                                                                    <label for="confirm2">Denied</label>-->

                                                </c:if>

                                                <c:if test="${attendance.confirm.equals('Denied')}">
                                                    <option>${attendance.confirm}</option>
                                                    <option>Accepted</option>
                                                    <!--                                                <input type="radio" name="confirm" id="confirm1" value="Accepted"> 
                                                                                                    <label for="confirm1">Accepted</label> 
                                                    
                                                                                                    <input type="radio" name="confirm" id="confirm2" value="Denied" checked> 
                                                                                                    <label for="confirm2">Denied</label>-->
                                                </c:if>
                                            </select>

                                        </td>
                                        <!--<td>
                                        <c:if test ="${item.attendance.statusText.equals('Not Available')}">
                                            <button type="submit" class="btn btn-outline-success" name="op" value="update">Send<i class="bi bi-check-square"></i></button>
                                        </c:if>

                                </td>-->

                                        </tr>



                                    </c:forEach>


                                    </tbody>


                                </table>
                                <button style="float: right" type="submit" class="btn btn-outline-success" name="op" value="update">Send<i class="bi bi-check-square"></i></button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

<<<<<<< HEAD
                <!-- /#page-wrapper -->
                  </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
            </body>
=======
        <!-- /#page-wrapper -->
    </body>
>>>>>>> ChunHai

        </html>