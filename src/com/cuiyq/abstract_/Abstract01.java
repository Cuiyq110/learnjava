package com.cuiyq.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
//        Animal animal = new Animal();

    }
}

abstract class Animal {
    private String name;

  public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    //    public abstract void eat();
    public void test()
    {
        System.out.println("hello");
    }

}

class Dog extends Animal {
    @Override
    public void test() {

    }
}

