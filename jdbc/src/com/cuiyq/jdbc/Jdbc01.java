package com.cuiyq.jdbc;

import java.sql.Connection;

import com.mysql.jdbc.Driver;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 这是第一个 Jdbc 程序，完成简单的操作
 */
@SuppressWarnings("all")
public class Jdbc01 {
    public static void main(String[] args) throws Exception {

        Driver driver = new Driver();
        String url = "jdbc:mysql://120.55.125.187:3306/my_db?seUnicode=truue&characterEncoding=utf-8";
           Properties properties = new Properties();
           properties.setProperty("user", "root");
           properties.setProperty("password", "Cyq20020107.");
           Connection connect = driver.connect(url, properties);
           System.out.println(connect);
//        执行sql
//          String sql = "insert into actor values(null,'崔雨强','男','2002-01-07','17615168529')";
//           String sql = "insert into actor values(null,'杨莹', '女', '1999-08-27', '15804238423')";
//           String sql = "delete from actor where id in (7,8,9)";
        String sql = "update actor set name = '周星驰' where id = 12";
           Statement statement = connect.createStatement();
           int rows = statement.executeUpdate(sql);
           System.out.println(rows > 0 ? "插入成功" : "插入失败");

        statement.close();
        connect.close();
    }
}
