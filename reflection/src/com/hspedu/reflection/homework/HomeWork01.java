package com.hspedu.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class HomeWork01 {
    /**
     * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
     * 提供getName的公有方法
     * 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值
     */
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.hspedu.reflection.homework.PrivateTest");
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"杨莹");
        Method method = aClass.getMethod("getName");
        System.out.println(method.invoke(o));
    }
}

class PrivateTest {
    private String name = "hellokitty";
    //默认无参构造器
    public String getName() {
        return name;
    }
}

