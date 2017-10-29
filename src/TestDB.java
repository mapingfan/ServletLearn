import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Servlet7")
public class TestDB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        writer.println("<html><head>Test DataBase</head><body>");
        String url = "jdbc:mysql://localhost:3306/mydata";
        writer.println("<ul>");
        connection = DB.getConnection(url, "root", "320823");
        statement = DB.getStatement(connection);
        String sql = "select * from article";
        resultSet = DB.getResultSet(sql, statement);
        try {
            while (resultSet.next()) {
                writer.println("<li>" + resultSet.getString(2) + "</li>");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        writer.println("</ul></body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
