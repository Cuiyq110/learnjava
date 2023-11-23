package com.cuiyq.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 练习连接jdbc的方式
 */
@SuppressWarnings("all")
public class JdbcConnect {
    public static void main(String[] args) {

    }

    //   方式1
    @Test
    public void test1() throws Exception {
        Driver driver = new Driver();
        String url = "jdbc:mysql://120.55.125.187:3306/my_db";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "Cyq20020107.");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //  第二种方式
    @Test
    public void test2() throws Exception {
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://120.55.125.187:3306/my_db";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "Cyq20020107.");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);

    }

    //  第三种方式连接
    @Test
    public void test3() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://120.55.125.187:3306/my_db";
        String user = "root";
        String password = "Cyq20020107.";
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式三：" + connection);
    }


    //    第四种方式连接
    @Test
    public void test4() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");  // 加载MySQL JDBC驱动程序
        String url = "jdbc:mysql://120.55.125.187:3306/my_db";  // 连接数据库的URL
        String user = "root";  // 数据库用户名
        String password = "Cyq20020107.";  // 数据库密码
        Connection connection = DriverManager.getConnection(url, user, password);  // 创建数据库连接对象
        System.out.println("第四种方式：" + connection);  // 打印数据库连接对象
    }


    //    第五种方式
    @Test
    public void test5() throws Exception {
//        通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//mysql.properties"));
//        获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第五种方式:" + connection);
    }

}
