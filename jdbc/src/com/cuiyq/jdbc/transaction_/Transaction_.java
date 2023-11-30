package com.cuiyq.jdbc.transaction_;

import com.cuiyq.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 使用事务解决上述问题-模拟经典的转账业务
 */
@SuppressWarnings("all")
public class Transaction_ {

    public static void main(String[] args) {

    }

    /**
     * 没有使用事务
     */
    @Test
    public void noTransaction() {
//        操作转账的业务
//        1.得到连接
        Connection connection = null;
        Statement statement = null;

//        2.组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 使用事务
     */
    @Test
    public void useTranSaction() {
//        操作转账的业务
//        1.得到连接
        Connection connection = null;
//        2.组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
//        3.创建PreparedStatement对象
        PreparedStatement preparedStatement = null;

        connection = JDBCUtils.getConnection();
        try {
            //关闭自动提交，创建事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
//            默认回滚到开始的状态
            try {
                System.out.println("回滚到最开始的状态");
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
