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
public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ContextServlet1_doget()");
//        创建ServletContext对象
        ServletContext servletContext = getServletContext();
        System.out.println("servletContext:" +servletContext);
        System.out.println("保存之前key1的值:" + servletContext.getAttribute("key1"));
        servletContext.setAttribute("key1", "value1");
        System.out.println("保存之后key1的值:" + servletContext.getAttribute("key1"));

//        servletContext.setAttribute();

    }
}
