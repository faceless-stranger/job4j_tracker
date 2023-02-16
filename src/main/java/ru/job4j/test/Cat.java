package ru.job4j.test;

public class Cat extends Animal {

    @Override
    public void instanceInvoke() {
        System.out.println("не статический я  Cat");
    }

    public static void staticInvoke() {
        System.out.println("статический я Cat");
    }
}