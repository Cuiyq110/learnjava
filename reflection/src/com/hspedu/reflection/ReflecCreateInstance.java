package com.hspedu.reflection;

import java.lang.reflect.Constructor;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:演示通过反射机制创建实例
 */
public class ReflecCreateInstance {
    /**
     * 主程序入口，用于测试类的反射功能
     *
     * @param args 命令行参数
     * @throws Exception 反射过程中可能抛出异常
     */
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        // 根据类名获取Class对象
        Class<?> userClass = Class.forName("com.hspedu.reflection.User");
        System.out.println(userClass.getClass());
        // 创建类的实例对象
        Object o = userClass.newInstance();
        System.out.println(o);
        System.out.println(o.getClass());

        //3. 通过 public 的有参构造器创建实例
        /* constructor 对象就是
        public User(String name) {//public 的有参构造器
         this.name = name; }
          */
        Constructor<?> constructor = userClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("崔雨强");
        System.out.println(constructor.getName());
        System.out.println(constructor.getClass());
        System.out.println(o1);
        System.out.println(o);
        System.out.println(o1.getClass());

        System.out.println("===============");
        // 通过 private 的有参构造器创建实例
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class,String.class);
        constructor1.setAccessible(true);
        Object o2 = constructor1.newInstance(25, "杨莹");
        System.out.println("o2:" + o2);
    }

}

class User { //User类
    private int age = 10;
    private String name = "韩顺平教育";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}