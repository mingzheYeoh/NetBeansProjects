<%-- 
    Document   : login
    Created on : 20 Apr 2024, 9:29:22 AM
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
        <form action="j_security_check" method="POST">
            Username: <input type="text" name="j_username"></br>
            Password <input type="text" name="j_password"></br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
