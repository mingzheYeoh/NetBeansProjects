<%-- 
    Document   : home
    Created on : Feb 9, 2024, 3:19:48 PM
    Author     : mingzhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User: Home</h1>
        <c:if test="${not empty userObj}">
            <h1>Name:${userObj.name}</h1>
            <h1>Email:${userObj.email}</h1>
        </c:if>
                                
    </body>
</html>
