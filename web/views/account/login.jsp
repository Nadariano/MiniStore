<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <title>Mini Store Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<!--        <link href="<c:url value="/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">-->


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <!-- color CSS -->


        <link href="<c:url value="/css/custom.css"/>" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>">
    </head>
    <body class="justify-content-center" style="background-image: url(<c:url value='/plugins/images/MiniStore_bg.png'/>); background-size: 100%; background-repeat: no-repeat;">
        <div class="container login-container">
            <div class="row justify-content-center mt-5">
                <div class="col-md-6">
                    <div class="card shadow-lg p-4 border">
                        <div class="card-body">
                            <h3 class="text-center">MINISTORE MANAGEMENT SYSTEM</h3>
                            <form action="<c:url value="/account/login_handler.do" />" method="post">
                                <div class="form-group">
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                                        <input required type="text" class="form-control form-control-lg " id="userName" name="userName" placeholder="Enter your username">

                                    </div></div>

                                <div class="form-group">
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                                        <input required type="password" id="password" class="form-control form-control-lg" id="password" name="password" placeholder="Enter your password"/>
                                        <div style="display:flex; justify-content: center; align-items: center">
                                        <i class="bi bi-eye-slash" id="togglePassword"></i>
                                        </div>
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

        <script src="<c:url value="/js/revealPass.js"/>"></script>


        <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
        <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"/>"></script>
        <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    </body>




</html>
