package com.cuiyq.abstract_;

public class TestTemplate {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime();

        BB bb = new BB();
        bb.calculateTime();
    }
}

class AA extends Template {

    public void job() {
        int num = 0;
        for (int i = 0; i < 100000; i++) {
            num += i;
        }
    }
}

class BB extends Template {
    public void job() {

        int num = 1;
        for (int i = 0; i < 1000000; i++) {
            num *= i;
        }
    }
}


abstract class Template {

    public abstract void job();// 抽象类方法

    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("任务时间为：" + (end - start));
    }

}