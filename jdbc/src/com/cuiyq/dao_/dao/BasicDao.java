package com.cuiyq.dao_.dao;

import com.cuiyq.dao_.domain.Actor;
import com.cuiyq.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 开发 BasicDAO , 是其他 DAO 的父类, 使用到 apache-dbutils
 */
@SuppressWarnings("all")
public class BasicDao<T> { //用泛型指定具体类型
    private QueryRunner queryRunner = new QueryRunner();

//    开发通用的dml方法，针对任意的表
    public int update(String sql,Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(connection,null,null);
        }
    }

    //    查询单行单列的方法,即返回单值的方法
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(connection, null, null);
        }

    }

    //  返回单行结果 的通用方法
    public T querySingle(String sql, Class<T> classzz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(classzz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(connection, null, null);
        }
    }


//   返回多个对象(即查询的结果是多行),针对任意表

    /**
     * @param sql        sql 语句，可以有 ?
     * @param claszz     传入一个类的 Class 对象 比如 Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 返回一个 List 集合
     */
    public List<T> queryMulti(String sql, Class<T> claszz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(claszz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(connection, null, null);
        }

    }


}
