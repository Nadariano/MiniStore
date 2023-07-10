<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>REPORT CREATION</title>
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
                    <h4 class="page-title">REPORT CREATION</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/report/create_handler.do"/>" class="form-horizontal form-material">

                            <div class="form-group">
                                <label class="col-md-12">Report Title:</label>
                                <div class="col-md-12">
                                    <input type="text" id="reportTitle" placeholder="Report Title" name="reportTitle" value="${report.reportTitle}" class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Type:</label>
                                <div class="col-md-12">
                                    <select name="typeID" class="form-control">
                                        <option value="1">Application</option>
                                        <option value="2">Report</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">User ID:</label>
                                <div class="col-md-12">
                                    <input disabled type="number" id="userID" placeholder="User ID" value="${Account.userID}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="userID" value="${Account.userID}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Full Name:</label>
                                <div class="col-md-12">
                                    <input disabled type="text" id="fullName" placeholder="Full Name" value="${Account.fullName}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="fullName" value="${Account.fullName}">
                                </div>
                            </div> 

                            <div class="form-group">
                                <label class="col-md-12">Description(Content):</label>
                                <div class="col-md-12">
                                    <textarea class="form-control " style="resize: both" placeholder="Write here"  id="description" name="description" value="${report.description}"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Planned Date:</label>
                                <div class="col-md-12">
                                    <input type="date" placeholder="Select Date" name="plannedDate"   value="<fmt:formatDate value="${report.plannedDate}" pattern="yyyy-MM-dd"/>"
                                           class="form-control form-control-line" />
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-12">Request Soon Time:</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Fill ?hour:?min (Example: 00:45)" name="requestSoonTime" value="${report.requestSoonTime}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-12">Request Late Time:</label>
                                <div class="col-md-12">
                                    <input type="text" placeholder="Fill ?hour:?min (Example: 00:30)" name="requestLateTime" value="${report.requestLateTime}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Shift: </label>
                                <select type="dropdown" id="shiftID" name="shiftID" value="${report.shiftID}" class="form-control form-control-line">

                                    <option value="1"> 1 </option>
                                    <option value="2"> 2 </option>
                                    <option value="3"> 3 </option>

                                </select>
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