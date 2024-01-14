package src.main.java.com.cuiyq._06_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        System.out.println("ContextServlet2_doget()");
        System.out.println("ContextServlet2:" + servletContext.getAttribute("key1"));
    }
}
