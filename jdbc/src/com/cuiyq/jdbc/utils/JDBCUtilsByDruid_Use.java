package com.cuiyq.jdbc.utils;

import org.junit.Test;

import java.sql.*;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class JDBCUtilsByDruid_Use {

    @Test
    public void testSelect() {
        System.out.println("使用druid方式完成");
        // 1. 得到连接
        Connection connection = null;
//        2. 编写sql
        PreparedStatement preparedStatement = null;
        String sql = "select * from actor where id >= ?";

        ResultSet resultSet = null;
//        创建prepareStatement对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
//            执行
            resultSet = preparedStatement.executeQuery();
//             遍历该结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(connection, preparedStatement, resultSet);
        }
    }
}

