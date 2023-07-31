<%-- 
    Document   : listOF
    Created on : Jun 9, 2023, 5:09:16 PM
    Author     : Dell
--%>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Pay Slip</title>
    </head>

    <body>
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <!-- Preloader -->
                <div class="preloader">
                    <div class="cssload-speeding-wheel"></div>
                </div>
                <!-- Page Content -->

                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">List of Pay Slip</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                            <a href="<c:url value="/paySlip/create.do"/>" class="btn btn-lg btn-success btn-rounded" title="Add PaySlip">
                                <i class="bi bi-credit-card"></i>
                            </a>
                        </div>

                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table table-striped " id="example">
                                        <h5><b>(Currency: VND)</b></h5>
                                        <thead>
                                            <tr>

                                                <th> No.</th>
                                                <th>User ID</th>
                                                <th>Full Name</th>
                                                <th>Salary(₫)</th>
                                                <th>Bonus Money</th>
                                                <th>Minus Money</th>

                                            
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Total</th>
                                                <th>Operations</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="paySlip" items="${list}" varStatus="loop">
                                                <tr>
                                                    <!--                                                    <td>
                                                                                                            <input disabled type="number" id="paySlipID"  value="${paySlip.paySlipID}">
                                                                                                            <input type="hidden" name="paySlipID" value="${paySlip.paySlipID}">
                                                                                                        </td>   
                                                                                                        <td>
                                                                                                            <input disabled type="number" id="userID"  value="${paySlip.userID}">
                                                                                                            <input type="hidden" name="userID" value="${paySlip.userID}">
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input disabled type="text" id="fullName"  value="${paySlip.fullName}">
                                                                                                            <input type="hidden" name="fullName" value="${paySlip.fullName}">
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input type="number" id="salary" name="salary" value="${paySlip.salary}"/>
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input type="number" id="bonus" name="bonus" value="${paySlip.bonus}"/>
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input type="number" id="minus" name="minus" value="${paySlip.minus}"/>
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input type="number" name="status" value="${paySlip.status}">
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input type="text" id="note" name="note" value="${paySlip.note}"/>
                                                                                                        </td>
                                                    -->

                                                   <td>${loop.count}</td>
                                                    <td>${paySlip.userID}</td>
                                                    <td>${paySlip.fullName}</td>
                                                    <td><fmt:formatNumber value="${paySlip.salary}" type="currency" currencySymbol="₫" maxFractionDigits="0" /></td>

                                                    <td>
                                                        <fmt:formatNumber value="${paySlip.bonus}" type="currency" currencySymbol="₫" maxFractionDigits="0" />
                                                    </td>
                                                    <td>
                                                        <fmt:formatNumber value="${paySlip.minus}" type="currency" currencySymbol="₫" maxFractionDigits="0" />
                                                    </td>

                                                    <td>${paySlip.statusText3}</td>
                                                    <td>
                                                        <button tabindex="0" class="${empty paySlip.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${paySlip.note}" 
                                                                data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                                <div class="arrow">
                                                                </div>
                                                                <div class="popover-body text-white p-3">
                                                                <span class="d-block">${paySlip.note}
                                                                </span>
                                                                </div>
                                                                </div>' ${empty paySlip.note ? 'disabled' : ''}>
                                                        <!--        <i class="${empty paySlip.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                        </button>
                                                    </td>
                                                 <td>
    <fmt:formatNumber value="${paySlip.salary + paySlip.bonus - paySlip.minus}" type="currency" currencySymbol="₫" maxFractionDigits="0" />
</td>


                                                   
                                                    <!--<td>${paySlip.paySlipID}</td>-->
<!--                                                     <td style="text-align: center">${paySlip.userID}</td>
                                                    <td style="text-align: center">${paySlip.fullName}</td>
                                                    <td style="text-align: center" >${paySlip.salary}</td>
                                                    <td style="text-align: center" >${Math.round(paySlip.bonus)}</td>
                                                    <td style="text-align: center" >${Math.round(paySlip.minus)}</td>
                                                    <td>${paySlip.statusText3}</td>
                                                   <td>
                                                            <button tabindex="0" class="${empty paySlip.note ? 'btn btn-sm btn-circle btn-disabled  bi-info-circle-fill'  : 'btn btn-sm btn-circle btn-info bi-info-circle-fill'}" role="button" data-toggle="popover" data-trigger="focus" title="Note" data-content="${paySlip.note}" 
                                                                    data-template='<div class="popover bg-info shadow-lg border-0" role="tooltip">
                                                                    <div class="arrow">
                                                                    </div>
                                                                    <div class="popover-body text-white p-3">
                                                                    <span class="d-block">${paySlip.note}
                                                                    </span>
                                                                    </div>
                                                                    </div>' ${empty paySlip.note ? 'disabled' : ''}>
                                                            <!--        <i class="${empty paySlip.note ? 'bi bi-info-lg font-bold' : 'bi bi-info-lg font-bold'}"></i>-->
                                                            </button>
                                                        </td>
                                                    <td>${ Math.round(paySlip.salary + paySlip.bonus - paySlip.minus)}</td> -->

                                                    <c:if test="${paySlip.status!=2}">
                                                        <td>
                                                            <a href="<c:url value="/paySlip/update.do?paySlipID=${paySlip.paySlipID}&userID=${paySlip.userID}"/>" class="btn btn-sm btn-github btn-rounded" title="Update">
                                                                <i class="bi bi-pencil-square"></i>
                                                            </a>
                                                        </td>

                                                    </c:if>
                                                    <c:if test="${paySlip.status == 2}">

                                                        <td class="badge badge-info ">Finished <i class="bi bi-cloud-check"></i></td>
                                                        </c:if>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                        <%--<c:if test="${paySlip.status != 2}">--%>

                                        <%--</c:if>--%>

                                    </table>
                                    <a  style="float: right" href="<c:url value="/paySlip/done.do"/>" onclick="return confirm('Do you want to finish ?');" class="btn btn-sm btn-dropbox btn-rounded">
                                        Done <i class="bi bi-check-circle"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>
