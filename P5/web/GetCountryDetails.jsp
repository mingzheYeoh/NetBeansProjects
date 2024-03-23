<%-- 
    Document   : GetCountryDetails
    Created on : Mar 23, 2024, 8:44:41 AM
    Author     : mingzhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="country" class="domain.Country" scope="session"></jsp:useBean>
<jsp:setProperty name="country" property="*"></jsp:setProperty>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Country</title>
    </head>
    <body>
        <p>You entered the following data</p>
        <p>Country name: <%=country.getName()%></p>
        <p>Official name: <%=country.getFullName()%></p>
        <p>Capital: <%=country.getCapital()%></p>
    </body>
    
    <form method="post" action="SaveCountryDetails.jsp">
        <input type="submit" value="Confirm">
    </form>
</html>
