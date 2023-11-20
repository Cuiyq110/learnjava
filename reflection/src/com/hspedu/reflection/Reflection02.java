package com.hspedu.reflection;

import com.hspedu.Cat;
import org.junit.Test;
import org.w3c.dom.css.CSSStyleDeclaration;

import java.lang.reflect.Method;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 学习反射的优点和缺点
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }

//    测试反射性能

    /**
     * 方法m1：执行无参数的m1方法
     */
    public static void m1() {
        Cat cat = new Cat(); // 创建一个Cat对象
        long start = System.currentTimeMillis(); // 获取开始时间
        for (int i = 0; i < 900000000; i++) { // 循环900000000次
            // cat.hi(); // 执行Cat对象的hi方法
        }
        long end = System.currentTimeMillis(); // 获取结束时间
        System.out.println("m1:" + (end - start)); // 输出执行时间
    }

    /**
     * 方法m2的描述
     *
     * @throws Exception 抛出异常
     */
    public static void m2() throws Exception {
        Class cls = Class.forName("com.hspedu.Cat"); // 加载com.hspedu.Cat类的Class对象
        Object o = cls.newInstance(); // 创建com.hspedu.Cat类的实例对象
        Method method = cls.getMethod("hi"); // 获取com.hspedu.Cat类中名为"hi"的方法对象
        long start = System.currentTimeMillis(); // 记录开始时间
        for (int i = 0; i < 900000000; i++) { // 循环900000000次
            method.invoke(o); // 调用实例对象的"hi"方法
        }
        long end = System.currentTimeMillis(); // 记录结束时间
        System.out.println("m2:" + (end - start)); // 输出方法执行时间
    }

        /**
     * 方法m3，反射调用优化 + 关闭访问检查
     * @throws Exception 异常处理
     */
    public static void m3() throws Exception {
        Class cls = Class.forName("com.hspedu.Cat"); // 加载com.hspedu.Cat类的Class对象
        Object o = cls.newInstance(); // 创建com.hspedu.Cat类的实例对象
        Method method = cls.getMethod("hi"); // 获取com.hspedu.Cat类中名为"hi"的方法对象
        method.setAccessible(true);
        long start = System.currentTimeMillis(); // 记录开始时间
        for (int i = 0; i < 900000000; i++) { // 循环900000000次
            method.invoke(o); // 调用实例对象的"hi"方法
        }
        long end = System.currentTimeMillis(); // 记录结束时间
        System.out.println("m3:" + (end - start)); // 输出方法执行时间
    }






}
