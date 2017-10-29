import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet4")
public class TestSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>Session</head>");
        printWriter.println("<body>");
        printWriter.println("<p>Session Information");
        printWriter.println("<br>");
        printWriter.println("New Session " + httpSession.isNew());
        printWriter.println("<br>");
        printWriter.println("Session ID " + httpSession.getId());
        printWriter.println("<br>");
        printWriter.println("Session Creation Time: " + httpSession.getCreationTime());
        printWriter.println("<br>");
        printWriter.println("Session Last Accessed Time: " + httpSession.getLastAccessedTime());
        printWriter.println("<hr>");
        printWriter.println("<p>Request Information</p>");
        printWriter.println("<br>");
        printWriter.println("Session ID from Request :" + request.getRequestedSessionId());
        printWriter.println("<br>");
        printWriter.println("Session ID via Cookie :" + request.isRequestedSessionIdFromCookie());
        printWriter.println("<br>");
        printWriter.println("Session ID via written URL: " + request.isRequestedSessionIdFromURL());
        printWriter.println("<br>");
        printWriter.println("Valid Session ID :" + request.isRequestedSessionIdValid());
        printWriter.println("<br>");
        printWriter.println("<a href=/test/testSession>refresh</a>");
        printWriter.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
