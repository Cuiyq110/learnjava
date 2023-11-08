package com.cuiyq.interface_;

/**
 * 演示多态传递现象
 */
public class InterfacePolyPass {
    public static void main(String[] args) {
        IH ih = new Teacher();
        IG ig = new Teacher();
    }
}

interface IH {
    void hi();
}

interface IG extends IH{

}

class Teacher implements IG {

    @Override
    public void hi() {

    }
}