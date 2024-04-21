<%-- 
    Document   : AddItem
    Created on : 20 Apr 2024, 10:26:02 AM
    Author     : Tan Jee Schuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= session.getAttribute("addTitle")%></h1>
        <h1>Add New Item</h1>
        <form action="../AddItem">
            <table border="0">
             <tr>
                 <td>Code</td>
                 <td><input type="text" name="code"></td>
             </tr>
             <tr>
                  <td>Description</td>
                  <td><input type="text" name="description" size="50"></td>
             </tr>
             <tr>
                  <td>Price</td>
                  <td><input type="text" name="price"></td>
             </tr>

            </table>
            <input type="submit" value="Add">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>
