<%@page import="model.Item"%>
<html>
    <head></head>
    <body>
        <%
            Item item = (Item) session.getAttribute("item");
            if (item != null) {
        %>
        <h1>Delete Item</h1>
        <form action="DeleteItem" method="post" onsubmit="return window.confirm('Are you sure you want to delete this item?')">
            <table border="0">
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code"
                               value="<%=item.getCode()%>" readonly></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" size="50"
                               value="<%=item.getDescription()%>" readonly></td>
                </tr>
                <tr>
                    <td>Price (RM)</td>
                    <td><input type="text" name="price"
                               value="<%=String.format("%.2f", item.getPrice())%>" readonly></td>
                </tr>
            </table>
            <input type="submit" value="Delete Item">

        </form>
        <%} else {%>
        Item ${item.code} not found
        <p><a href="index.html">Back to home page</a></p>
        <%}%>
    </body>
</html>

