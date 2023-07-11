<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--    <head>
            <title>Mini Store Login</title>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
            <link href="<c:url value="/css/custom.css"/>" rel="stylesheet">
            <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>">
        </head>
        <body style="background-image: url(https://img.freepik.com/premium-vector/blue-shop-background_748315-11.jpg?w=2000); background-size: 100%; background-repeat: no-repeat">
           
    <body id= "login-background">
            <div class="login-container">
                <div class="row mt-5">
                    <div class="col-md-4 m-auto mt-4 login-box">
                        <h3 class="text-center login-header">LOGIN TO MINISTORE MANAGEMENT SYSTEM</h3>
                        <div class="p-4 border mt-4 ">
                            <form action="<c:url value="/account/login_handler.do" />" method="post">
                                <div class="form-group">
                                    <label>Enter userName</label>
                                    <input type="text" class="form-control" name="userName">
                                </div>
                                <div class="form-group">
                                    <label>Enter Password</label>
                                    <input type="password" class="form-control" name="password">
                                </div>
                                <h5 style="color:red">${message}</h5>
                                <button type="submit" class="btn btn-primary" name="op" value="login">Login</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
        <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"/>"></script>
    <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
        </body>-->


    <head>
        <title>Mini Store Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<!--        <link href="<c:url value="/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">-->


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <!-- color CSS -->


        <link href="<c:url value="/css/custom.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>">
    </head>
    <!--<body style="background-image: url(https://img.freepik.com/premium-vector/blue-shop-background_748315-11.jpg?w=2000); background-size: auto; background-repeat: no-repeat">-->
    <body> 
        <div class="container ">
            <div class="row justify-content-center mt-5">
                <div class="col-md-6">
                    <div class="card shadow-lg p-4 border mt-4">
                        <div class="card-body">
                            <h3 class="text-center">MINISTORE MANAGEMENT SYSTEM</h3>
                            <form action="<c:url value="/account/login_handler.do" />" method="post">
                                <div class="form-group">
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                                        <input type="text" class="form-control form-control-lg " id="userName" name="userName" placeholder="Enter your username">

                                    </div></div>

                                <div class="form-group">
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                                        <input type="password" class="form-control form-control-lg" id="password" name="password" placeholder="Enter your password">
                                    </div>
                                </div>
                                <h5 style="color:red">${message}</h5>
                                <button type="submit" class="btn btn-primary btn-block  btn-lg" name="op" value="login">Login</button>
                            </form>


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/plugins/bower_components/jquery/dist/jquery.min.js"/>"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/bootstrap/dist/js/bootstrap.min.js"/>"></script>
        <!-- Menu Plugin JavaScript -->
        <script src="<c:url value="/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"/>"></script>
        <!--slimscroll JavaScript -->
        <script src="<c:url value="/js/jquery.slimscroll.js"/>"></script>
        <!--Wave Effects -->
        <script src="<c:url value="/js/waves.js"/>"></script>
        <!--Counter js -->
        <script src="<c:url value="/plugins/bower_components/waypoints/lib/jquery.waypoints.js"/>"></script>
        <script src="<c:url value="/plugins/bower_components/counterup/jquery.counterup.min.js"/>"></script>
        <!--Morris JavaScript -->
        <script src="<c:url value="/plugins/bower_components/raphael/raphael-min.js"/>"></script>
        <script src="<c:url value="/plugins/bower_components/morrisjs/morris.js"/>"></script>
        <!-- Custom Theme JavaScript -->
        <script src="<c:url value="/js/custom.min.js"/>"></script>
        <script src="<c:url value="/js/dashboard1.js"/>"></script>
        <script src="<c:url value="/plugins/bower_components/toast-master/js/jquery.toast.js"/>"></script>




        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
        <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"/>"></script>
        <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    </body>




</html>
