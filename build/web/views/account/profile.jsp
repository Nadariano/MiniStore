<!DOCTYPE html>
<html lang="en">	
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Profile</title>
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
            <!-- /.row -->
            <!-- .row -->
            <div class="row profile">
                <!--<div class="col-md-12 col-xs-12">-->
                <div class="white-box">
                    <div class="profile-content">
                        <!--<div class="col-6">-->
                        <div class="col-6 user-bg"> <img alt="account" src="<c:url value="${Account.avatar}"/>">
                            <div class="overlay-box">
                                <div class="user-content">
                                    <img src="<c:url value="${Account.avatar}"/>"
                                         class="profile-img img-circle" alt="img"></a>
                                    <h2 class="text-white">${Account.fullName}</h2>
                                    <h3 class="text-white">${Account.roleName}</h3>
                                </div>
                            </div>
                            <!--</div>-->
                        </div>

                        <div class="col-6 user-info">
                            <div class="row">
                                <!--<div class="col-md-8 col-xs-12">-->
                                <a class="info-text">
                                    
                                    <label for="address">User Name: </label>
                                    <h3>${Account.userName}</h3>
                                    
                                    <label for="address">Address: </label>
                                    <h3>${Account.address}</h3>
                                    
                                    <label for="address">Phone: </label>
                                    <h3>${Account.phone}</h3>
                                    
                                    <label for="address">Email </label>
                                    <h3>${Account.email}</h3>
                                    <!--</div>-->   
                                </a>
                            </div>
                            <div class="row buttons">
                                <a href="<c:url value="/account/updateProfile.do"/>" class="btn btn-sm btn-primary">Edit Information</a>
                                <a href="<c:url value="/account/changePassword.do"/>" class="btn btn-sm btn-primary">Change Password</a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>




            <!--</div>-->

    </body>

</html>