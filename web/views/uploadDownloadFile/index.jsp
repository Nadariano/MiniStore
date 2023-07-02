<%-- 
    Document   : index
    Created on : Jun 26, 2023, 9:22:12 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <i>${message}</i>
    <body>
        <form method="post" enctype="multipart/form-data">
            Select File to Upload:<input type="file" name="fileName">
            <br>
            <input type="submit" value="Upload">
            <i style="color: orange">${message}</i>
        </form>
    </body>
</html>
