package com.cuiyq.interface_;

import org.junit.Test;

public class Exercise {
    public static void main(String[] args) {
        C_ c = new C_();
        c.test();
    }
}

interface A_ {
    int x = 1;
}

class B_ {
    int x = 2;
}

class C_ extends B_ implements A_ {

    public void test() {
        System.out.println("A_" + A_.x + ",B:" + super.x);
    }
}
