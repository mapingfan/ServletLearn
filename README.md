# ServletLearn
### JSP&amp;Tomcat&amp;Servlet学习
#### Day1
在IDEA中配置Tomcat，测试下JSP/Servlet文件的运行；
遇到的问题如下：

Q1:如何在IDEA中建立Java Web文件？

A1:[答案在链接中][1]

Q2:如何让JSP中的修改实时生效？

A2:菜单Build-->Build Artifacts;

Q3:如何在IDEA中运行Servlet小程序？

A3:不修改web.xml文件，直接在Servlet类前加上注解`@WebServlet(name = "TestServlet" ,urlPatterns = {"/HelloServlet"})`。IDEA会帮你生产`name`,但是`urlPatterns`不会生产，需要手动填写。其次还需要注意，`servlet`类是无法运行的，不要找了。直接打开浏览器在最后面添上类名就好。

---

### Day2
添加了一个类TestHTTP,模拟浏览器的行为，获取页面。
这个仓库里的文件主要是用于测试Tomcat，学习在IDEA下建立Tomcat工程。

承接上面提到的，具体讲下如何配置Servlet。
我们上面提到过，可以不修改`web.xml`文件，利用注解就可以运行`servlet`小程序。现在讲下如何配置`web.xml`文件。
我们需要在文件中添加四个东西。
```
<servlet>
<servlet-name>HW</servlet-name>
<servlet-class>  </servlet-class>
<--!class文件指的是servlet程序编译好产生的class文件，放在我们web-inf目录classes目录下。
 编译产生的class叫什么名字，这个地方就写什么名字。当我们调用名叫HW的servlet小程序时，会去寻找class文件。所以，class文件名必须写对。小程序的名字就很随意。-->
</servlet>

<servlet-mapping>
<servlet-name>  </servlet-name>
<url-pattern> /abc </url-pattern>
</servlet-mapping>
<!--下面的标签叫小程序映射。意思就是当我们浏览器输入什么地址时会调用我们指定名字的servlet小程序。 这个地方的名字和上面的名字必须一致。
 url-pattern永远以/开头。相对web application为根路径。这个地方的url随便写。
 当我们输入/abc后，程序会找HW的servlet小程序，然后寻找相应的class文件。表面上访问/abc，实际执行的是servlet小程序。 -->
```
---

### Day3

通过`do get`方法获得参数。通过静态网页表单的`action`事件，调用容器中的`servlet`小程序。
Web程序三大件：`cookie,session,application`.这三个东西始终围绕`web`应用。其实这个三个东西都是容器，存放一些信息。针对`http`的无连接特性，有了`cookie，session`,保存会话信息。其中`cookie`是保存在客户端电脑上的，服务器根据`cookie`验证用户。`session`只存放当前浏览器页面中，页面一旦关闭，`session`也就没了。`application`也叫`context`，上下文，是一块公共区域，存储当前`WebApp`应用下所有`servlet`小程序可以访问的内容。这个区域是容器内部小程序共享的。
对于这三个东西，要搞清楚，才能理解`web`开发。

学习`Java Bean`,了解`Bean`存在的理由，只是一套标准，一个类。使用`Bean`类封装数据库连接相关信息，在`servlet`中连接数据库，读数据。

---

### Day4

`<%!`里面声明的是成员变量。因为`jsp`也是`servlet`小程序，而且整个程序运行过程中，`servlet`只实例化一次，所以这个变量每次访问都是访问同一个。
在`<%`里面声明的变量是局部变量。不可以在`<%`里面声明方法，只能执行语句。
可以在`<!%`里面声明方法；
`jsp`的三种注释方法
```
  <%--comments --%>
  <% /*comments */ %>
  <% //comments  %>
```
html的注释在客户端网页中是可以看见的，但是`jsp`的注释在网页中无法看见。
```
<%@ page 指令中的四个重点。contentType="text/html;charset=gb2312" errorPage="Error.jsp" isErrorPage="true"  import="java.util.*"
我们可以看到page指令的形式，都是属性=属性值。

<%@include file="ErrorPage.html"%> 先包含，然后编译执行。
include指令，用于包含文件；同jsp:include区分，这个是先执行，遇到在编译。

<jsp:include page="multiply.jsp">
    <jsp:param name="first" value="<%=value1%>"/>
    <jsp:param name="second" value="<%=value2%>"/>
</jsp:include>

学习这种包含文件指令；
同<%@include file="divide.jsp"%>区分开。
下面的这种file属性的不能指定参数，上面的可以指定参数。
上面的是遇到时候在编译，下面这个先加载进来，然后就编译执行。
```
```
<jsp:forward page="blue.jsp">
    <jsp:param name="1" value="1"/>
    <jsp:param name="2" value="2"/>
</jsp:forward>
<% response.sendRedirect("blue.jsp"); %>
两者的区别；
上面的跳转，浏览器地址栏仍是显示跳转前的地址，但是界面是跳转后的，共用一个request对象。
下面的跳转，其实是发起了两次请求。不共用request对象。
```

[1]: http://blog.csdn.net/antony9118/article/details/51800404