import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Servlet5")
public class SetSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        PrintWriter printWriter = response.getWriter();
        String heading;
        response.setContentType("text/html");
        Integer accessCount = (Integer) httpSession.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = 0;
            heading = "Welcome Newer.";
        } else {
            accessCount += 1;
            heading = "Welcome Back";
        }
        httpSession.setAttribute("accessCount", accessCount);
        printWriter.println("<html><head>Set Session</head><body>");
        printWriter.println("<p align=center>" + heading + "</p>");
        printWriter.println("<table border=1>");
        printWriter.println("<tr><td>Session ID</td>");
        printWriter.println("<td>" + httpSession.getId() + "</td></tr>");
        printWriter.println("<tr><td>Session Creation Time</td>");
        printWriter.println("<td>" + new Date(httpSession.getCreationTime()) + "</td></tr>");
        printWriter.println("<tr><td>Last Access Time</td>");
        printWriter.println("<td>" + new Date(httpSession.getLastAccessedTime()) + "</td></tr>");
        printWriter.println("<tr><td>Number of Access</td>");
        printWriter.println("<td>" + httpSession.getAttribute("accessCount") + "</td></tr>");

        printWriter.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
