package com.cuiyq.jdbc.batch;

import com.cuiyq.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 演示Java的批处理
 */
public class Batch_ {


    //        传统方法， 添加 5000 条数据到admin2
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("没有使用批处理的时间：" + (end - start)); //没有使用批处理的时间：334243
//        关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }


    //    使用批处理，添加 2000 条数据到admin2

    @Test
    public void useBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            //将 sql 语句加入到批处理包中 -> 看源码
            preparedStatement.addBatch();
//            当有1000 条记录时，批量执行
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
//                清空
                preparedStatement.clearBatch();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("使用批处理方式耗时：" + (end - start)); //使用批处理方式耗时：868
    }


}


