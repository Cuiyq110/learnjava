package com.cuiyq.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 学习druid的使用
 */
@SuppressWarnings("all")
public class Druid_ {

    @Test
    public void testDruid_01() throws Exception {
//      1. 加入 Druid jar 包
//      2. 加入 配置文件 druid.properties , 将该文件拷贝项目的 src 目录
//      3. 创建 Properties 对象, 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//druid.properties"));

//        创建一个执定参数的数据库连接池，Druid 连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
         //耗时：15705 五百万：17718

    }
}
