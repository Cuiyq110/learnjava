package com.cuiyq.jdbc.preparedstatement;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 练习预处理
 */
@SuppressWarnings("all")
public class PreparedStatement_ {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void test() throws Exception {
        String admin_user = "";
        String admin_pwd = "";

//      用户输入用户名和密码
        System.out.println("input user:");
        admin_user = scanner.nextLine();
        System.out.println("input password:");
        admin_pwd = scanner.nextLine();
        System.out.println("loading...");

//        通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//mysql.properties"));
//       获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

//        注册驱动
        Class.forName(driver);
//        获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
//        得到PrepareStatement
        String sql = "SELECT * from admin where name = ? AND pwd = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//      给?赋值
        preparedStatement.setString(1, admin_user);
        preparedStatement.setString(2, admin_pwd);
//        执行select 语句 executeQuery
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

//        关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}

