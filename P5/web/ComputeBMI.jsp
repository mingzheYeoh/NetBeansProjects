<%-- 
    Document   : ComputeBMI
    Created on : Mar 23, 2024, 8:28:01 AM
    Author     : mingzhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.BMI"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI Calculation</title>
    </head>
    <body>
        <h1>BMI Calculation</h1>
        <%
            double height = Double.parseDouble(request.getParameter("height"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            BMI bmi = new BMI(weight, height);
        %>
        Height: <%= height%><br/>
        Weight: <%= weight%><br/>
        BMI: <%= String.format("%.2f", bmi.getBMI())%><br/>
        Category: <%= bmi.getStatus() %><br/>
    </body>
</html>
