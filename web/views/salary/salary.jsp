<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary List</title>
    </head>
    <!-- Page Content -->
            <div class="container-fluid">
                
            
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Salary Dashboard</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/salary/salary-add.do"/>" class="btn btn-sm btn-success">Thêm mới</a>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
<!--                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table" id="example">
                                        <thead>
                                            <tr>
                                                <th>STT</th>
                                                <th>Tên Công Việc</th>
                                                <th>Dự Án</th>
                                                <th>Người Thực Hiện</th>
                                                <th>Ngày Bắt Đầu</th>
                                                <th>Ngày Kết Thúc</th>
                                                <th>Trạng Thái</th>
                                                <th>Hành Động</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Phân tích dự án</td>
                                                <td>Dự án CRM</td>
                                                <td>Nguyễn Văn Tèo</td>
                                                <td>22/05/2019</td>
                                                <td>30/05/2019</td>
                                                <td>Đã hoàn thành</td>
                                                <td>
                                                    <a href="<c:url value="/#"/>" class="btn btn-sm btn-primary">Sửa</a>
                                                    <a href="<c:url value="/#"/>" class="btn btn-sm btn-danger">Xóa</a>
                                                    <a href="<c:url value="/#"/>" class="btn btn-sm btn-info">Xem</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>1</td>
                                                <td>Thiết kế database</td>
                                                <td>Dự án CRM</td>
                                                <td>Trần Thị Lan</td>
                                                <td>22/05/2019</td>
                                                <td>30/05/2019</td>
                                                <td>Đang thực hiện</td>
                                                <td>
                                                    <a href="<c:url value="/#"/>" class="btn btn-sm btn-primary">Sửa</a>
                                                    <a href="<c:url value="/#"/>" class="btn btn-sm btn-danger">Xóa</a>
                                                    <a href="<c:url value="/#"/>" class="btn btn-sm btn-info">Xem</a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>-->
                    </div>
                                                
                    <!-- /.row -->
                <!-- /.container-fluid -->

</html>