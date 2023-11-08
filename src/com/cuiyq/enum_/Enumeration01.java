package com.cuiyq.enum_;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 11.8
 * 学习自定义枚举类
 */

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN);
        Season.test();

    }
}

//季节类
class Season {
    static int x = 3;
    private String name = null;//季节名称
    private String description = null; //季节描述

    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "炎热");

    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static void test()
    {
        System.out.println(x);
    }
}
