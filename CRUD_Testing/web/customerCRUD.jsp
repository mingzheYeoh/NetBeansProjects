<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer CRUD</title>
</head>
<body>
    <h1>Customer CRUD Operations</h1>
    <form action="../CustomerServlet" method="post">
        <h2>Add Customer:</h2>
        Name: <input type="text" name="name"><br>
        Email: <input type="email" name="email"><br>
        Password: <input type="password" name="password"><br>
        Joined Date: <input type="date" name="joinedDate"><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Add Customer">
    </form>
    
    <h2>Update Customer:</h2>
    <form action="../CustomerServlet" method="post">
        Customer ID: <input type="number" name="customerId"><br>
        Name: <input type="text" name="name"><br>
        Email: <input type="email" name="email"><br>
        Password: <input type="password" name="password"><br>
        Joined Date: <input type="date" name="joinedDate"><br>
        <input type="hidden" name="action" value="update">
        <input type="submit" value="Update Customer">
    </form>
    
    <h2>Delete Customer:</h2>
    <form action="../CustomerServlet" method="post">
        Customer ID: <input type="number" name="customerId"><br>
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="Delete Customer">
    </form>
    
    <h2>View All Customers:</h2>
    <form action="CustomerServlet">
        <input type="hidden" name="action" value="viewAll">
        <input type="submit" value="View All Customers">
    </form>
</body>
</html>
