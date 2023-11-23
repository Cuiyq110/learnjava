package com.cuiyq.jdbc.utils;

import java.sql.*;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class JDBCUtils {

    //    定义相关的属性
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //    static代码块中初始化
    static {

        try {
//       加载驱动
            Class.forName(driver);
            Properties properties = new Properties();
//        读取相关的值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //    连接数据库，返回Connection
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    关闭连接
    public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
