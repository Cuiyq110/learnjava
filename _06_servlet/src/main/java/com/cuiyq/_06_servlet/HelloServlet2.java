package src.main.java.com.cuiyq._06_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：使用集成HttpServlet完成get，set请求分发
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写init初始化方法，做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloServlet2_doGet方法");

        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

//      获取初始化参数init-param的值
        String username = servletConfig.getInitParameter("username");
        System.out.println(username);
        String url = servletConfig.getInitParameter("url");
        System.out.println(url);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloServlet2_doPost方法");
    }
}
