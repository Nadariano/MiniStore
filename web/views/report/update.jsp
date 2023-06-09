<%-- 
    Document   : update
    Created on : May 31, 2023, 11:38:10 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Report Updater</title>
</head>
<body>
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <!-- Page Content -->

    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <h4 class="page-title">Report Updater</h4>
            </div>

        </div>

        <div class="row">
            <div class="col">
                <form action="<c:url value="/report/update_handler.do"/>">
                    <div class="mb-3 mt-3">
                        <label for="reportID" class="form-label">Report ID:</label>
                        <input disabled type="number" class="form-control" id="reportID" placeholder="Report ID" value="${report.reportID}">
                        <input type="hidden" name="reportID" value="${report.reportID}">
                    </div>
                    <div class="mb-3">
                        <label for="reportTitle" class="form-label">Report Title:</label>
                        <input disabled type="text" class="form-control" id="reportTitle" placeholder="Report Title" value="${report.reportTitle}">
                        <input type="hidden" name="reportTitle" value="${report.reportTitle}">
                    </div>
                    <div class="mb-3">
                        <label for="createDate" class="form-label">Create Date:</label>
                        <input disabled type="date" class="form-control" id="createDate" placeholder="Create Date" value="${report.createDate}">
                        <input type="hidden" name="createDate" value="${report.createDate}">            
                    </div>
                    <div class="mb-3">
                        <label for="userID" class="form-label">User ID:</label>
                        <input disabled type="number" class="form-control" id="userID" placeholder="User ID" value="${report.userID}">
                        <input type="hidden" name="userID" value="${report.userID}">            
                    </div>
                    <div class="mb-3">
                        <label for="fullName" class="form-label">Full Name:</label>
                        <input disabled type="text" class="form-control" id="fullName" placeholder="Full Name" value="${report.fullName}">
                        <input type="hidden" name="fullName" value="${report.fullName}">
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Description:</label>
                        <input  disabled type="text" class="form-control" id="description" placeholder="Description"  value="${report.description}">
                        <input type="hidden" name="description" value="${report.description}">
                        
                    </div>
                    <div class="mb-3">
                        <label for="statusText" class="form-label">Status:</label>
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
                    </div>
                    <div class="mb-3">
                        <label for="note" class="form-label">Note:</label>
                        <textarea  maxlength="300" style="resize: vertical;width: 500px" placeholder="Note(Maximum: 300 characters)"  id="note" name="note">${report.note}</textarea>
                    </div>
                    <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                </form>
            </div>
            <div class="col">
                <img src="<c:url value="/images/hit.gif"/>" alt="">
            </div>
        </div>
    </div>
</body>
