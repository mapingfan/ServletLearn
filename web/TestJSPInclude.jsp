<%--
  Created by IntelliJ IDEA.
  User: 马平凡
  Date: 2017/10/30
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String value1 = request.getParameter("first");
    String value2 = request.getParameter("second");
%>
<% if (request.getParameter("compute").equals("multiply")) { %>
<jsp:include page="multiply.jsp">
    <jsp:param name="first" value="<%=value1%>"/>
    <jsp:param name="second" value="<%=value2%>"/>
</jsp:include>
<% } else { %>
<%@include file="divide.jsp" %>
<% } %>
</body>
</html>
