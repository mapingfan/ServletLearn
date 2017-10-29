import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "Servlet")
public class Parameters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        Enumeration enumeration = request.getParameterNames();
        Map<String, String[]> map = request.getParameterMap();
        for (String[] key : map.values()) {
            printWriter.println(Arrays.deepToString(key));
        }
        printWriter.println("<html><head>" + "Read parameters" + "</head><body><p align=center>\"hhh\"</p>" +

                "<table border =\"1\">");
        while (enumeration.hasMoreElements()) {

            String name = (String) enumeration.nextElement();
            printWriter.println("<tr><td>" + name + "</td>");
            String[] values = request.getParameterValues(name);
            printWriter.println("<td><ul style=\"list-style: none\">");
            if (values.length == 1) {
                String tmp_value = values[0];
                if (tmp_value.length() == 0) {
                    printWriter.println(name + "No value");
                } else {
                    printWriter.println("<li list-style:none>" + tmp_value + "</li>");
                }
            } else {
                for (int i = 0; i < values.length; i++) {

                    printWriter.println("<li>" + values[i] + "</li>");
                }
            }
            printWriter.println("</ul></td></tr>");
        }
        printWriter.println("</table></body></html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
