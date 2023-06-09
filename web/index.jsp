<%-- 
    Document   : index.jsp
    Created on : May 27, 2023, 10:24:22 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${Account==null}">
        <jsp:forward page="/account/login.do" />
    </c:when>
    <c:otherwise>
        <jsp:forward page="/home/index.do" />
    </c:otherwise>
</c:choose>
