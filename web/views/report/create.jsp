<%-- 
    Document   : create
    Created on : May 31, 2023, 6:52:01 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Report Creator</title>
</head>
<body>
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <!-- Page Content -->

    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <h4 class="page-title">Report Creator</h4>
            </div>

        </div>
        <div class="row">
            <div class="col">
                <form action="<c:url value="/report/create_handler.do"/>">
                    <div class="mb-3">
                        <label for="reportTitle" class="form-label">Report Title:</label>
                        <input type="text" class="form-control" id="reportTitle" placeholder="Report Title" name="reportTitle" value="${report.reportTitle}">
                    </div>
                    <div class="mb-3">
                        <label for="userID" class="form-label">User ID:</label>
                        <input disabled type="number" class="form-control" id="userID" placeholder="User ID" value="${Account.userID}">
                        <input type="hidden" name="userID" value="${Account.userID}">            
                    </div>
                    <div class="mb-3">
                        <label for="fullName" class="form-label">Full Name:</label>
                        <input disabled type="text" class="form-control" id="fullName" placeholder="Full Name" value="${Account.fullName}">
                        <input type="hidden" name="fullName" value="${Account.fullName}">
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Description(Content):</label>
                        <textarea style="resize: both" placeholder="Write here"  id="description" name="description" value="${report.description}"></textarea>
                    </div>
                    <button type="submit" class="btn btn-outline-success" name="op" value="create">Create <i class="bi bi-check-square"></i></button>
                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                </form>
            </div>
        </div>
    </div>
