<h3>
<%
  boolean success = (Boolean)session.getAttribute("success");
  if (success)
      out.println("Item updated successfully.");
  else
      out.println("Error: Unable to update item.");
%>
</h3>
<p><a href="../index.jsp">Back to home page</a></p>