package com.cuiyq.enum_;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 11.8
 * 学习枚举关键字enum
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season_.SPRING);
        System.out.println(Season_.SUMMER);
    }
}
enum Season_ {
    SPRING("春天","温暖"),SUMMER("夏天", "炎热");
    private String name;
    private String description; //天气描述

    private Season_(String name, String description) {
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
        return "Season_{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
