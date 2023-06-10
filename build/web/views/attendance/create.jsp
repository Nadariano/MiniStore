<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>ATTENDANCE CREATION</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">ATTENDANCE CREATION</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/attendance/create_handler.do"/>" class="form-horizontal form-material">

                            <div class="form-group">
                                <label class="col-md-12">Date:</label>
                                <div class="col-md-12">
                                    <input type="date" id="date" placeholder="Date" name="date" value="${attendance.date}" class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">User ID:</label>
                                <div class="col-md-12">
                                    <input type="number" id="userID" placeholder="User ID" name="userID" name="userID"  value="${attendance.userID}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Check In:</label>
                                <div class="col-md-12">
                                    <input type="time" id="checkIn" placeholder="Check In" name="checkIn" value="${attendance.checkIn}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Check Out:</label>
                                <div class="col-md-12">
                                    <input type="time" id="checkOut" placeholder="Check Out" name="checkOut" value="${attendance.checkOut}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Late Time: </label>
                                <div class="col-md-12">
                                    <input type="number" id="lateTime" placeholder="Late Time" name="lateTime" value="${attendance.lateTime}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Over Time: </label>
                                <div class="col-md-12">
                                    <input type="number"id="lateTime" placeholder="Over Time" name="overTime" value="${attendance.overTime}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-12">
                                    <!--                                    <button type="submit" class="btn btn-success">Add Role</button>-->
                                    <button type="submit" class="btn btn-success" name="op" value="create">Create<i class="bi bi-check-square"></i></button>
                                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel<i class="bi bi-x-square"></i></button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
                <div class="col-md-2 col-12"></div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

        <!-- /#page-wrapper -->

    </body>

</html>