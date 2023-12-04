package com.cuiyq.jdbc.utils;

import com.cuiyq.jdbc.JdbcConnect;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 使用utils类更新，添加，查询数据
 */

@SuppressWarnings("all")
public class JDBCUtils_Use {

    @Test
    public void testSelect() {
//        得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        组织一个sql
        String sql = "SELECT * FROM actor";

        try {
            connection = JDBCUtils.getConnection();
            System.out.println("connection的运行类型：" + connection.getClass());
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,2);
//           执行得到结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id + " \t" + name + " \t" + sex + " \t" + borndate + " \t" + phone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }

    }



    public static void main(String[] args) {
       // new JDBCUtils_Use().testDML_update("王武",13);
        JDBCUtils_Use jdbcUtilsUse = new JDBCUtils_Use();
        System.out.println(JDBCUtils.getConnection());
        jdbcUtilsUse.testDML_insert();
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
            System.out.println(connection);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
           preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    /**
     * 更新数据
     */

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
            preparedStatement.setString(1,"111");
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
