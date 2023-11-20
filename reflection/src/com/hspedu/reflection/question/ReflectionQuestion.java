package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection/src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"
        System.out.println("classfullpath:" + classfullpath);
        System.out.println("methodName:" + methodName);
        System.out.println("=======");

//      加载类返回返回calss类型的对象
        Class cls = Class.forName(classfullpath);
//      通过cls得到你加载的类的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());
//      得到Cat类中的methoname‘hi'方法
        Method method1 = cls.getMethod(methodName);
//      方法中的invoke(对象)
        method1.invoke(o);




    }


}
