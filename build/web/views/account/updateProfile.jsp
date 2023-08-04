<%-- 
    Document   : updateProfile
    Created on : May 31, 2023, 8:25:45 AM
    Author     : Dell
--%>

<!DOCTYPE html>
<html lang="en">	
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Profile Updater</title>
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
                    <h4 class="page-title">Update Profile</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8 white-box">
                    <form action="<c:url value="/account/updateProfile_handler.do"/>">
                        <!--                        <div class="mb-3">
                                                    <label for="userName" class="form-label">UserName:</label>
                                                    <input  disabled readonly type="text" class="form-control" id="userName" value="${Account.getUserName()}">
                                                    <input type="hidden" name="userName" value="${Account.getUserName()}">
                                                </div>-->
                        <div class="mb-3">
                            <label for="userName" class="form-label">userName:</label>
                            <input type="text" class="form-control" name="userName" placeholder="User Name" value="${Account.userName}">
                        </div>
                        <div class="mb-3">
                            <label for="fullName" class="form-label">Full Name:</label>
                            <input type="text" class="form-control" name="fullName" placeholder="Full Name" value="${Account.fullName}">
                        </div>
                        <div class="mb-3">
                            <label for="avatar" class="form-label">Avatar Link:</label>
                            <input type="text" class="form-control" name="avatar" placeholder="Avatar link" value="${Account.avatar}">
                        </div>
                        <div class="mb-3">
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone Number:</label>
                                <input type="text" class="form-control" name="phone" placeholder="Phone" value="${Account.phone}">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email:</label>
                                <input type="email" class="form-control" name="email" placeholder="Email" value="${Account.email}">
                            </div>
                            <label for="address" class="form-label">Address:</label>
                            <input type="text" class="form-control" name="address" placeholder="Address"  value="${Account.address}">
                        </div>
                        <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi bi-check-square"></i></button>
                        <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                    </form>
                    <i style="color: red">${error}</i>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </body>