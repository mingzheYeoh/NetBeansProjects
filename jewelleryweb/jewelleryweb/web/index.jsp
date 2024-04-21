<%-- 
    Document   : index
    Created on : 20 Apr 2024, 10:11:54 AM
    Author     : Tan Jee Schuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<p><h1><%= application.getInitParameter("storeName")%></h1></p>
<p><h3><%= application.getInitParameter("contactUs")%></h3></p>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bling-Bling Jewellery</h1>
        <ul>
            <li><a href="View">View All Items</a><br>
            <li><a href="GetAddTitle">Add New Item</a><br>
            <li><a href="LoadItemList">Update/Delete Item</a><br>
            <li><a href="Logout">Logout</a></li>
        </ul>
    </body>
</html>
