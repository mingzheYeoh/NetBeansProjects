<%-- retrieve selected item code --%>
<%
   String code = request.getParameter("code");
%>

<%-- retrieve button that was clicked --%>
<%
  String button = request.getParameter("button");
%>

<%-- redorect to SearchItem servlet --%>
<%
  session.setAttribute("code", code);
  session.setAttribute("button", button);
  response.sendRedirect("../SearchItem");
%>
