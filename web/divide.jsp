<%--
  Created by IntelliJ IDEA.
  User: 马平凡
  Date: 2017/10/30
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Divide</title>
</head>
<body>
<%
    float first = Float.parseFloat(request.getParameter("first"));
    float second = Float.parseFloat(request.getParameter("second"));
    double result = first / second;
%>
<%=result%>
</body>
</html>
