package com.cuiyq.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 基于druid数据库连接池的工具类
 */
public class JDBCUtilsByDruid {

    private static DataSource ds;

    //    在静态代码块中完成ds初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src//druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //编写把Connection对象放回连接池的方法
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

