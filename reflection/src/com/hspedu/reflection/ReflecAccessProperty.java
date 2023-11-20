package com.hspedu.reflection;

import java.lang.reflect.Field;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:演示反射操作属性
 * 2023.11.15
 */
@SuppressWarnings("all")
public class ReflecAccessProperty {
    public static void main(String[] args) throws Exception{

//        得到Student类对应的对象
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        Object o = stuClass.newInstance();
        System.out.println(o.getClass()); //Student
        System.out.println(stuClass.getName());
        System.out.println(stuClass.getClass()); // Class

//        使用反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o,20);
        System.out.println(age.get(o));
        System.out.println(o);

        System.out.println("=========");
//        通过反射得到私有属性
        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"Cuiyq");
        System.out.println(o);
        System.out.println(name.get(o));
        System.out.println(age.get(o));
        System.out.println(o);

        System.out.println("======");
        System.out.println(name.get(o));
        System.out.println("name.getClass:" + name.getClass()); //运行类型是filed
        System.out.println("name.getName:" +  name.getName());
    }
}

class Student {//类
    public int age;
    private static String name;

    public Student() {//构造器
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}