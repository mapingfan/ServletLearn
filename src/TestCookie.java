import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2")
public class TestCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        Cookie cookie = new Cookie("c1", "c1");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("c2", "c2");
        cookie2.setMaxAge(-1);
        response.addCookie(cookie2);

        Cookie cookie3 = new Cookie("c3", "c3");
        cookie3.setMaxAge(3600);
        response.addCookie(cookie3);

        Cookie cookie4 = new Cookie("c4", "c4");
        cookie4.setMaxAge(3600);
        response.addCookie(cookie4);

        writer.print("<html><head>Cookie Test</head><body><p>This site is used to test cookie</p>" +
                "<a href=/test/showCookie>show cookie</a> </body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
