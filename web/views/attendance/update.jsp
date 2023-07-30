<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>ATTENDANCE UPDATE</title>
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
                    <h4 class="page-title">ATTENDANCE UPDATE</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/attendance/update_handler.do"/>" class="form-horizontal form-material">

                            <div class="form-group  ">
                                <div class="col-md-12">
                                    <input type="hidden" id="attendID" placeholder="Attend ID"  name="attendID" value="${attendance.attendID}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Date:</label>
                                <div class="col-md-12">
                                    <input disabled type="date" id="date" placeholder="Date" value="${attendance.date}" class="form-control form-control-line" />
                                    <input type="hidden" name="date" value="${attendance.date}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">User ID:</label>
                                <div class="col-md-12">
                                    <input disabled type="number" id="userID" placeholder="User ID" name="userID" value="${attendance.userID}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="userID" value="${attendance.userID}">

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Full Name: </label>
                                <div class="col-md-12">
                                    <input disabled type="text" id="fullName" placeholder="Full Name" value="${attendance.fullName}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="fullName" value="${attendance.fullName}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Shift: </label>
                                <select type="dropdown" id="shiftID" name="shiftID" value="${attendance.shiftID}" class="form-control form-control-line">

                                    <c:if test="${attendance.shiftID == 1}">
                                        <option > ${attendance.shiftID} </option>
                                        <option > 2 </option>
                                        <option > 3 </option>
                                    </c:if>

                                    <c:if test="${attendance.shiftID == 2}">
                                        <option > ${attendance.shiftID} </option>
                                        <option > 1 </option>
                                        <option > 3 </option>
                                    </c:if>

                                    <c:if test="${attendance.shiftID == 3}">
                                        <option > ${attendance.shiftID} </option>
                                        <option > 1 </option>
                                        <option > 2 </option>
                                    </c:if>
                                </select>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Check In:</label>
                                <div class="col-md-12">
                                    <input type="time" id="checkIn" placeholder="Check In"name="checkIn" value="${attendance.checkIn}"
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
                                <label class="col-md-12">Soon Time: </label>
                                <div class="col-md-12">
                                    <input type="text" id="soonTime" placeholder="Fill ?hour:?min:?sec (Example:00:30:00)" name="soonTime" value="${attendance.soonTime}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Late Time: </label>
                                <div class="col-md-12">
                                    <input type="text" id="lateTime" placeholder="Fill ?hour:?min:?sec (Example:00:40:00)" name="lateTime" value="${attendance.lateTime}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Duration: </label>
                                <div class="col-md-12">
                                    <input type="time" id="duration" placeholder="Duration" name="duration" value="${attendance.duration}"
                                           class="form-control form-control-line" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Status: </label>
                                <div class="col-md-12">
                                    <select class="form-control" type="dropdown" id="statusText" name="statusText" value="${attendance.statusText}" >
                                        <c:if test="${attendance.statusText.equals('Available')}">
                                            <option>${attendance.statusText}</option>
                                            <option> Not Available </option>
                                        </c:if>
                                        <c:if test="${attendance.statusText.equals('Not Available')}">
                                            <option>${attendance.statusText}</option>
                                            <option> Available </option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Note:</label>

                                <div class="col-md-12">
                                    <textarea type="text" maxlength="300" class="form-control form-control-line" placeholder="Note(Maximum: 300 characters)"  id="note"  name="note"  style=" max-height: 226px; min-width: 100%; min-height: 50px;"value="${attendance.note}">${attendance.note}</textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Confirmation:</label>
                                <div class="col-md-12 form-control-line">
                                    <input disabled type="radio" name="confirm" id="confirm-accepted" value="Accepted" ${attendance.confirm.equals('Accepted') ? 'checked' : ''}> 
                                    <label for="confirm-accepted">Accepted</label> 

                                    <input disabled type="radio" name="confirm" id="confirm-denied" value="Denied" ${attendance.confirm.equals('Denied') ? 'checked' : ''}> 
                                    <label for="confirm-denied">Denied</label>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-12">
                                    <!--                                    <button type="submit" class="btn btn-success">Add Role</button>-->
                                    <button type="submit" class="btn btn-success" name="op" value="update">Update<i class="bi bi-check-square"></i></button>
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