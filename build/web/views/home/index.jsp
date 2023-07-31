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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>

    </head>
    <body class="cursive">
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
                <div class="col-sm-12 white-box  border-rounded">
                    <!--DASHBOARD FOR ADMIN-->
                    <c:if test="${Account.roleName.equals('ADMIN')}">
                        <h4>Accounts: (Total: ${allUser})</h4>
                        <div class="row">
                            <div class="progress progress-animated col-md-6" style="height: 30px">
                                <div class="progress-bar progress-bar-striped active p-10" role="progressbar" style="width: ${(activeUser / allUser) *100}%; font-size: 250%" aria-valuenow="${activeUser}" aria-valuemin="0" aria-valuemax="${allUser}">${activeUser}</div>
                                <div class="progress-bar progress-bar-striped bg-primary active p-10" role="progressbar" style="width: ${(inactiveUser / allUser) *100}%; font-size: 250%" aria-valuenow="${inactiveUser}" aria-valuemin="0" aria-valuemax="${allUser}">${inactiveUser}</div>
                                <!--<div class="progress-bar progress-bar-striped bg-danger " role="progressbar" style="width: ${(bannedUser/ allUser) *100}%" aria-valuenow="${bannedUser}" aria-valuemin="0" aria-valuemax="${allUser}">${bannedUser}</div>-->

                            </div> 
                            <div class="col-md-6">
                                <span style="display:flex;">
                                    Active:   <div class="progress-bar progress-bar-striped active" role="progressbar" style="width: 30px; height: 20px; text-align: center" ></div>
                                    | Inactive: <div class="progress-bar-striped bg-warning" role="progressbar" style="width: 30px; height: 20px; text-align: center" ></div>
                                    <!--| Banned: <div class="progress-bar-striped bg-danger" role="progressbar" style="width: 30px; height: 20px; text-align: center" ></div>-->
                                </span>
                            </div>
                        </div>
                        <canvas id="myChart" style="width:100%;max-width:60vw"></canvas>
                        <!--BAR CHART SHOWING THE WORKING EMPLOYEE BASED ON ROLES-->
                        <script>
                            var xValues = ${roleNames};
//                            var xValues = ["ADMIN", "MANAGER", "SALE", "GUARD"];
                            var yValues = ${roleCount};
//                            var yValues = [1,2,3,4]
                            var barColors = ["red", "green", "blue", "orange"];
                            new Chart("myChart", {
                                type: "bar",
                                data: {
                                    labels: xValues,
                                    datasets: [{
                                            backgroundColor: barColors,
                                            data: yValues
                                        }]
                                },
                                options: {
                                    legend: {display: false},
                                    title: {
                                        display: true,
                                        text: "Active Employees Count"
                                    },
                                    scales: {
                                        yAxes: [{
                                                ticks: {
                                                    beginAtZero: true
                                                }
                                            }]
                                    }
                                }
                            });
                        </script>
                    </c:if>

                    <c:if test="${Account.roleName.equals('MANAGER')}">
                        <h4>Total reports/applications: ${allReports}</h4>
                        <div class="row">
                            <div class="progress progress-animated col-md-6 " style="height: 30px;">
                                <div class="progress-bar bg-success p-10" role="progressbar" style="width: ${(statusCount[0] / allReports) *100}%;  font-size: 150%" aria-valuenow="${statusCount[0]}" aria-valuemin="0" aria-valuemax="${allReports}">${statusCount[0]}</div>
                                <div class="progress-bar progress-bar-striped bg-primary active p-10" role="progressbar" style="width: ${(statusCount[1] / allReports) *100}%; font-size: 150%" aria-valuenow="${statusCount[1]}" aria-valuemin="0" aria-valuemax="${allReports}">${statusCount[1]}</div>
                                <div class="progress-bar bg-danger p-10" role="progressbar" style="width: ${(statusCount[2]/ allReports) *100}%; font-size: 150%" aria-valuenow="${statusCount[2]}" aria-valuemin="0" aria-valuemax="${allReports}">${statusCount[2]}</div>

                            </div> 
                            <div class="col-md-6">
                                <span style="display:flex;">
                                    Approved:   <div class="progress-bar bg-success" role="progressbar" style="width: 30px; height: 20px; text-align: center" ></div>
                                    | Processing: <div class="progress-bar progress-bar-striped bg-primary active" role="progressbar" style="width: 30px; height: 20px; text-align: center" ></div>
                                    | Denied: <div class="progress-bar bg-danger" role="progressbar" style="width: 30px; height: 20px; text-align: center" ></div>
                                </span>
                            </div>
                        </div>
                        <canvas id="myChart" style="width:100%;max-width:60vw"></canvas>
                        <script>
                            var xValues = ${typeNames};
//                            var xValues = ["ADMIN", "MANAGER", "SALE", "GUARD"];
                            var yValues = ${typeCount};
//                            var yValues = [1,2,3,4]
                            var barColors = ["red", "green"];
                            new Chart("myChart", {
                                type: "bar",
                                data: {
                                    labels: xValues,
                                    datasets: [{
                                            backgroundColor: barColors,
                                            data: yValues
                                        }]
                                },
                                options: {
                                    legend: {display: false},
                                    title: {
                                        display: true,
                                        text: "Report Type Count"
                                    },
                                    scales: {
                                        yAxes: [{
                                                ticks: {
                                                    beginAtZero: true
                                                }
                                            }]
                                    }
                                }
                            });
                        </script>
                    </c:if>
                    <hr/>
                    <c:if test="${Account.roleName.equals('SALE') || Account.roleName.equals('GUARD')}">
                        <h3>Processing Reports</h3>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Report Title</th>
                                    <th>Create Date</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="report" items="${list1}" varStatus="loop">
                                    <tr>
                                        <td>${report.reportTitle}</td>
                                        <td>${report.createDate}</td>
                                        <td><span class="badge bg-warning text-dark fs-6 px-1 py-0">${report.statusText}</span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <style>
                            .table {
                                width: 100%;
                                border-collapse: collapse;
                                margin-top: 10px;
                            }

                            .table th,
                            .table td {
                                padding: 8px;
                                border-bottom: 1px solid #ddd;
                            }
                        </style>
                    </c:if>
                    <!--                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
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
                                        </div>-->
                    <!--                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
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
                                        </div>        -->




                </div>

            </div>
        </div>

    </body>
</html>
