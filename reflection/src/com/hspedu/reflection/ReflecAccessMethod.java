package com.hspedu.reflection;

import java.lang.reflect.Method;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:演示通过反射调用方法
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws Exception{
//        得到Boss类的对应对象
        Class<?> aClass = Class.forName("com.hspedu.reflection.Boss");
        Object o = aClass.newInstance();
//        调用hi方法
        Method method = aClass.getMethod("hi", String.class);
        method.invoke(o,"cuiyq");

        Method method1 = aClass.getDeclaredMethod("say", int.class, String.class, char.class);
        method1.setAccessible(true);
        Object invoke =   method1.invoke(o, 10, "杨莹", 'f');
        System.out.println(invoke);
        System.out.println(invoke.getClass());
    }
}

class Monster {}
class Boss {//类
    public int age;
    private static String name;

    public Boss() {//构造器
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) {//静态方法
        return n + " " + s + " " + c;
    }

    public void hi(String s) {//普通public方法
        System.out.println("hi " + s);
    }
}