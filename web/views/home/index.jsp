<%-- 
    Document   : index.jsp
    Created on : May 28, 2023, 12:00:16 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h1 class="welcome-title" >Hi ${Account.fullName}!</h1>
                    <h4 class="welcome-title">Welcome to the MiniStore Management System</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="card card-stats">
                        <div class="card-header card-header-success card-header-icon">
                            <div class="card-icon">
                                <i class="bi bi-cart"></i>
                            </div>
                            <p class="card-category">Orders</p>
                            <h3 class="card-title">50</h3>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="bi bi-clock"></i> Updated 4 minutes ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="card card-stats">
                        <div class="card-header card-header-warning card-header-icon">
                            <div class="card-icon">
                                <i class="bi bi-person"></i>
                            </div>
                            <p class="card-category">Customers</p>
                            <h3 class="card-title">200</h3>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="bi bi-clock"></i> Updated 10 minutes ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="card card-stats">
                        <div class="card-header card-header-info card-header-icon">
                            <div class="card-icon">
                                <i class="bi bi-box"></i>
                            </div>
                            <p class="card-category">Products</p>
                            <h3 class="card-title">100</h3>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="bi bi-clock"></i> Updated 15 minutes ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <div class="card card-stats">
                        <div class="card-header card-header-danger card-header-icon">
                            <div class="card-icon">
                                <i class="bi bi-cash"></i>
                            </div>
                            <p class="card-category">Revenue</p>
                            <h3 class="card-title">$5000</h3>
                        </div>
                        <div class="card-footer">
                            <div class="stats">
                                <i class="bi bi-clock"></i> Updated 20 minutes ago
                            </div>
                        </div>
                    </div>
                </div>        
            </div>

            Add more rows and columns as needed 

        </div>


    </body>
</html>
