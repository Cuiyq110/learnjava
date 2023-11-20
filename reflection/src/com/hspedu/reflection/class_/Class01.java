package com.hspedu.reflection.class_;

import com.hspedu.Car;
import com.hspedu.Cat;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class Class01 {
    public static void main(String[] args) throws Exception {
        String classAllPath = "com.hspedu.Car";
//        System.out.println(classAllPath);
        //获取到Car类的CLass对象
        Class<?> cls = Class.forName(classAllPath);
        System.out.println(cls);
        System.out.println(cls.getClass());
//        得到包名
        System.out.println(cls.getPackage());
//        得到全类名
        System.out.println("得到全类名：" + cls.getClass());
//       通过cls创建对象实例
        Object o = cls.newInstance(); //运行类型是Car
        Car car = (Car) o;
        System.out.println(car.getClass());
        System.out.println(o.getClass());

        System.out.println("+++++++");
        Field brand =cls.getField("brand"); //获得属性
        System.out.println(brand.get(o));

//        获得属性数组
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.get(o));
        }

    }
}

