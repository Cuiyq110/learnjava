package com.hspedu.reflection.classload_;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 演示类加载器
 */
public class ClassLoad01 {
    public static void main(String[] args) {

        System.out.println(new A().n2);
    }
}

class A {

    public A() {
        System.out.println("A（）构造器被执行");
        n2 = 30;
    }

    static {
        System.out.println("A 静态代码块被执行");
        n2 = 100;
    }
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;

}
