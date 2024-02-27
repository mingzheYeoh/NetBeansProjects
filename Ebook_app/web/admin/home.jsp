<%-- 
    Document   : admin
    Created on : Feb 9, 2024, 3:21:14 PM
    Author     : mingzhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Home</title>
        <%@include file="allCss.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <div class="container">
            <div class="row p-5">
                <div class="col-md-3">
                    <a href="add_book.jsp">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fa-solid fa-square-plus fa-3x text-primary"></i>
                                <h4>Add Books</h4>
                                <p><b>--------------</b></p>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-book-open fa-3x text-danger"></i>
                            <h4>All Books</h4>
                            <p><b>--------------</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-cart-shopping fa-3x text-warning"></i>
                            <h4>Orders</h4>
                            <p><b>--------------</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i>
                            <h4>Logout</h4>
                            <p><b>--------------</b></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
