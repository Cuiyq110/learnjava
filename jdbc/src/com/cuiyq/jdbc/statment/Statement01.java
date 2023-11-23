package com.cuiyq.jdbc.statment;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 学习 sql注入
 */
@SuppressWarnings("all")
public class Statement01 {
    //接收用户输入
    Scanner scanner = new Scanner(System.in);

    @Test
    public void test() throws Exception {

        /*
        1' OR
        OR '1'= '1              --万能密码
        --SQL-- 输入用户名 为 1 ' or
        -- 输入万能密码 为 or ' 1 '= ' 1
        SELECT * FROM admin WHERE NAME = '1' OR
        ' AND pwd = ' OR '1' = '1
        */
        String admin_name = "";
        String admin_pwd = "";
        System.out.println("请输入用户名:");
        admin_name = scanner.nextLine();
        System.out.println("请输入密码:");
        admin_pwd = scanner.nextLine();
        System.out.println("loading...");
        //通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        // 获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select name,pwd from admin where name ='"
                + admin_name + "' AND + pwd = '" + admin_pwd + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登录成功");
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("pwd"));
        } else {
            System.out.println("登录失败");
        }

        resultSet.close();
        statement.close();
        connection.close();

    }

}


