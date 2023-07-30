<%-- 
    Document   : update
    Created on : Jun 9, 2023, 4:36:05 PM
    Author     : Dell
--%>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Shift Time Update</title>
    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Update Shift Time</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">



                                <form action="<c:url value="/shiftTime/update_handler.do"/>" class="form-horizontal form-material">

                                    <div class="form-group">
                                        <label class="col-md-12">Shift ID</label>
                                        <div class="col-md-12">
                                            <input disabled type="number" placeholder="Shift ID" value="${shiftTime.shiftID}}"
                                                   class="form-control form-control-line" />
                                            <input type="hidden" name="shiftID" value="${shiftTime.shiftID}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Shift Name</label>
                                        <div class="col-md-12">
<!--                                            <input type="text" placeholder="Shift Name" name="shiftName" value="${shiftTime.shiftName}"
                                                   class="form-control form-control-line" />-->
                                            <select name="shiftName" class="form-control form-control-line" value="${shiftTime.shiftName}" >
                                                <option value="Day Shift">Day Shift</option>
                                                <option value="Night Shift">Night Shift</option> 
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Time Start</label>
                                        <div class="col-md-12">
                                            <input type="time" placeholder="Time Start" name="timeStart" value="${shiftTime.timeStart}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Time End</label>
                                        <div class="col-md-12">
                                            <input type="time" placeholder="Time End" name="timeEnd" value="${shiftTime.timeEnd}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Coefficient of Shift</label>
                                        <div class="col-md-12">
                                            <input type="number"  step="0.1" placeholder="COS" name="coeShift" value="${shiftTime.coeShift}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Coefficient of Over Time</label>
                                        <div class="col-md-12">
                                            <input type="number"  step="0.1" placeholder="COOT" name="coeOT" value="${shiftTime.coeOT}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Coefficient of Day Off</label>
                                        <div class="col-md-12">
                                            <input type="number"  step="0.1" placeholder="CODO" name="coeDayOff" value="${shiftTime.coeDayOff}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12"> Wage </label>
                                        <div class="col-md-12">
                                            <input type="number" placeholder="Wage" name="wage" value="${shiftTime.wage}"
                                                   class="form-control form-control-line" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">Status</label>
                                        <div class="col-md-12">
                                            <select name="status" class="form-control form-control-line">
                                                <option value="0" ${shiftTime.status == 0 ? 'selected' : ''}>Available</option>
                                                <option value="2" ${shiftTime.status == 2 ? 'selected' : ''}>Not Available</option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-12">Note</label>

                                        <div class="col-md-12">
                                            <textarea type="text" maxlength="300" class="form-control form-control-line" placeholder="Note(Maximum: 300 characters)"  id="note"  name="note"  style=" max-height: 226px; min-width: 100%; min-height: 50px;"value="${shiftTime.note}">${shiftTime.note}</textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-12">

                                            <button type="submit" class="btn btn-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
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
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>