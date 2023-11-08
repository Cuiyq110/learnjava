package com.cuiyq.interface_;

import org.junit.Test;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(getName() + "爬树");
    }

}

interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

class LittleMonkey extends Monkey implements Fishable,Birdable {

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "学会了游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "学会了飞翔");
    }
}

