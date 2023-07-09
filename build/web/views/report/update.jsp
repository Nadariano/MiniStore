<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>REPORT UPDATE</title>
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
                    <h4 class="page-title">REPORT UPDATE</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">



                        <form action="<c:url value="/report/update_handler.do"/>" class="form-horizontal form-material">

                            <div class="form-group">
                                <label class="col-md-12">Report ID:</label>
                                <div class="col-md-12">
                                    <input disabled type="number" id="reportID" placeholder="Report ID" value="${report.reportID}" class="form-control form-control-line" />
                                    <input type="hidden" name="reportID" value="${report.reportID}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Report Title:</label>
                                <div class="col-md-12">
                                    <input disabled type="text" id="reportTitle" placeholder="Report Title" value="${report.reportTitle}" class="form-control form-control-line" />
                                    <input type="hidden" name="reportTitle" value="${report.reportTitle}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Type:</label>
                                <div class="col-md-12">
                                    <input disabled type="text" id="Type" placeholder="Report Title" value="${report.typeName}" class="form-control form-control-line" />
                                    <input type="hidden" name="typeName" value="${report.typeName}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Create Date:</label>
                                <div class="col-md-12">
                                    <input disabled type="date" id="createDate" placeholder="Create Date" value="${report.createDate}" class="form-control form-control-line" />
                                    <input type="hidden" name="createDate" value="${report.createDate}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">User ID:</label>
                                <div class="col-md-12">
                                    <input disabled type="number" id="userID" placeholder="User ID" name="userID" value="${report.userID}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="userID" value="${report.userID}">

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Full Name: </label>
                                <div class="col-md-12">
                                    <input disabled type="text" id="fullName" placeholder="Full Name" value="${report.fullName}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="fullName" value="${report.fullName}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Description (Content): </label>
                                <div class="col-md-12">
                                    <input disabled type="text" id="description" placeholder="Description" value="${report.description}"
                                           class="form-control form-control-line" />
                                    <input type="hidden" name="description" value="${report.description}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Planned Date:</label>
                                <div class="col-md-12">
                                    <input disabled type="date" id="plannedDate" placeholder="Planned Date" value="${report.plannedDate}" class="form-control form-control-line" />
                                    <input type="hidden" name="plannedDate" value="${report.plannedDate}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Request Soon Time:</label>
                                <div class="col-md-12">
                                    <input disabled type="time" id="requestSoonTime" placeholder="Request Soon Time" value="${report.requestSoonTime}" class="form-control form-control-line" />
                                    <input type="hidden" name="requestSoonTime" value="${report.requestSoonTime}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Request Late Time:</label>
                                <div class="col-md-12">
                                    <input disabled type="time" id="requestLateTime" placeholder="Request Late Time" value="${report.requestLateTime}" class="form-control form-control-line" />
                                    <input type="hidden" name="requestLateTime" value="${report.requestLateTime}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Status:</label>
                                <select type="dropdown" id="statusText" name="statusText" value="${report.statusText}" >
                                    <c:if test="${report.statusText.equals('Processing')}">
                                        <option>${report.statusText}</option>
                                        <option> Approved </option>
                                        <option> Rejected </option>
                                    </c:if>
                                    <c:if test="${report.statusText.equals('Approved')}">
                                        <option>${report.statusText}</option>
                                        <option> Processing </option>
                                        <option> Rejected </option>
                                    </c:if>
                                    <c:if test="${report.statusText.equals('Rejected')}">
                                        <option>${report.statusText}</option>
                                        <option> Approved </option>
                                        <option> Processing </option>
                                    </c:if>    
                                </select>
    <!--                                <select id="status" name="status" value="${report.status}" >
                                        <option value="0">Approved</option>
                                        <option value="1">Processing</option>
                                        <option value="2">Rejected</option>
                                    </select>-->
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Note:</label>
                                <div class="col-md-12">
                                    <textarea  maxlength="300" style="resize: vertical;width: 500px" placeholder="Note(Maximum: 300 characters)"  id="note" name="note">${report.note}</textarea>
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