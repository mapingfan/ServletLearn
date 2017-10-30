<%--
  Created by IntelliJ IDEA.
  User: 马平凡
  Date: 2017/10/30
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forward</title>
</head>
<body bgcolor="red">
<p>gg</p>
<jsp:forward page="blue.jsp">
    <jsp:param name="1" value="1"/>
    <jsp:param name="2" value="2"/>
</jsp:forward>
</body>
</html>
