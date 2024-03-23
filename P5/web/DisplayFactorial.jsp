<%-- 
    Document   : DisplayFactorial
    Created on : Mar 23, 2024, 8:12:20 AM
    Author     : mingzhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial Table</title>
    </head>
    <body>
        <h1>Factorial Table</h1>
        <table>
            <tr>
                <td>Number</td><td>Factorial</td>
            </tr>
            <%! int result = 1;%>
            <%! 
                for(int i = 1; i < 10; i++{
                    result *= i;
                }
            %>
               
            <tr>
                <td><%= i%></td><td><%= result%></td>
            </tr>
        </table>
    </body>
</html>
