<%--
  Created by IntelliJ IDEA.
  User: 马平凡
  Date: 2017/10/30
  Time: 9:54
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  这是一个<%@ page 指令；可以在这个地方import相关库文件；
--%>
<html>
<head>
    <title>Test JSP</title>
</head>

<%!
    String color = null;
    boolean hasExplicitColor = false;
%>
<%
    color = request.getParameter("bgColor");
    if (color == null) {
        hasExplicitColor = false;
        color = "red";
    } else {
        hasExplicitColor = true;
    }
%>
<body bgcolor=<%= color%>>

<p align="center">The current bgColor is<%=color%>
</p>
</body>
</html>
