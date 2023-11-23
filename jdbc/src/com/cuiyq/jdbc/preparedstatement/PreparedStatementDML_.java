package com.cuiyq.jdbc.preparedstatement;

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
 * describe: 预处理插入数据 ,修改，删除
 */
@SuppressWarnings("all")
public class PreparedStatementDML_ {
    Scanner scanner = new Scanner(System.in);

    /**
     * 插入数据
     * @throws Exception
     */

    @Test
    public void insert() throws Exception {
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
        String sql = "insert into admin values (?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//      给?赋值
        preparedStatement.setString(1, admin_user);
        preparedStatement.setString(2, admin_pwd);
//        执行select 语句 executeQuery
        int resultSet = preparedStatement.executeUpdate();
        System.out.println(resultSet > 0 ? "success" : "fail");

//        关闭连接
        preparedStatement.close();
        connection.close();
    }

    /**
     *  修改数据
     * @throws Exception
     */
    @Test
    public void alter() throws Exception {
        String admin_pwd = "";
        String admin_user = "";
//      用户输入用户名和密码
        System.out.println("input name:");
        admin_user = scanner.nextLine();
        System.out.println("input pwd");
        admin_pwd = scanner.nextLine();

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
        String sql = "UPDATE admin SET pwd = ? WHERE NAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//      给?赋值
        preparedStatement.setString(2, admin_user);
        preparedStatement.setString(1, admin_pwd);
//        执行select 语句 executeQuery
        int resultSet = preparedStatement.executeUpdate();
        System.out.println(resultSet > 0 ? "success" : "fail");

//        关闭连接
        preparedStatement.close();
        connection.close();
    }

    /**
     *  删除 name = emm 的数据
     * @throws Exception
     */

    @Test
    public void delete() throws Exception {


        String admin_user = "";
//      用户输入用户名和密码
        System.out.println("input name:");
        admin_user = scanner.nextLine();

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
        String sql = "DELETE FROM admin WHERE NAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//      给?赋值
        preparedStatement.setString(1, admin_user);
//        执行select 语句 executeQuery
        int resultSet = preparedStatement.executeUpdate();
        System.out.println(resultSet > 0 ? "success" : "fail");

//        关闭连接
        preparedStatement.close();
        connection.close();
    }
}
