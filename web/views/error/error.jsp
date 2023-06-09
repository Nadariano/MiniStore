<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Error</title>
    </head>

        <body>
            <div class="preloader">
                <div class="cssload-speeding-wheel"></div>
            </div>
            <section id="wrapper" class="error-page">
                <div class="error-box">
                    <div class="error-body text-center">
                        <h1>403</h1>
                        <h3 class="text-uppercase">You don't have permission to access this page !</h3>
                        <p class="text-muted m-t-30 m-b-30">Please head back</p>
                        <a href='<c:url value="/home/index.do" />' class="btn btn-info btn-rounded waves-effect waves-light m-b-40">HERE</a> </div>
                <footer class="footer text-center">2018 © Pixel Admin.</footer>
            </div>
        </section>

    </body>

</html>