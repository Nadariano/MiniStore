<!DOCTYPE html>
<html lang="en">	
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>User-list</title>
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
                            <h4 class="page-title">Thêm mới dự án</h4>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-md-2 col-12"></div>
                        <div class="col-md-8 col-xs-12">
                            <div class="white-box">
                                <form class="form-horizontal form-material">
                                    <div class="form-group">
                                        <label class="col-md-12">Tên dự án</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="Tên công việc"
                                                   class="form-control form-control-line"> </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Ngày bắt đầu</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="dd/MM/yyyy"
                                                   class="form-control form-control-line"> </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Ngày kết thúc</label>
                                        <div class="col-md-12">
                                            <input type="text" placeholder="dd/MM/yyyy"
                                                   class="form-control form-control-line"> </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success">Lưu lại</button>
                                            <a href="<c:url value="/groupwork/groupwork.do"/>" class="btn btn-primary">Quay lại</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-2 col-12"></div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
             
            <!-- /#page-wrapper -->
       
    </body>

</html>