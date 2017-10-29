package com.mpf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet6")
public class TestContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        Integer accessCount = (Integer) servletContext.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = 0;
        } else {
            accessCount += 1;
        }
        servletContext.setAttribute("accessCount", accessCount);
        printWriter.println("<html><head>Context</head><body>");
        printWriter.println("<p align = center>Context Test</p>");
        printWriter.println("<hr>");
        printWriter.println("<p align=center>" + servletContext.getAttribute("accessCount"));
        printWriter.println("</p><body></html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
