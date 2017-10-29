import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet3")
public class ShowCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head>Cookie Show</head><body><p align=center>Show Cookie</p>" +
                "<ul>");
        for (int i = 0; i < cookies.length; i++) {
            printWriter.println("<li>" + cookies[i].getName() + " " + cookies[i].getValue() + "</li>");
            printWriter.println("<hr>");
        }
        printWriter.println("</ul><body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
