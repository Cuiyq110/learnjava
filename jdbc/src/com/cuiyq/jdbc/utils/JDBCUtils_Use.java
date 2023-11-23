package com.cuiyq.jdbc.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */

@SuppressWarnings("all")
public class JDBCUtils_Use {

    public static void main(String[] args) {
        new JDBCUtils_Use().testDML_update("王武",13);
    }
    public  void testDML_update(String name,int id) { //update
//        得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        sql语句
        String sql = "UPDATE actor SET name = ? WHERE id = ?";
//        建立连接，创建prepareStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    /**
     * 更新数据
     */
    @Test
    public void testDML_insert() { //insert
//        得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        sql语句
        String sql = "insert into actor(id,name,sex) values(null,?,?)";
//        建立连接，创建prepareStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"张三");
            preparedStatement.setString(2,"男");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
