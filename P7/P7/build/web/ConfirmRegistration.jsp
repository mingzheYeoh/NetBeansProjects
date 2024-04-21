<%-- 
    Document   : ConfirmRegistration
    Created on : 13 Apr 2024, 9:40:20 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="registration" scope="session" class="entity.Registration"></jsp:useBean>
<jsp:useBean id="student" scope="session" class="entity.Student"></jsp:useBean>
<%@page import="java.util.*, entity.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Excel Tuition Center</h1><br/><br/>
        <h2>Subject Registration Details</h2><br/>
        <h3>
            Student: ${student.name} [${student.ic}] <br/>
            Registration No: <%= registration.getRegId()%><br/><br/>
            Registered Subjects: <br/>
        </h3>
        <table border="1" cellspacing="1" cellpadding="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Subject Code</th>
                        <th>Title</th>
                        <th>Fee (RM)</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<RegisteredSubject> registeredSubjectList = registration.getRegisteredSubjectList();
                        
                        for(int i = 0; i<registeredSubjectList.size(); i++){
                            RegisteredSubject registrationSubject = registeredSubjectList.get(i);
                            Subject subject = registrationSubject.getSubjectCode();
                    %>
                    <tr>
                        <td align="center"><%= (i + 1) %></td>
                        <td align="center"><%=subject.getSubjectCode() %></td>
                        <td><%=subject.getTitle() %></td>
                        <td align="center"><%=subject.getFee() %></td>
                    </tr>
                    
                    <%}%>
                </tbody>
            </table><br/>
            <h2>Total Amount Due: RM<%= registration.getRegistrationTotal() %></h2>
            <br/><br/>
    </body>
</html>
