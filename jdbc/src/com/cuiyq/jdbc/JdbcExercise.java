package com.cuiyq.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class JdbcExercise {
    @Test
    public  void test() throws Exception {
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
        Statement statement = connection.createStatement();
//        建表
        String sql1 = "CREATE TABLE new( id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,name varchar(25), tel varchar(25)) AUTO_INCREMENT = 1";
//        添加数据
        String sql2 = "INSERT INTO new VALUES(null,'cuiyq','123'),(null,'杨莹','143'),(null,'fs','145')";
//        删除表
        String sql3 = "drop table new";
//        查询actor表
        String sql4 = "select * from actor";
        ResultSet resultSet = statement.executeQuery(sql4);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date borndate = resultSet.getDate(4);
            String phone = resultSet.getString(5);
            System.out.println(id + " \t" + name + " \t" + sex + " \t" + borndate + " \t" + phone);
        }

//        int rows = statement.executeUpdate(sql2);
//        System.out.println(rows > 0 ? "成功" : "失败");
        System.out.println("执行完成");

        connection.close();

    }
}
