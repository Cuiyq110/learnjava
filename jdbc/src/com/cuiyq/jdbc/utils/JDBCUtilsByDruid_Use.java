package com.cuiyq.jdbc.utils;

import com.cuiyq.jdbc.utils.javabean.Actor;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 使用土方法把resulset封装成list集合
 */
@SuppressWarnings("all")
public class JDBCUtilsByDruid_Use {

    //    使用土方法来解决ResultSet=封装=》Arraylist
    @Test
    public void testSelectToArrayList() {
        System.out.println("使用druid方式完成");
//        1.得到连接
        Connection connection = null;
//        2.组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Actor> list = new ArrayList<>();
        
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
//            执行，得到结果集
            resultSet = preparedStatement.executeQuery();

//            遍历该结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                list.add(new Actor(id,name,sex,borndate,phone));
            }
//            System.out.println("list集合数据=" + list);
            for (Actor actor : list) {
//                System.out.println(actor);
                System.out.println("id=" + actor.getId() + "\t" + actor.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(connection,preparedStatement,resultSet);
        }
    }

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

