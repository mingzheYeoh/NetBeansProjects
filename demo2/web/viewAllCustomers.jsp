<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Customers</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>All Customers</h1>
    <% 
    List<DB_Model.Customerregister> customers = (List<DB_Model.Customerregister>)request.getAttribute("customers");
    if (customers != null) {
    %>
    <table>
        <thead>
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Joined Date</th>
            </tr>
        </thead>
        <tbody>
            <% 
            for (DB_Model.Customerregister customer : customers) { 
            %>
            <tr>
                <td><%= customer.getCustomerId() %></td>
                <td><%= customer.getCustomerName() %></td>
                <td><%= customer.getCustomerEmail() %></td>
                <td><%= customer.getCustomerPassword() %></td>
                <td><%= customer.getJoinedDate() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>No customers found.</p>
    <% } %>
</body>
</html>
