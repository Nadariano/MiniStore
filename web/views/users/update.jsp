<%-- 
    Document   : update
    Created on : May 30, 2023, 11:13:37 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users Updater</title>
</head>
<body>

    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <!-- Page Content -->

    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <h4 class="page-title">Users Updater</h4>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form action="<c:url value="/users/update_handler.do"/>">
                    <div class="mb-3 mt-3">
                        <label for="userID" class="form-label">User ID:</label>
                        <input disabled type="number" class="form-control" id="userID" placeholder="User ID" value="${users.userID}">
                        <input type="hidden" name="userID" value="${users.userID}">
                    </div>
                    <div class="mb-3">
                        <label for="userName" class="form-label">Username:</label>
                        <input type="text" class="form-control" id="userName" placeholder="Username" name="userName" value="${users.userName}">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="${users.password}">
                    </div>
                    <div class="mb-3">
                        <label for="fullName" class="form-label">Full Name:</label>
                        <input type="text" class="form-control" id="fullName" placeholder=" Full Name" name="fullName" value="${users.fullName}">
                    </div>
                    <div class="mb-3">
                        <label for="avatar" class="form-label">Avatar Link:</label>
                        <input type="text" class="form-control" id="avatar" placeholder="Avatar link" name="avatar" value="${users.avatar}">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address:</label>
                        <input type="text" class="form-control" id="address" placeholder="Address" name="address" value="${users.address}">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone Number:</label>
                        <input type="text" class="form-control" id="phone" placeholder="Phone" name="phone" value="${users.phone}">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="text" class="form-control" id="email" placeholder="Email" name="email" value="${users.email}">
                    </div>
                    <div class="mb-3">
                        <label for="status" class="form-label">Status:</label>
        <!--                <input type="number" class="form-control" id="status" placeholder="Status" name="status" value="${users.status}">-->
                        <select name="status" class="form-control">
                            <option value="0">Inactive</option>
                            <option value="1">Active</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="note" class="form-label">Note:</label>
                        <input type="text" class="form-control" id="note" placeholder="Note" name="note" value="${users.note}">
                    </div>
                    <div class="mb-3">
                        <label for="roleID" class="form-label">Roles:</label>
                        <!--<input type="number" class="form-control" id="roleID" placeholder="Role ID" name="roleID" value="${users.roleID}">-->
                        <select name="roleID" class="form-control">
                            <option value="1">Manager</option>
                            <option value="2">Sale</option>
                            <option value="3">Guard</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-outline-success" name="op" value="update">Update <i class="bi-check-square"></i></button>
                    <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel <i class="bi bi-x-square"></i></button>
                </form>
            </div>
        </div>
    </div>

</body>        
