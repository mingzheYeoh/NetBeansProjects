<%@page import="java.util.List"%>
<%@page  import="model.Item" %>
<%
  List<Item> itemList = (List)session.getAttribute("itemList");
%>
<h1>Search Item </h1>
<table border="0" cellspacing="10">
<form action="SearchItem.jsp" method="post">
    <tr>
        <td>Item code</td>
        <td><select name="code">
                <% for (Item item: itemList){%>
                <option value="<%=item.getCode()%>">
                    <%=item.getCode()%>
                <%}%>
            </select>
            <br>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Delete" name="button"/>
            <input type="submit" value="Update" name="button"/>
        </td>
    </tr>
</form>
</table>
