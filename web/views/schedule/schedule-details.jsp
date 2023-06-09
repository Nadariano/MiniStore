<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Groupwork details</title>
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
                            <h4 class="page-title">Chi tiết công việc </h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                            <ol class="breadcrumb">
                                <li><a href="<c:url value="/#"/>">Dashboard</a></li>
                                <li class="active">Blank Page</li>
                            </ol>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- BEGIN THỐNG KÊ -->
                    <div class="row">
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
                                                                                class="linea-icon linea-basic"></i>
                                        <h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-6">
                                        <h3 class="counter text-right m-t-15 text-danger">20%</h3>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                                                                data-icon="&#xe01b;"></i>
                                        <h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-6">
                                        <h3 class="counter text-right m-t-15 text-megna">50%</h3>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-megna" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                                                                data-icon="&#xe00b;"></i>
                                        <h5 class="text-muted vb">HOÀN THÀNH</h5>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-6">
                                        <h3 class="counter text-right m-t-15 text-primary">30%</h3>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-primary" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- END THỐNG KÊ -->

                    <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="<c:url value="/#"/>" class="group-title">
                                <img width="30" src="<c:url value="/plugins/images/users/pawandeep.jpg"/>" class="img-circle" />
                                <span>Pavan kumar</span>
                            </a>
                        </div>
                        <div class="col-md-4">
                            <div class="white-box">
                                <h3 class="box-title">Chưa thực hiện</h3>
                                <div class="message-center">
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                                class="time">9:30 AM</span>
                                        </div>
                                    </a>
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                            <span class="time">9:10 AM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="white-box">
                                <h3 class="box-title">Đang thực hiện</h3>
                                <div class="message-center">
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                                class="time">9:30 AM</span>
                                        </div>
                                    </a>
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                            <span class="time">9:10 AM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="white-box">
                                <h3 class="box-title">Đã hoàn thành</h3>
                                <div class="message-center">
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                                class="time">9:30 AM</span>
                                        </div>
                                    </a>
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                            <span class="time">9:10 AM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="<c:url value="/#"/>" class="group-title">
                                <img width="30" src="<c:url value="/plugins/images/users/pawandeep.jpg"/>" class="img-circle" />
                                <span>Pavan kumar</span>
                            </a>
                        </div>
                        <div class="col-md-4">
                            <div class="white-box">
                                <h3 class="box-title">Chưa thực hiện</h3>
                                <div class="message-center">
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                                class="time">9:30 AM</span>
                                        </div>
                                    </a>
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                            <span class="time">9:10 AM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="white-box">
                                <h3 class="box-title">Đang thực hiện</h3>
                                <div class="message-center">
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                                class="time">9:30 AM</span>
                                        </div>
                                    </a>
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                            <span class="time">9:10 AM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="white-box">
                                <h3 class="box-title">Đã hoàn thành</h3>
                                <div class="message-center">
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span
                                                class="time">9:30 AM</span>
                                        </div>
                                    </a>
                                    <a href="<c:url value="/#"/>">
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span>
                                            <span class="time">9:10 AM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END DANH SÁCH CÔNG VIỆC -->
                </div>
                <!-- /.container-fluid -->
    </body>

</html>