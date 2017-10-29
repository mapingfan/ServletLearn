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
[1]: http://blog.csdn.net/antony9118/article/details/51800404