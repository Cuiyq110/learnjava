package com.hspedu.reflection.class_;

import com.hspedu.Car;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 演示得到Class对象的各种方式
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

//        class.forName
        String classAllPath = "com.hspedu.Car";
        Class cls1 = Class.forName(classAllPath);
        //对象.class,应用场景：用于参数传递
        Car car = new Car();
        Class cls2 = car.getClass();
        System.out.println(cls1);

//      通过类名调用CLass对象
        Class cls3 = Car.class;
        System.out.println(cls2);

//      通过类加载器来获取到类的Class对象
//      先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
//      通过类加载器得到class对象
        Class cls4 = classLoader.loadClass(classAllPath);

        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

//      基本数据类型对应的包装类，可以通过.class获取到Class对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        System.out.println(integerClass.hashCode());
        System.out.println(type.hashCode());


    }
}
