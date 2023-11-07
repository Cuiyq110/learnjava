package com.cuiyq.interface_;

public class Interface033 {

    public static void main(String[] args) {

    }
}

interface A {

}

class A1 {
    public final int n1 = 3;
    static int n2 = 3;
}
class B1 extends A1 {

}
class C1 {
    public void f1() {
        B1 b1 = new B1();
        int num = b1.n1;

        int num1 = B1.n2;
        int num2 = A1.n2;
    }
}


