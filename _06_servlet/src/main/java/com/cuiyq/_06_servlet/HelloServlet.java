package src.main.java.com.cuiyq._06_servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("all")
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法。。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init 初始化方法");

        /**
            学习ServletConfig类的三大作用
         */

        // 1、可以获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("HelloServlet程序的别名:" + servletConfig.getServletName());

        // 2、获取初始化参数 init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        // 3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * servlet都会执行的方法
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //学习请求分发处理
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();

//        get方法
        if ("GET".equals(method)) {
            doGet();
        }

//        post方法
        if ("POST".equals(method)) {
            doPost();
        }

    }

    public void doGet() throws ServletException, IOException {
        System.out.println("get方法1");
        System.out.println("get方法1");
        System.out.println("get方法1");
    }

    public void doPost() throws ServletException, IOException {
        System.out.println("post方法1");
        System.out.println("post方法1");
        System.out.println("post方法1");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 销毁方法");
    }
}