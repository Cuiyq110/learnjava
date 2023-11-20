package com.hspedu.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class Reflection01 {


        @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        // 创建一个Properties对象，并从文件中加载属性文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection/src/re.properties"));

        // 获取属性文件中的classfullpath和methodName并转换为字符串
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"

        // 根据classfullpath获取Class对象，并创建一个实例对象o
        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();

        System.out.println("=======");
        // 使用getField方法获取私有属性，无法获取私有方法
        Field field = cls.getField("age");
        System.out.println(field.get(o)); // 获取属性值

        System.out.println("+++++++");
        // 获取无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        System.out.println("获取有参构造器：");
        // 获取带参数的构造器
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);


    }

}
