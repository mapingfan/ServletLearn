<%--
  Created by IntelliJ IDEA.
  User: 马平凡
  Date: 2017/10/30
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AccessCount</title>
</head>
<body>
<%--/*
* %!里面声明的是成员变量。因为jsp也是servlet小程序，而且整个程序运行过程中，servlet只实例化一次，所以这个变量每次访问都是访问同一个。
* 在< %里面声明的变量是局部变量。不可以在<%里面声明方法，只能执行语句。
   可以在<!% 里面声明方法；
* */--%>
<% //hhh %>
<%! int accessCount = 0; %>
<% int accessCount2 = 0; %>
<% ++accessCount; %>
<% ++accessCount2; %>
<p>The accessCount is <%=accessCount%>
</p>
<hr>
<p>The accessCount2 is <%=accessCount2%>
</p>
</body>
</html>
