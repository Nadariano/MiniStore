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
        <title>Password Changer</title>
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
                    <h4 class="page-title">Change password</h4>
                </div>
            </div>
            <div class="row white-box">
                <div class="col form-group">
                    <form action="<c:url value="/account/changePassword_handler.do"/>">
                        <div class="mb-3">
                            <label for="userName" class="form-label">Enter your current password:</label>
                            <input type="password" class="form-control" name="oldPass" id="oldPass" placeholder="Current Password">
                        </div>
                        <div class="mb-3">
                            <label for="fullName" class="form-label">Enter new password:</label>
                            <input type="password" class="form-control" name="newPass1" id="newPass1" placeholder="New Password">
                        </div>
                        <div class="mb-3">
                            <label for="fullName" class="form-label">Re-enter new password:</label>
                            <input type="password" class="form-control" name="newPass2" id="newPass2" placeholder="Re-enter New Password">
                        </div>
                        <p>
                            <input type="checkbox" onClick="revealPass()"/>Reveal All
                        </p>
                        <button type="submit" class="btn btn-success" name="op" value="change">Confirm change <i class="bi bi-check-square"></i></button>
                        <button type="submit" class="btn btn-warning" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                    </form>
                    <h3 style="color: yellowgreen">${successMsg}</h3>
                    <h3 style="color: red">${failMsg}</h3>
                </div>
            </div>
        </div>
        <!--<script src="<c:url value="/js/revealPass.js"/>"></script>-->
    </body>