package src.main.java.com.cuiyq._06_servlet;/**
 * @author Cuiyq
 * @version 1.0
 * describe：学习ServletContext四个方法
 */

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class HelloServlet3 extends HttpServlet {
    private String message;

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
//        1、获取 web.xml 中配置的上下文参数 context-param
        String username = servletContext.getInitParameter("username");
        System.out.println("context-param 的username的值是:" + username);
        System.out.println("context-param的value值是：" + servletContext.getInitParameter("password"));

        // 2、获取当前的工程路径，格式: /工程路径
        System.out.println("工程部署的路径是：" + servletContext.getRealPath("/"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}