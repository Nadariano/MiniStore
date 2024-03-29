<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Profile</title>
        <link href="profile.css" rel="stylesheet">
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
                    <h4 class="page-title">My Profile</h4>
                </div>
            </div>

            <div class="white-box">
                <div class="row">
                    <div class="col-md-6">
                        <div class="avatar-section">
                            <img src="<c:url value="${Account.avatar}"/>" alt="avatar" class="profile-img img-fluid img-thumbnail">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="info-section ">
                            <h2 class="helvetica">${Account.fullName}</h2>
                            <h3 class="helvetica">${Account.roleName}</h3>
                            <hr>
                            <label for="address">User Name:</label>
                            <h3 class="helvetica">${Account.userName}</h3>

                            <label for="address">Address:</label>
                            <h3 class="helvetica">${Account.address}</h3>

                            <label for="address">Phone:</label>
                            <h3 class="helvetica">${Account.phone}</h3>

                            <label for="address">Email:</label>
                            <h3 class="helvetica">${Account.email}</h3>
                            <hr>
                            <div class="helvetica">
                                <a href="<c:url value="/account/updateProfile.do"/>" class="btn btn-sm btn-success">Edit Information</a>
                                <a href="<c:url value="/account/changePassword.do"/>" class="btn btn-sm btn-linkedin">Change Password</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
