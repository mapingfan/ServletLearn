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


[1]: http://blog.csdn.net/antony9118/article/details/51800404