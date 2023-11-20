package com.hspedu.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:演示如何通过反射获取类的结构信息
 */
@SuppressWarnings("all")
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException{
        Class<?> personCls= Class.forName("com.hspedu.reflection.Person");
        System.out.println(personCls.getName());
//        getDeclaredFields：获取本类中的所有属性
//        默认修饰符是0，public是1，protected 是4，private 是 2，static是8，final是16，volatile是32，transient是64
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性：" + declaredField.getName() +
                    "该属性的修饰符值：" + declaredField.getModifiers() +
                    "该属性的类型是：" + declaredField.getType());
        }

//        输出当前这个方法的形参数组情况
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中的所有方法:" + declaredMethod.getName() +
                    ",该方法的访问修饰符:" + declaredMethod.getModifiers() +
                    "该方法的返回类型:" + declaredMethod.getReturnType());

//            输出该方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型:" + parameterType);
            }
        }

//        getDeclaredConstructors：获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("========");
            System.out.println("person类中的所有构造器:" + declaredConstructor.getName());

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型:" + parameterType);
            }
        }
    }

//    第一组方法API
    @Test
    public void api_01() throws ClassNotFoundException, NoSuchMethodException{
        Class<?> personCls= Class.forName("com.hspedu.reflection.Person");
//      getName：获取全类名
        System.out.println(personCls.getName());
//      getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());
//        getFieds：获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的属性：" + field.getName());
        }
//        getDeclaredFieds：获取本类中的所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中的所有属性:" + declaredField.getName());
        }

        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类中公共构造器：" + constructor.getName());
        }

//        本类中所有构造器 getDeclaredConstructors
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器:" + declaredConstructor.getName());
        }
//        获取包名
        System.out.println(personCls.getPackage());

//       获取父类信息
        System.out.println(personCls.getSuperclass());
//        获取接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("获取接口信息：" + anInterface.getName());
        }
//        返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息:" + annotation);
        }
    }
}


class A {
    public String hobby;

    public void hi() {

    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    //私有的
    private Person(String name, int age) {

    }

    //方法
    public void m1(String name, int age, double sal) {

    }

    protected String m2() {
        return null;
    }

    void m3() {

    }

    private void m4() {

    }
}