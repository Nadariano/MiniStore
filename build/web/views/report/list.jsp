<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>REPORT LIST </title>
    </head>

    <body>

        <!-- Preloader -->
        <div class="preloader">
            <div class="cssload-speeding-wheel"></div>
        </div>
        <!-- Page Content -->
        <c:choose>
            <c:when test="${Account.roleName.equals('MANAGER')}">
                <div class="container-fluid">
                    <div class="row bg-title">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">REPORT LIST</h4>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>

                   <style>
  .search-form {
    display: none;
  }

  .search-form.active {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .form-group {
    display: flex;
    align-items: center;
    margin-bottom: 16px;
  }

  .form-group label {
    margin-right: 8px;
  }

  .form-group input[type="text"],
  .form-group select {
    margin-right: 8px;
  }
  
  .dropdown-menu {
    right: auto !important;
    left: 0 !important;
  }
</style>

<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="searchMethodDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Search By Date
  </button>
  <div class="dropdown-menu" aria-labelledby="searchMethodDropdown">
    <a class="dropdown-item" href="#" onclick="showSearchForm('searchByDateForm')">Search By Date</a>
    <a class="dropdown-item" href="#" onclick="showSearchForm('searchByNameForm')">Search By Name</a>
  </div>
</div>

<form action="<c:url value="/report/searchByDate.do"/>" class="search-form active" id="searchByDateForm">
  <div class="form-group">
    <label for="day">Day:</label>
    <select name="day">
      <option value="">Day</option>
      <% for (int i = 1; i <= 31; i++) {%>
      <option value="<%= i%>"><%= i%></option>
      <% } %>
    </select>

    <label for="month">Month:</label>
    <select name="month">
      <option value="">Month</option>
      <% for (int i = 1; i <= 12; i++) {%>
      <option value="<%= i%>"><%= i%></option>
      <% } %>
    </select>

    <label for="year">Year:</label>
    <select name="year">
      <option value="">Year</option>
      <% for (int i = 1900; i <= 2023; i++) {%>
      <option value="<%= i%>"><%= i%></option>
      <% }%>
    </select>

    <button type="submit" class="btn btn-primary" name="op" value="search">Search</button>
  </div>
</form>

<form action="<c:url value="/report/searchByName.do"/>" class="search-form" id="searchByNameForm">
  <div class="form-group">
    <label for="fullName">Name:</label>
    <input type="text" id="fullName" name="fullName">

    <button type="submit" class="btn btn-primary" name="op" value="search">Search</button>
  </div>
</form>

<script>
  function showSearchForm(formId) {
    const forms = document.querySelectorAll('.search-form');
    forms.forEach(form => {
      if (form.id === formId) {
        form.classList.add('active');
      } else {
        form.classList.remove('active');
      }
    });
    const dropdownToggle = document.querySelector('#searchMethodDropdown');
    const dropdownLabel = document.querySelector(`[onclick="showSearchForm('${formId}')"]`).textContent;
    dropdownToggle.textContent = dropdownLabel;
  }
</script>
                    <!-- /row -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <div class="table-responsive">
                                    <table class="table" id="example">

                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>Report Title</th>
                                                <th>Type</th>
                                                <th>Create Date</th>
                                                <th>User ID</th>
                                                <th>Author</th>
                                                <th>Description</th>
                                                <th>Planned Date</th>
                                                <th>Status</th>
                                                <th>Note</th>
                                                <th>Operations</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="report" items="${list}" varStatus="loop">
                                                <tr>
                                                    <td>${loop.count}</td>
                                                    <td>${report.reportTitle}</td>
                                                    <th>${report.typeName}</th>
                                                    <td>${report.createDate}</td>
                                                    <td>${report.userID}</td>
                                                    <td>${report.fullName}</td>
                                                    <td>${report.description}</td>
                                                    <td>${report.plannedDate}</td>
                                                    <c:if test="${report.statusText=='Rejected'}">
                                                        <td style="background-color:  #ac2925; color: whitesmoke " >${report.statusText}</td>
                                                    </c:if>
                                                    <c:if test="${report.statusText=='Approved'}">
                                                        <td style="background-color: #398439; color: whitesmoke">${report.statusText}</td>
                                                    </c:if>
                                                    <c:if test="${report.statusText=='Processing'}">
                                                        <td style="background-color: grey; color: whitesmoke">${report.statusText}</td>
                                                    </c:if>    
                                                    <td>${report.note}</td>

                                                    <td>
                                                        <a href="<c:url value="/report/update.do?reportID=${report.reportID}"  />" class="btn btn-sm btn-primary">Update</a>
                                                        <a href="<c:url value="/report/delete.do?reportID=${report.reportID}" /> " onclick="return confirm('Do you really want to remove it?');" class="btn btn-sm btn-danger">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->

                <!-- /#page-wrapper -->
            </c:when>
            <c:otherwise>
                <jsp:forward page="/error/error.do" />
            </c:otherwise>
        </c:choose>
    </body>

</html>