<%@page import="java.util.List"%>
<%@page import="model.Item"%>

<!-- retrieve session object, itemList -->
<%
  List<Item> itemList = (List)session.getAttribute("itemList");
%>
<h1>View All Items </h1>

<!-- Display items -->
<table border="1">
    <tr>
        <th>Item Code</th>
        <th>Description</th>
        <th>Price (RM)</th>
    </tr>
    <% for (Item item: itemList){ %>
        <tr>
            <td><%= item.getCode() %></td>
            <td><%= item.getDescription() %> </td>
            <td><%= String.format("%.2f", item.getPrice()) %></td>
        </tr>
    <% } %>
</table>
<br><br>
<p><a href="index.html">Back to home page</a></p>