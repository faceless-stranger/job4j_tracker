package ru.job4j.test;

public class Animal {
    public void instanceInvoke() {
        System.out.println("не статический я животеное");
    }

    public static void staticInvoke() {
        System.out.println("статического метода Animal");
    }
}