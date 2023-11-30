package com.cuiyq.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 演示c3p0的使用
 */
@SuppressWarnings("all")
public class C3p0 {


//    方式1:相关参数，在程序中指定user，URL，password，
    @Test
    public void testC3p0_01() throws Exception{
//        创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        通过配置文件mysql.properties获取相关参数
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//mysql.properties"));
//        读取相关的属性值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

//        给数据源 comboPooledDataSource 设置相关的参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

//        设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50);
//        测试连接池的效率，测试对mysql5000次操作
        long start = System.currentTimeMillis();
        System.out.println("开始连接");
        for (int i = 0; i < 1000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 5000次连接mysql 耗时=" + (end - start));//c3p0 5000次连接mysql 耗时=3585

    }


//    方式2 使用配置文件模板来完成
    @Test
    public void testC3p0_02() throws Exception{
//        创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0");

//        测试5000次连接mysql
        long start = System.currentTimeMillis();
        System.out.println("开始执行2222");
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0的第二种方式：" + (end - start)); //c3p0的第二种方式：3845

    }

}
