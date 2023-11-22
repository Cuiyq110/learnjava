package com.cuiyq.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class JdbcTest {
    public static void main(String[] args) throws Exception{

            Driver driver = new Driver();
            String url = "jdbc:mysql://120.55.125.187:3306/my_db?seUnicode=truue&characterEncoding=utf-8";
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "Cyq20020107.");
            Connection connect = driver.connect(url, properties);
            System.out.println(connect);
//        执行sql
//            String sql = "insert into information values(null,'崔雨强','男','2002-01-07','17615168529','cuiyq107@gmail.com','辽宁省大连市瓦房店市怡景花园')";
//            String sql = "insert into information values(null,'杨莹', '女', '1999-08-27', '15804238423','2366501893@qq.com',' 辽宁省辽阳市灯塔市 ')";
           String sql = "delete from actor where id = 4";
            Statement statement = connect.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println(rows > 0 ? "插入成功" : "插入失败");

        statement.close();
        connect.close();
        System.out.println("执行完毕");
    }
    @Test
    public void test() {
        System.out.println(1 % 3);
        System.out.println(1 % 3);
    }
}
