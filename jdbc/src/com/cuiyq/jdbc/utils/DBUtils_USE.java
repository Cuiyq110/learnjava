package com.cuiyq.jdbc.utils;

import com.cuiyq.jdbc.JdbcConnect;
import com.cuiyq.jdbc.utils.javabean.Actor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 使用apache-DButils工具类 + druid完成对表的crud操作
 */

@SuppressWarnings("all")
public class DBUtils_USE {


    //    演示apche-dbutils + druid 完成dml（update，insert，delete）操作
    @Test
    public void testDML() throws Exception {
        //获取数据库连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        //dml
        String sql3 = "delete from actor where id in (?,?)";
        String sql1 = "insert into actor(id,name,sex) values(null,?,?)";
        String sql = "update actor set name = ? where id = ?";
        int affectedRows = 0;
        for (int i = 0; i < 10; i++) {
            affectedRows = queryRunner.update(connection, sql1, ("图书"+ (i+1)), "男");
        }
//        affectedRows = queryRunner.update(connection, sql, "cuiyq1", 13);
//        affectedRows = queryRunner.update(connection, sql1, "cuiyq1", "男");
//        affectedRows = queryRunner.update(connection, sql3, 13, 15);
        System.out.println(affectedRows >= 0 ? "update success" : "未操作到数据库");

        //查询操作
        String sql2 = "select * from actor";
        List<Actor> list = queryRunner.query(connection, sql2, new BeanListHandler<Actor>(Actor.class));
        for (Actor actor : list) {
            System.out.println(actor);
        }
        //关闭连接
        JDBCUtilsByDruid.close(connection, null, null);
    }


    //演示 apache-dbutils + druid 完成查询结果是单行单列-返回的就是 object
    @Test
    public void testScalar() throws Exception {
        // 获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 定义sql
        String sql = "select name from actor where id = ?";
        // 执行查询，并传入ScalarHandler，参数为2
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 2);
        // 打印查询结果
        System.out.println(obj);
        // 关闭连接
        JDBCUtilsByDruid.close(connection, null, null);
    }


    //    完成 apache-dbutils + druid完成返回的结果时候单行记录(单个对象)
    @Test
    public void testQuerySingle() throws Exception {
//        得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
//        使用DBUtil类和接口，
//        创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
//        执行相关的方法，返回ArrayList结果集
        String sql = "select * from actor where id =?";
//        sql语句也可以查询不分裂
        String sql1 = "select id, name from actor where id =?";

//        返回单行记录--单个对象，使用的是Hander是BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(actor);

//        释放资源
        JDBCUtilsByDruid.close(connection, null, null);
    }

    @Test
    public void testQueryMany() throws Exception {
//        得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
//        使用DBUtil类和接口，
//        创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
//        执行相关的方法，返回ArrayList结果集
        String sql = "select * from actor where id >= ?";
//        sql语句也可以查询不分裂
        String sql1 = "select id, name from actor where id >= ?";
//        query方法就是执行sql语句，得到resultset -- 封装到 -- ArrayList集合中
        List<Actor> list =
                queryRunner.query(connection, sql1, new BeanListHandler<>(Actor.class), 1);
        for (Actor actor : list) {
            System.out.println(actor);
        }

//        释放资源
        JDBCUtilsByDruid.close(connection, null, null);
        System.out.println("执行结束");

    }
}
