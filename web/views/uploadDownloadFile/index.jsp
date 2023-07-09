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
        <!--        <form method="post" enctype="multipart/form-data">
                    Select File to Upload:<input type="file" name="fileName">
                    <br>
                    <input type="submit" value="Upload">
                    <i style="color: orange">${message}</i>
                </form>-->
        <form class="form-inline" method="post" enctype="multipart/form-data">
            <div class="form-group mb-2">
                <div class="custom-file">
                    <div class="input-group">
                        <label class="input-group-btn">
                            <span class="btn btn-info">
                                Select File to Upload: <input type="file" style="display: none;" id="fileName" multiple name="fileName" onchange="updateFileName()">
                            </span>
                        </label>
                        <input type="text" class="form-control" id="inputBox" readonly name="fileName">
                    </div>
                </div>
                <button  class="btn btn-info btn-block mb-2 ml-2" value="Upload">
                    <i class="bi bi-file-earmark-spreadsheet"></i> Upload
                </button>
            </div>
            <br>
            <i style="color: red">${message}</i>
        </form>

    </body>
</html>
