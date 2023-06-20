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
                    <h3 class="welcome-title">Hi ${Account.fullName}!</h3>
                    <h4 class="welcome-title">Welcome to the MiniStore Management System</h4>
                </div>
            </div>
        </div>
    </body>
</html>
