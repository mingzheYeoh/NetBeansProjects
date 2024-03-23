<%-- 
    Document   : SaveCountryDetails
    Created on : Mar 23, 2024, 9:26:02 AM
    Author     : mingzhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="country" class="domain.Country" scope="session"></jsp:useBean>
<jsp:useBean id="countryDA" class="da.CountriesDA" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
    <body>
    <% countryDA.addRecord(country);%>
    <%= country.getName()%> has been added to the database <br/>
    </body>
</html>
